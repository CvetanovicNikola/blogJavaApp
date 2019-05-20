package rs.cubes.blog.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.cubes.blog.domain.Comment;
import rs.cubes.blog.domain.queries.CommentQUeries;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;

public class CommentService {
	
	@PersistenceContext
	EntityManager em;
	 
	public Comment createComment(Comment comment) {
		if(comment.getText().length() > 150) {
			throw new AppException(ErrorMessage.commentTextTooLong);
		}
		em.persist(comment);
		return comment;
	}
	public List<Comment> getAllUserComments(String username){
		List<Comment> comments = CommentQUeries.getAllUserComments(username, em);
		return comments;
	}
	public Comment getComment(long id) {
		Comment c = em.find(Comment.class, id);
		if(c == null) {
			throw new AppException(ErrorMessage.noSuchComment);
		}
		return c;
	}
	public Comment updatecomment(long id, Comment comment) {
		if(comment.getText().length() > 150) {
			throw new AppException(ErrorMessage.commentTextTooLong);
		}
		Comment c = CommentQUeries.findCommnetById(em, id);
		c.setText(comment.getText());
		return c;
	}
	public void deleteComment(long id) {
		Comment c = em.find(Comment.class, id);
		if(c == null) {
			throw new AppException(ErrorMessage.noSuchComment);
		}
		em.remove(c);
	}
	public List<Comment> getAll(String commentParam, boolean likeParam) {
		// TODO Auto-generated method stub
		return null;
	}
}
