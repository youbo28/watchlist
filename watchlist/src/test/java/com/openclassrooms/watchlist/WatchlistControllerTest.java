package com.openclassrooms.watchlist;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import ch.qos.logback.core.status.Status;

@WebMvcTest
@RunWith(SpringRunner.class)

public class WatchlistControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void TestShowWatchlistItemForm() throws Exception {
		mockMvc.perform(get("/watchlistItemForm"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("watchlistItemForm"))
		.andExpect(model().size(1))
		.andExpect(model().attributeExists("watchlistItem"));

	}

	@Test
	public void TestSubmiteWatchlistItemForm() throws Exception{
		mockMvc.perform(post("/watchlistItemForm"))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/watchlist"));
	}
}
