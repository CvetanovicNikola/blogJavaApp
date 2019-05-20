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

import rs.cubes.blog.domain.Article;
import rs.cubes.blog.domain.User;
import rs.cubes.blog.dto.ArticleDTO;
import rs.cubes.blog.rest.response.ArticleResponse;
import rs.cubes.blog.rest.response.ArticlesResponse;
import rs.cubes.blog.rest.response.RestResponse;
import rs.cubes.blog.service.ArticleService;
import rs.cubes.blog.service.TagService;
import rs.cubes.blog.service.UserService;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;



@Path("article")
public class ArticleResource {
	
	@EJB
	private ArticleService articleService;
	@EJB
	private TagService tagService;
	@EJB
	private UserService userService;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public ArticleResponse createArticle(ArticleDTO article) {
		
		ArticleResponse response = new ArticleResponse();
		
		try {
//			Set<Long> tagID = new HashSet<>();
//			for(TagDTO t : article.getTags()) {
//				if (t != null) {
//				tagID.add(t.getId());
//				}
//			}
			
			long userID = article.getUser().getId();
			
//			Set<Tag> t = new HashSet<>();
//			for(Long id: tagID) {
//				t.add(tagService.getTag(id));
//			}
			User u = userService.getUser(userID);
			
			Article a = new Article(article);
			a = articleService.createArticle(a, u);
			response.setArticle(new ArticleDTO(a));
			
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
	public ArticlesResponse getAll(@QueryParam("article") String title, 
			@QueryParam("like") boolean like) {
		
		ArticlesResponse response = new ArticlesResponse();
		
		try {
			List<Article> a = articleService.getAllArticles(title, like);
			
			response.setArticles(a);
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
	public ArticleResponse getArticle(@PathParam("id") long id) {
		
		ArticleResponse response = new ArticleResponse();
		
		try {
			Article a = articleService.getArticleById(id);
			
			ArticleDTO aDTO = null;
			if (a != null) {
				aDTO = new ArticleDTO(a);
			}
			
			response.setArticle(aDTO);
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
	public ArticleResponse updateArticle(@PathParam("id") long id, Article article) {
		
		ArticleResponse response = new ArticleResponse();
		
		try {
			Article a = articleService.updateArticle(article, id);
			
			ArticleDTO aDTO = null;
			if (a != null) {
				aDTO = new ArticleDTO(a);
			}
			
			response.setArticle(aDTO);
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
	public RestResponse deleteArticle(@PathParam("id") long id) {
		
		RestResponse response = new RestResponse();
		
		try {
			articleService.deleteArticle(id);
			
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