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

import rs.cubes.blog.domain.Comment;
import rs.cubes.blog.rest.response.CommentResponse;
import rs.cubes.blog.rest.response.CommentsResponse;
import rs.cubes.blog.rest.response.RestResponse;
import rs.cubes.blog.service.CommentService;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;



@Path("comment")
public class CommentResource {
	
	@EJB
	private CommentService commentService;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public CommentResponse createComment(Comment comment) {
		
		CommentResponse response = new CommentResponse();
		
		try {
			Comment c = commentService.createComment(comment);
			
			response.setComment(c);
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
	public CommentsResponse getAll(@QueryParam("comment") String commentParam, 
			@QueryParam("like") boolean likeParam) {
		
		CommentsResponse response = new CommentsResponse();
		
		try {
			List<Comment> c = commentService.getAll(commentParam, likeParam);
			
			response.setComments(c);
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
	public CommentResponse getComment(@PathParam("id") long id) {
		
		CommentResponse response = new CommentResponse();
		
		try {
			Comment c = commentService.getComment(id);
			
			response.setComment(c);
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
	public CommentResponse updateComment(@PathParam("id") long id, Comment comment) {
		
		CommentResponse response = new CommentResponse();
		
		try {
			Comment c = commentService.updatecomment(id, comment);
			
			response.setComment(c);
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
	public RestResponse deleteComment(@PathParam("id") long id) {
		
		RestResponse response = new RestResponse();
		
		try {
			commentService.deleteComment(id);
			
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