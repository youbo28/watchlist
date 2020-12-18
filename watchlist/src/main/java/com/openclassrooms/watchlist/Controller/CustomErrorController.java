package com.openclassrooms.watchlist.Controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.boot.web.servlet.error.ErrorController;

public class CustomErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

	@GetMapping("/error")
	public ModelAndView handelError(HttpServletResponse response) {
		int code = response.getStatus();
		System.out.println("the error code is " + code);
		return new ModelAndView("error");
	}
}
