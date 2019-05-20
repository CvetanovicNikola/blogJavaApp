package rs.cubes.blog.rest.response;

import rs.cubes.blog.domain.Rating;

public class RatingResponse extends RestResponse {
	
	private Rating rating;

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
}
	

