package rs.cubes.blog.rest.response;

import java.util.List;

import rs.cubes.blog.domain.Article;

public class ArticlesResponse extends RestResponse {
	
	private List<Article> articles;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}