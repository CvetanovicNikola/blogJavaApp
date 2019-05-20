package rs.cubes.blog.dto;

import java.util.HashSet;
import java.util.Set;

import rs.cubes.blog.domain.User;



public class UserDTO {
	
	private long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String name;
	
	private String surname;
	
	private String nickname;

	private Set<ArticleDTO> articles;
	
	public UserDTO() {}

	public UserDTO(long id, String username, String password, String email, String name, String surname,
			String nickname, Set<ArticleDTO> articles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.nickname = nickname;
		this.articles = articles;
	}
	
	public UserDTO(User u ) {
		this.id = u.getId();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.email = u.getEmail();
		this.name = u.getName();
		this.surname = u.getSurname();
		this.nickname = u.getNickname();
		
//		this.articles = new HashSet<>();
//		for(Article a : u.getArticles()) {
//			this.articles.add(new ArticleDTO());
//		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<ArticleDTO> getArticles() {
		return articles;
	}

	public void setArticles(Set<ArticleDTO> articles) {
		this.articles = articles;
	}
	
	

}
