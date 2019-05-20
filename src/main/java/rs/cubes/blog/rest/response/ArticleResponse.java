package rs.cubes.blog.rest.response;

import rs.cubes.blog.dto.ArticleDTO;

public class ArticleResponse extends RestResponse {
	
	private ArticleDTO article;

	public ArticleDTO getArticle() {
		return article;
	}

	public void setArticle(ArticleDTO article) {
		this.article = article;
	}

	

}
