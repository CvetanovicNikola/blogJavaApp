package rs.cubes.blog.jsf.backing;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import rs.cubes.blog.domain.Article;
import rs.cubes.blog.domain.User;
import rs.cubes.blog.service.ArticleService;
import rs.cubes.blog.service.errors.AppException;

@SessionScoped
@ManagedBean(name="article")
public class ArticleBean implements Serializable{

	@EJB
	ArticleService articleService;
	
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	public UserBean getUserBean() {
		return userBean;
	}
	private String title;
	private String content;
	private LocalDateTime created;
	private String message;
	private Article article;
	private String articleId;
	
	
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public Article getArticleById() {
		long id = Long.valueOf(articleId);
		return articleService.getArticleById(id);
	}
	public String createArticle() {
		Article a = new Article();
		a.setUser(userBean.getUser());
		//System.out.println(userBean.getLoggedUser().getName());
		a.setTitle(title);
		a.setContent(content);
		a.setCreated(created);
		
		try {
			articleService.createArticle(a, userBean.getLoggedUser());
			return "articleDetail.jsf?articleId=" + a.getId() + "&faces-redirect=true";
		}
		catch(AppException e){
			message = e.getError().getMessage();
			System.out.println(message);
			return "articleNotCreated?faces-redirect=true";
		}
	}
	public String deleteArticle(String id) {
		long artId = Long.valueOf(id);
		articleService.deleteArticle(artId);
		return "allArticles?faces-redirect=true";
	}
	public List<Article> getAllArticles(){
		return articleService.getAllArticles();
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
	public LocalDateTime getDateTime() {
		return created;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.created = created;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	
}
