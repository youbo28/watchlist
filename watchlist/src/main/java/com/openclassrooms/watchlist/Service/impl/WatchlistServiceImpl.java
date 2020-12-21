package com.openclassrooms.watchlist.Service.impl;

import com.openclassrooms.watchlist.Domain.WatchlistItem;
import com.openclassrooms.watchlist.Exception.DublicateTileException;
import com.openclassrooms.watchlist.Repository.WatchlistRepository;
import com.openclassrooms.watchlist.Service.MovieRatingService;
import com.openclassrooms.watchlist.Service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {
	WatchlistRepository watchlistRepository;
	MovieRatingService movieRatingService;

	@Autowired
	public WatchlistServiceImpl(WatchlistRepository watchlistRepository, MovieRatingService movieRatingService) {
		super();
		this.watchlistRepository = watchlistRepository;
		this.movieRatingService = movieRatingService;
	}

	public List<WatchlistItem> getWatchlistItems() {
		List<WatchlistItem> watchlistItems = watchlistRepository.getList();

		for (WatchlistItem watchlistItem : watchlistItems) {
			String rating = movieRatingService.getMovieRating(watchlistItem.getTitle());
			if (rating != null) {
				watchlistItem.setRating(rating);
			}
		}
		return watchlistItems;
	}

	public int getWatchlistSize() {
		return watchlistRepository.getList().size();
	}

	public WatchlistItem findItemById(Integer id) {
		return watchlistRepository.findItemBYId(id);
	}

	public void addOrUbdateWatchlistItem(WatchlistItem watchlistItem) throws DublicateTileException {
		WatchlistItem existingitem = findItemById(watchlistItem.getId());
		if (existingitem == null) {
			if (watchlistRepository.findItemBYTitle(watchlistItem.getTitle()) != null) {
				throw new DublicateTileException();
			}
			watchlistRepository.addItem(watchlistItem);

		} else {
			existingitem.setComment(watchlistItem.getComment());
			existingitem.setPriority(watchlistItem.getPriority());
			existingitem.setTitle(watchlistItem.getTitle());
			existingitem.setRating(watchlistItem.getRating());
		}
	}

}
