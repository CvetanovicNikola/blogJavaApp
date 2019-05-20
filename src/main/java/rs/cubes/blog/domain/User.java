package rs.cubes.blog.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import rs.cubes.blog.dto.UserDTO;

@Entity 
public class User { 
 
		@Id
		@GeneratedValue
		private long id;
		private String username;
		private String password;
		private String email;
		private String name;
		private String surname;
		private String nickname;
		
		@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
		private Set<Article>articles;
		@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
		private Set<Comment>comments;
		@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
		private Set<Rating>ratings;
		
		public User() {}
		
		public User(UserDTO user) {
			this.username = user.getUsername();
			this.password = user.getPassword();
			this.email = user.getEmail();
			this.name = user.getName();
			this.surname = user.getSurname();
			this.nickname = user.getNickname();
			
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
		public Set<Article> getArticles() {
			return articles;
		}
		public void setArticles(Set<Article> articles) {
			this.articles = articles;
		}
		public Set<Comment> getComments() {
			return comments;
		}
		public void setComments(Set<Comment> comments) {
			this.comments = comments;
		}
		public Set<Rating> getRatings() {
			return ratings;
		}
		public void setRatings(Set<Rating> ratings) {
			this.ratings = ratings;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
					+ ", name=" + name + ", surname=" + surname + ", nickname=" + nickname + ", articles=" + articles
					+ ", comments=" + comments + ", ratings=" + ratings + "]";
		}
		
		
}
