package rs.cubes.blog.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import rs.cubes.blog.domain.Article;


public class ArticleDTO {
	
	private long id;
	
	private String title;
	
	private String content;
	
	private LocalDateTime created;
	
	private int ratingCounter;
	
	private Set<String> keywords;
	
	private double averageCounter;
	
	private UserDTO user;
	
	private Set<TagDTO> tags;
	
	public ArticleDTO() {}
	
	public ArticleDTO(Article article) {
		this.id = article.getId();
		this.title = article.getTitle();
		this.content = article.getContent();
		this.created = article.getCreated();
		this.ratingCounter = article.getRatingCounter();
		this.keywords = article.getKeywords();
		this.averageCounter = article.getAverageCounter();
		
		this.user = new UserDTO(article.getUser());
		
//		this.tags = new HashSet<>();
//		for(Tag t : article.getTags()) {
//			this.tags.add(new TagDTO());
//		}
		
	}
	
	public ArticleDTO(Article article, boolean includeTags) {
		this.id = article.getId();
		this.title = article.getTitle();
		this.content = article.getContent();
		this.created = article.getCreated();
		this.ratingCounter = article.getRatingCounter();
		this.keywords = article.getKeywords();
		this.averageCounter = article.getAverageCounter();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public int getRatingCounter() {
		return ratingCounter;
	}

	public void setRatingCounter(int ratingCounter) {
		this.ratingCounter = ratingCounter;
	}
	
	public Set<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}
	
	public double getAverageCounter() {
		return averageCounter;
	}

	public void setAverageCounter(double averageCounter) {
		this.averageCounter = averageCounter;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Set<TagDTO> getTags() {
		return tags;
	}

	public void setTags(Set<TagDTO> tags) {
		this.tags = tags;
	}
	
	

}
