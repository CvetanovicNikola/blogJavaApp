package rs.cubes.blog.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.cubes.blog.domain.Article;
import rs.cubes.blog.domain.User;
import rs.cubes.blog.domain.queries.ArticleQueries;
import rs.cubes.blog.domain.queries.UserQueries;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;

@Stateless
public class ArticleService {
	
	@PersistenceContext
	EntityManager em;
	
	public Article createArticle(Article article, User user) {
		if(article.getTitle().length() > 50) {
			throw new AppException(ErrorMessage.articleTitleTooLong);
		}
		Article a = ArticleQueries.findArticleByTitle(em, article.getTitle());
		
		if (a != null) {
			throw new AppException(ErrorMessage.articleAlreadyExists);
		}
		User u = UserQueries.getUserById(em, user.getId());
		article.setUser(u);
		em.persist(article);
		return article;
	}
	//String title, boolean like
	public List<Article> getAllArticles(){//, title, like
		List<Article>articles = ArticleQueries.getAllArticles(em);
		return articles;
	}
	
	public Article getArticleById(long id) {
		Article a = ArticleQueries.getArticleById(em, id);
		if (a == null) {
			throw new AppException(ErrorMessage.noSuchArticle);
		}
		return a;
	}
	
	public Article updateArticle(Article article, long id){
		if(article.getTitle().length() > 50) {
			throw new AppException(ErrorMessage.articleTitleTooLong);
		}
		Article a = ArticleQueries.getArticleById(em, id);
		
		if (a == null) {
			//return createArticle(article, article.getUser());
		}
		Article a1 = ArticleQueries.findArticleByTitle(em, article.getTitle());
		
		if(!(a.getId() == a1.getId())) {
			throw new AppException(ErrorMessage.articleAlreadyExists);
		}
		a.setTitle(article.getTitle());
		return a;
	}
	
	public void deleteArticle(long id) {
		Article a = ArticleQueries.getArticleById(em, id);
		if(a == null) {
			throw new AppException(ErrorMessage.noSuchArticle);
		}
		em.remove(a);
	}
}
