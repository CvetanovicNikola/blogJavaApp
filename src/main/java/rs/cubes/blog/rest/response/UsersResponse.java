package rs.cubes.blog.rest.response;

import java.util.List;

import rs.cubes.blog.domain.User;

public class UsersResponse extends RestResponse {
	
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}