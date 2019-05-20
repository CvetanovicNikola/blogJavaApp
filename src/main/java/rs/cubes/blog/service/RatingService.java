package rs.cubes.blog.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.cubes.blog.domain.Rating;
import rs.cubes.blog.domain.User;
import rs.cubes.blog.domain.queries.RatingQueries;
import rs.cubes.blog.domain.queries.UserQueries;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;

@Stateless
public class RatingService {
	
	@PersistenceContext
	EntityManager em;
	
	
	  
	public Rating updateRating(long id, Rating rating) {
		if(rating.getRating() < 0 || rating.getRating() > 5) {
			throw new AppException(ErrorMessage.invalidRating);
		}
		Rating r1 = RatingQueries.getRatingById(em, id);
		if(r1 == null) {
			return createRating(rating);
		}
		Rating r2 = RatingQueries.getRatingById(em, rating.getId());
		
		r1.setRating(r2.getRating());
		return r1;
	}
	
	public Rating createRating(Rating rating) {
		em.persist(rating);
		return rating;
	}
	public List<Rating> getAllRatings(){
		List<Rating> ratings = RatingQueries.getAllRatings(em);
		return ratings;
	}
	public Rating getRatingById(long id) {
		Rating r = em.find(Rating.class, id);
		if(r == null) {
			throw new AppException(ErrorMessage.noSuchRating);
		}
		return r;
	}
	public void deleteRating(long id) {
		Rating r = RatingQueries.getRatingById(em, id);
			if (r == null) {
				throw new AppException(ErrorMessage.noSuchRating);
			}
			em.remove(r);
		}
}
