
package rs.cubes.blog.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import rs.cubes.blog.domain.User;
import rs.cubes.blog.dto.UserDTO;
import rs.cubes.blog.rest.response.RestResponse;
import rs.cubes.blog.rest.response.UserResponse;
import rs.cubes.blog.rest.response.UsersResponse;
import rs.cubes.blog.service.ArticleService;
import rs.cubes.blog.service.UserService;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;



@Path("user")
public class UserResource {
	
	@EJB
	private UserService userService;
	@EJB
	private ArticleService articleService;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public UserResponse createUser(UserDTO user) {
		
		UserResponse response = new UserResponse();
		
		try {
//			Set<Long> articleID = new HashSet<>();
//			for(ArticleDTO a : user.getArticles()) {
//				articleID.add(a.getId());
//			}
//			
//			Set<Article> a = new HashSet<>();
//			for(Long id: articleID) {
//				a.add(articleService.getArticle(id));
//			}
			
			User u = new User(user);
			u = userService.createUser(u);
			
			response.setUser(new UserDTO(u));
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
//	@Produces("application/json")
//	public UsersResponse getAll(@QueryParam("user") String userParam, 
//			@QueryParam("like") boolean likeParam) {
//		
//		UsersResponse response = new UsersResponse();
//		
//		try {
//			List<User> u = userService.getAllUsers(userParam, likeParam);
//			
//			response.setUsers(u);
//			response.setErrorCode(ErrorMessage.ok);
//			return response;
//			
//		} catch(PersistenceException pe) {
//			
//			response.setErrorCode(ErrorMessage.dBError);
//			return response;
//			
//		} catch(AppException ae) {
//			
//			response.setErrorCode(ae.getError());
//			return response; 
//		}
//	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public UserResponse getUser(@PathParam("id") long id) {
		
		UserResponse response = new UserResponse();
		
		try {
			User u = userService.getUser(id);
			
			UserDTO uDTO = null;
			if (u != null) {
				uDTO = new UserDTO(u);
			}
			
			response.setUser(uDTO);
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
	public UserResponse updateUser(@PathParam("id") long id, User user) {
		
		UserResponse response = new UserResponse();
		
		try {
			User u = userService.updateUser(id, user);
			
			UserDTO uDTO = null;
			if (u != null) {
				uDTO = new UserDTO(u);
			}
			
			response.setUser(uDTO);
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
	public RestResponse deleteUser(@PathParam("id") long id) {
		
		RestResponse response = new RestResponse();
		
		try {
			userService.deleteUser(id);
			
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
