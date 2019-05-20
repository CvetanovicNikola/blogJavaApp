package rs.cubes.blog.domain.queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import rs.cubes.blog.domain.Comment;
import rs.cubes.blog.domain.User;

public class CommentQUeries {
	 
	public static List<Comment> getAllComments(EntityManager em){
		
		String q = "select c from Comment c";
		
		TypedQuery<Comment> query = em.createQuery(q, Comment.class);
		List<Comment>l = query.getResultList();
		if(l.isEmpty()) return null;
		return l;
				
	}
	public static Comment findCommnetById(EntityManager em ,long id ) {
		return em.find(Comment.class,id);
	}
	public static List<Comment> getAllUserComments(String username, EntityManager em){
		String q = "select c from Comment c where c.user.username = :username";
		TypedQuery<Comment> query = em.createQuery(q, Comment.class);
		query.setParameter("username", username);
		List<Comment>l = query.getResultList();
		if(l.isEmpty()) {
			return null;
		}
		return l;
				
				
	}

}
