package rs.cubes.blog.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import rs.cubes.blog.domain.Rating;
import rs.cubes.blog.rest.response.RatingResponse;
import rs.cubes.blog.rest.response.RatingsResponse;
import rs.cubes.blog.rest.response.RestResponse;
import rs.cubes.blog.service.RatingService;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;


@Path("rating")
public class RatingResource {
	
	@EJB
	private RatingService ratingService;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public RatingResponse createRating(Rating rating) {
		
		RatingResponse response = new RatingResponse();
		
		try {
			Rating r = ratingService.createRating(rating);
			
			response.setRating(r);
			response.setErrorCode(ErrorMessage.ok);
			return response;
			
		} catch(PersistenceException pe) {
			
			response.setErrorCode(ErrorMessage.dBError);
			return response;
			
		} catch(AppException ae) {
			
			 response.setErrorCode(ae.getError());
			 return response;
		}	
	}
	
	@GET
	@Produces("application/json")
	public RatingsResponse getAll(@QueryParam("tag") String ratingParam, 
			@QueryParam("like") boolean likeParam) {
		
		RatingsResponse response = new RatingsResponse();
		
		try {
			List<Rating> r = ratingService.getAllRatings();
			
			response.setRatings(r);
			response.setErrorCode(ErrorMessage.ok);
			return response;
			
		} catch(PersistenceException pe) {
			
			response.setErrorCode(ErrorMessage.dBError);
			return response;
			
		} catch(AppException ae) {
			
			response.setErrorCode(ae.getError());
			return response; 
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public RatingResponse getTag(@PathParam("id") long id) {
		
		RatingResponse response = new RatingResponse();
		
		try {
			Rating r = ratingService.getRatingById(id);
			
			response.setRating(r);
			response.setErrorCode(ErrorMessage.ok);
			return response;
			
		} catch(PersistenceException pe) {
			
			response.setErrorCode(ErrorMessage.dBError);
			return response;
			
		} catch(AppException ae) {
			
			response.setErrorCode(ae.getError());
			return response; 
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public RatingResponse updateRating(@PathParam("id") long id, Rating rating) {
		
		RatingResponse response = new RatingResponse();
		
		try {
			Rating r = ratingService.updateRating(id, rating);
			
			response.setRating(r);
			response.setErrorCode(ErrorMessage.ok);
			return response;
			
		} catch(PersistenceException pe) {
			
			response.setErrorCode(ErrorMessage.dBError);
			return response;
			
		} catch(AppException ae) {
			
			response.setErrorCode(ae.getError());
			return response; 
		}	
	}
	
	@DELETE
	@Path("/{id}")
	public RestResponse deleteRating(@PathParam("id") long id) {
		
		RestResponse response = new RestResponse();
		
		try {
			ratingService.deleteRating(id);
			
			response.setErrorCode(ErrorMessage.ok);
			return response;
			
		} catch(PersistenceException pe) {
			
			response.setErrorCode(ErrorMessage.dBError);
			return response;
			
		} catch(AppException ae) {
			
			response.setErrorCode(ae.getError());
			return response; 
		}	
	}

}