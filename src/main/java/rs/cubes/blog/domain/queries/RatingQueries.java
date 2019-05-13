package rs.cubes.blog.domain.queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import rs.cubes.blog.domain.Rating;

public class RatingQueries {
	
	public static Rating getRatingById(EntityManager em, long id) {
		return em.find(Rating.class, id);
	}
	public static List<Rating> getAllRatings(EntityManager em){
		String q = "select r from Rating r";
		TypedQuery<Rating> query = em.createQuery(q, Rating.class);
		List<Rating>l = query.getResultList();
		return l;
				
	}
	

}
