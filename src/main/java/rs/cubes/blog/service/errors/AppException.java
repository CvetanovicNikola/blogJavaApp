package rs.cubes.blog.service.errors;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class AppException extends RuntimeException {
	
	private ErrorMessage error;

	public ErrorMessage getError() {
		return error;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}

	public AppException(ErrorMessage error) {
		super();
		this.error = error;
	}
	
	 

}
