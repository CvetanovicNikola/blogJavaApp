package rs.cubes.blog.jsf.backing;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import rs.cubes.blog.domain.User;
import rs.cubes.blog.service.UserService;
import rs.cubes.blog.service.errors.AppException;
import rs.cubes.blog.service.errors.ErrorMessage;


@Named("user")
@javax.enterprise.context.SessionScoped

public class UserBean implements Serializable{
	
	
	
	
	
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
	
	
	private String userId;
	private User user ;
	private String message;
	
	private String usernameLogin;
	private String passwordLogin;
	
	private User loggedUser;
	
	public String userLogin() {
		try {
			User u = userService.getUserByUsername(usernameLogin);
			if (u.getPassword().equals(passwordLogin)) {
				message = "You have logged in.";
				loggedUser = u;
				//System.out.println(loggedUser.getName());
				return "index.xhtml?faces-redirect=true";
			}
			else {
				message = "Invalid password";
				return "loginFailed?faces-redirect=true";
			}
			
		}
		catch (AppException e){
			message = e.getError().getMessage();
			//System.out.println(message);
			return "loginFailed?faces-redirect=true";
		}
		
	}
	

	public User getLoggedUser() {
		return loggedUser;
	}


	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}


	public String getUsernameLogin() {
		return usernameLogin;
	}



	public void setUsernameLogin(String usernameLogin) {
		this.usernameLogin = usernameLogin;
	}



	public String getPasswordLogin() {
		return passwordLogin;
	}



	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}



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
//	public UIData getDataTable() {
//		return dataTable;
//	}
//
//	public void setDataTable(UIData dataTable) {
//		this.dataTable = dataTable;
//	}

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
			message = e.getError().getMessage();
			System.out.println(message);
			return "userNotCreated?faces-redirect=true";
		}
			
	}
	
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNiceDate() {
		return niceDate;
		}
	

	
	public String deleteUser(String id) {
		long userId = Long.valueOf(id);
		userService.deleteUser(userId);
		return "allUsers?faces-redirect=true";
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
