package com.openclassrooms.watchlist.Domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.openclassrooms.watchlist.Validation.GoodMovie;
import com.openclassrooms.watchlist.Validation.Prioirity;
import com.openclassrooms.watchlist.Validation.Rating;

@GoodMovie
public class WatchlistItem {
	private Integer id;

	@NotBlank(message = "the title cannot be blank")
	private String title;
	@NotBlank
	@Rating
	private String rating;
	@Prioirity
	private String priority;

	@Size(max = 50, message = "the comment must not contain more than 50 charachtre")
	private String comment;

	public static int index = 0;

	public WatchlistItem() {
		// TODO Auto-generated constructor stub
		this.id = index++;
	}

	public WatchlistItem(String title, String rating, String priority, String comment) {
		super();
		this.id = index++;
		this.title = title;
		this.rating = rating;
		this.priority = priority;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
