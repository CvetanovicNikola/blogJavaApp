package rs.cubes.blog.jsf.backing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.ws.rs.ServiceUnavailableException;

import rs.cubes.blog.domain.User;
import rs.cubes.blog.service.UserService;
import rs.cubes.blog.service.errors.AppException;


@javax.faces.bean.ManagedBean(name="user")

public class UserBean {
	
	
	
	
	
	@EJB
	private UserService userService;
	
	private String niceDate;
	@NotNull(message = "This field is mandatory!")
	private String username;
	@NotNull(message = "This field is mandatory!")
	private String password;
	@NotNull(message = "This field is mandatory!")
	private String email;
	@NotNull(message = "This field is mandatory!")
	private String name;
	@NotNull(message = "This field is mandatory!")
	private String surname;
	@NotNull(message = "This field is mandatory!")
	private String nickname;
	
	private UIData dataTable;
	//private User selectedUser;
	private String userId;
	private User user ;
	
	


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserById() {
		long id = Long.valueOf(userId);
		return userService.getUser(id);
	}
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setNiceDate(String niceDate) {
		this.niceDate = niceDate;
	}

	public String createUser() {
		User u = new User();
		
		u.setUsername(username); 
		u.setPassword(password);
		u.setEmail(email);
		u.setName(name);
		u.setSurname(surname);
		u.setNickname(nickname);
		
		
		try {
			userService.createUser(u);
			return "userDetail.jsf?userId=" + u.getId() + "&faces-redirect=true";
			}
		catch (AppException e){
			return "userNotCreated?faces-redirect=true";
		}
			
	}
	
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	

	public String getNiceDate() {
		return niceDate;
		}
	

	
	public String greetUser() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		niceDate = sdf.format(new Date());
		return "welcome";
	}

	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
