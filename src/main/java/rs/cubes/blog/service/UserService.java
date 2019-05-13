package rs.cubes.blog.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.cubes.blog.domain.User;
import rs.cubes.blog.domain.queries.UserQueries;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;

@Stateless
public class UserService {

	@PersistenceContext
	EntityManager em;
	
	public User createUser(User user) {
		if (user.getUsername().length() > 20) {
			throw new AppException(ErrorMessage.usernameTooLong);
		}
		User u = UserQueries.findUserByUsername(em, user.getUsername());
	
		if(u != null) {
			throw new AppException(ErrorMessage.usernameExists);
		}
	em.persist(user);
	return u;
	}
	public List<User> getAllUsers(String username, boolean like){
		List<User>users = UserQueries.getAllUsers(em, username, like);
		return users;
	}
	public User getUser(long id) {
		User u = em.find(User.class, id);
		
		if(u == null) {
			throw new AppException(ErrorMessage.noSuchUser);
		}
		
		return u;
	}
	public User updateUser(long id, User user) {
		if(user.getUsername().length() > 20) {
			throw new AppException(ErrorMessage.usernameTooLong);
		}
		User u1 = UserQueries.getUserById(em, id);
		
		if (u1 == null) {
			return createUser(user);
		}
		User u2 = UserQueries.findUserByUsername(em, user.getUsername());
		
		if(!(u1.getId() == u2.getId())) {
			throw new AppException(ErrorMessage.usernameExists);
		}
		u1.setUsername(user.getUsername());
		return u1;
	}
	public void deleteUser(long id) {
		User u = UserQueries.getUserById(em, id);
			if (u == null) {
				throw new AppException(ErrorMessage.noSuchUser);
			}
			em.remove(u);
		}
	}

