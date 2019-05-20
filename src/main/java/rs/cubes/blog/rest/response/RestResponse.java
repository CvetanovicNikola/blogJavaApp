package rs.cubes.blog.rest.response;

import javax.xml.bind.annotation.XmlRootElement;

import rs.cubes.blog.service.errors.ErrorMessage;

@XmlRootElement
public class RestResponse {
	 
	private int code;
	
	private String errorMessage;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void setErrorCode(ErrorMessage em) {
		this.setCode(em.getCode());
		this.setErrorMessage(em.getMessage());
	}

}