package rs.cubes.blog.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.cubes.blog.domain.Article;
import rs.cubes.blog.domain.queries.ArticleQueries;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;

@Stateless
public class ArticleService {
	
	@PersistenceContext
	EntityManager em;
	
	public Article createArticle(Article article) {
		if(article.getTitle().length() > 50) {
			throw new AppException(ErrorMessage.articleTitleTooLong);
		}
		Article a = ArticleQueries.findArticleByTitle(em, article.getTitle());
		
		if (a != null) {
			throw new AppException(ErrorMessage.articleAlreadyExists);
		}
		em.persist(article);
		return article;
	}
	public List<Article> getAllArticles(String title, boolean like){
		List<Article>articles = ArticleQueries.getAllArticles(em, title, like);
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
			return createArticle(article);
		}
		Article a1 = ArticleQueries.findArticleByTitle(em, article.getTitle());
		
		if(!(a.getId() == a1.getId())) {
			throw new AppException(ErrorMessage.articleAlreadyExists);
		}
		a.setTitle(article.getTitle());
		return a;
	}
	
	public void deleteCategory(long id) {
		Article a = ArticleQueries.getArticleById(em, id);
		if(a == null) {
			throw new AppException(ErrorMessage.noSuchArticle);
		}
		em.remove(a);
	}
}
