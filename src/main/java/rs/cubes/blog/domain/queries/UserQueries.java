package rs.cubes.blog.domain.queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import rs.cubes.blog.domain.User;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;

public class UserQueries {
	//, String username, boolean like
	public static List<User> getAllUsers(EntityManager em){
		
//		if (like == true && username == null) {
//			throw new AppException(ErrorMessage.userDoesntExist);
//		}
		
		String q = "select u from User u";
		
//		if (username != null && like == false) {
//			q += "where u.username like concat('%', :username,'%')";
//					
//		}
		TypedQuery<User>query = em.createQuery(q, User.class);
		
//		if (username != null) {
//			query.setParameter("username", username);
//		}
		return query.getResultList();
	}
	public static User getUserById(EntityManager em, long id) {
		return em.find(User.class, id);
	}
	
	public static User findUserByUsername(EntityManager em, String username) {
		String q = "select u from User u where u.username = :username";
		TypedQuery<User>query = em.createQuery(q, User.class);
		query.setParameter("username", username);
		List<User>l = query.getResultList();
		if(l.isEmpty()) {
			return null;
		}
		return l.get(0);
	}
}
