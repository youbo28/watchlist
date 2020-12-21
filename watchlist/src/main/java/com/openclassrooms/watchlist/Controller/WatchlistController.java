package com.openclassrooms.watchlist.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.openclassrooms.watchlist.Domain.WatchlistItem;
import com.openclassrooms.watchlist.Exception.DublicateTileException;
import com.openclassrooms.watchlist.Service.impl.WatchlistServiceImpl;

@Controller
public class WatchlistController {
	private WatchlistServiceImpl watchlistService;

	@Autowired
	public WatchlistController(WatchlistServiceImpl watchlistService) {
		super();
		this.watchlistService = watchlistService;
	}

	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		String viewname = "watchlist";
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("watchlistitems", watchlistService.getWatchlistItems());
		model.put("watchlistsize", watchlistService.getWatchlistSize());
		return new ModelAndView(viewname, model);

	}

	@GetMapping("/watchlistItemForm")
	public ModelAndView getWatchlistItemForm(@RequestParam(required = false) Integer id) {
		String viewname = "watchlistItemForm";
		WatchlistItem watchlistItem = watchlistService.findItemById(id);
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("the id is = " + id);

		if (watchlistItem == null) {
			model.put("watchlistItem", new WatchlistItem());

		} else {
			model.put("watchlistItem", watchlistItem);
		}

		return new ModelAndView(viewname, model);

	}

	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchlistitemform(@Valid WatchlistItem watchlistItem, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("you are in error");
			return new ModelAndView("watchlistItemForm");
		}
		System.out.println("you are not in error");
		try {
			watchlistService.addOrUbdateWatchlistItem(watchlistItem);
		} catch (DublicateTileException e) {
			bindingResult.rejectValue("title", "", "this movie is already exist");
			return new ModelAndView("watchlistItemForm");

		}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/watchlist");
		return new ModelAndView(redirectView);
	}

}
