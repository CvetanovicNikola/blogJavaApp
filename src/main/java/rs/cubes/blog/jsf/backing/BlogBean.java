package rs.cubes.blog.jsf.backing;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rs.cubes.blog.service.UserService;

@Named
@SessionScoped
public class BlogBean implements Serializable{
	
	@EJB
	UserService userService;
	
	private String username;
	private String password;
	private String email;
	private String name;
	private String surname;
	private String nickname;

}
