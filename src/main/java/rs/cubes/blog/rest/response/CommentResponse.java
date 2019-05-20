package rs.cubes.blog.rest.response;

import rs.cubes.blog.domain.Comment;

public class CommentResponse extends RestResponse {
	
	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}