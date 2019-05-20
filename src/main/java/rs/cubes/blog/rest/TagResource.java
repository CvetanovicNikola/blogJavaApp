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

import rs.cubes.blog.domain.Tag;
import rs.cubes.blog.rest.response.RestResponse;
import rs.cubes.blog.rest.response.TagsResponse;
import rs.cubes.blog.service.TagService;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;



@Path("tag")
public class TagResource {
	
	@EJB
	private TagService tagService;
	
//	@POST
//	@Consumes("application/json")
//	@Produces("application/json")
//	public TagResponse createTag(Tag tag) {
//		
//		TagResponse response = new TagResponse();
//		
//		try {
//			Tag t = tagService.createTag(tag);
//			
//			response.setTag(t);
//			response.setErrorCode(ErrorMessage.ok);
//			return response;
//			
//		} catch(PersistenceException pe) {
//			
//			response.setErrorCode(ErrorMessage.db_problem);
//			return response;
//			
//		} catch(AppException ae) {
//			
//			 response.setErrorCode(ae.getError());
//			 return response;
//		}	
//	}
	
	@GET
	@Produces("application/json")
	public TagsResponse getAll(@QueryParam("tag") String title, 
			@QueryParam("like") boolean like) {
		
		TagsResponse response = new TagsResponse();
		
		try {
			List<Tag> t = tagService.getAllTags(title, like);
			
			response.setTags(t);
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
	
//	@GET
//	@Path("/{id}")
//	@Produces("application/json")
//	public TagResponse getTag(@PathParam("id") long id) {
//		
//		TagResponse response = new TagResponse();
//		
//		try {
//			Tag t = tagService.getTag(id);
//			
//			response.setTag(t);
//			response.setErrorCode(ErrorMessage.ok);
//			return response;
//			
//		} catch(PersistenceException pe) {
//			
//			response.setErrorCode(ErrorMessage.db_problem);
//			return response;
//			
//		} catch(AppException ae) {
//			
//			response.setErrorCode(ae.getError());
//			return response; 
//		}
//	}
	
//	@PUT
//	@Path("/{id}")
//	@Consumes("application/json")
//	@Produces("application/json")
//	public TagResponse updateTag(@PathParam("id") long id, Tag tag) {
//		
//		TagResponse response = new TagResponse();
//		
//		try {
//			Tag t = tagService.updateTag(id, tag);
//			
//			response.setTag(t);
//			response.setErrorCode(ErrorMessage.ok);
//			return response;
//			
//		} catch(PersistenceException pe) {
//			
//			response.setErrorCode(ErrorMessage.db_problem);
//			return response;
//			
//		} catch(AppException ae) {
//			
//			response.setErrorCode(ae.getError());
//			return response; 
//		}	
//	}
	
	@DELETE
	@Path("/{id}")
	public RestResponse deleteTag(@PathParam("id") long id) {
		
		RestResponse response = new RestResponse();
		
		try {
			tagService.deleteTag(id);
			
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