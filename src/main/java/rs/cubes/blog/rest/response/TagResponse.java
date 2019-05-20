package rs.cubes.blog.rest.response;

import rs.cubes.blog.dto.TagDTO;

public class TagResponse extends RestResponse {
	
	private TagDTO tag;

	public TagDTO getTag() {
		return tag;
	}

	public void setTag(TagDTO tag) {
		this.tag = tag;
	}

	

}