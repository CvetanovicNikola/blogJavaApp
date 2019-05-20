package rs.cubes.blog.rest.response;

import java.util.List;

import rs.cubes.blog.domain.Tag;

public class TagsResponse extends RestResponse {
	
	private List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}