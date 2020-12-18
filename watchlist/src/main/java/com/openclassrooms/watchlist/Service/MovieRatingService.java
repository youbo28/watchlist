package com.openclassrooms.watchlist.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;
@Service
public class MovieRatingService {
	private String url = "http://www.omdbapi.com/?apikey=d44e7c6a&t=";

	public String getMovieRating(String title) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ObjectNode> respons = restTemplate.getForEntity(url + title, ObjectNode.class);
			ObjectNode jasonObject = respons.getBody();
			System.out.println(jasonObject.asText());
			return jasonObject.path("imdbRating").asText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("somting went wrong whe we called Imdbapi" + e.getMessage());
			return null;
		}
	}
}
