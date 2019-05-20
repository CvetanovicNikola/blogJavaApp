package rs.cubes.blog.dto;

import java.util.HashSet;
import java.util.Set;

import rs.cubes.blog.domain.Article;
import rs.cubes.blog.domain.Tag;



public class TagDTO {
	
	private long id;
	
	private String value;
	
	private Set<ArticleDTO> articles;
	
	public TagDTO() {}

	public TagDTO(long id, String value, Set<ArticleDTO> articles) {
		this.id = id;
		this.value = value;
		this.articles = articles;
	}
	
	public TagDTO(Tag t) {
		this.id = t.getId();
		this.value = t.getValue();
//		this.articles = new HashSet<>();
//		
//		for(Article a: t.getArticles()) {
//			this.articles.add(new ArticleDTO());
//		}
	}
	
	public TagDTO(Tag t, boolean includeArticles) {
		this.id = t.getId();
		this.value = t.getValue();
		
		this.articles = new HashSet<>();
		
		if(includeArticles) {
			for(Article a : t.getArticles()) {
				this.articles.add(new ArticleDTO());
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set<ArticleDTO> getArticles() {
		return articles;
	}

	public void setArticles(Set<ArticleDTO> articles) {
		this.articles = articles;
	}
	
	

}
