package rs.cubes.blog.rest.response;

import java.util.List;

import rs.cubes.blog.domain.Rating;

public class RatingsResponse extends RestResponse {
	
	private List<Rating> ratings;

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	

}