package rs.cubes.blog.domain.queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import rs.cubes.blog.domain.Article;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;

public class ArticleQueries {//, String title, boolean like
	
	public static List<Article> getAllArticles(EntityManager em){
		
//		if(like == true && title == null) {
//			throw new AppException(ErrorMessage.noSuchArticle);
//		}
//		
		String q = "select a from Article a";
		
//		if(title != null && like ==false) {
//			q += "where a.title like concat('%', :title,'%')";
//		}
		TypedQuery<Article> query = em.createQuery(q, Article.class);
		
//		if(title != null) {
//			query.setParameter("title", title);
//		}
		return query.getResultList();
	}
	public static Article getArticleById(EntityManager em, long id) {
		return em.find(Article.class, id);
	}
	public static Article findArticleByTitle(EntityManager em, String title) {
		String q =  "select a from Article a where a.title = :title";
		TypedQuery<Article>query = em.createQuery(q, Article.class);
		query.setParameter("title", title);
		List<Article>l = query.getResultList();
		if(l.isEmpty()) {
			return null;
		}
		return l.get(0);
	}
}
