package rs.cubes.blog.rest.response;

import java.util.List;

import rs.cubes.blog.domain.Comment;

public class CommentsResponse extends RestResponse {
	
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}