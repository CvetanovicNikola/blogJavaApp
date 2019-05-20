package rs.cubes.blog.rest.response;

import rs.cubes.blog.dto.UserDTO;

public class UserResponse extends RestResponse {
	
	private UserDTO user;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	
}