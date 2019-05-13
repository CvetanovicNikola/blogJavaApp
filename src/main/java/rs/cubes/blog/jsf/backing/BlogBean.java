package rs.cubes.blog.jsf.backing;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rs.cubes.blog.domain.User;
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
	
	
	public void createUser(String username, String password, String email, String name, String surname, String nickname) {
		User u = new User();
		u.setUsername(username); 
		u.setPassword(password);
		u.setEmail(email);
		u.setName(nickname);
		u.setSurname(surname);
		u.setNickname(nickname);
		userService.createUser(u);
		
	}
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	

}
