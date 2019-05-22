package rs.cubes.blog.service.errors;

public class ErrorMessage {
	
	private int code;
	private String message;
	
	
	 
	public ErrorMessage(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) { 
		this.message = message;
	}
	
	public static final ErrorMessage ok = new ErrorMessage(0, "Operation sucessful!");
	public static final ErrorMessage dBError = new ErrorMessage(100, "Data base error!");
	
	public static final ErrorMessage usernameTooLong = new ErrorMessage(200, "User name is too long, max 20 characters!");
	public static final ErrorMessage usernameExists = new ErrorMessage(201, "That user name already exists, choose another one.");
	public static final ErrorMessage noSuchUser = new ErrorMessage(202, "User with that id doesn't exist.");
	public static final ErrorMessage userSurnameTooLong = new ErrorMessage(203, "Last name is too long, max 50 chars");
	public static final ErrorMessage nameTooLong = new ErrorMessage(204, "Users name is too long, max 30 chars");
	public static final ErrorMessage passwordTooShort = new ErrorMessage(205, "Password is too short, min 8 chars.");
	public static final ErrorMessage nicknameTooLong = new ErrorMessage(206, "Nickname is too long, max 20 chars");
	
	
	public static final ErrorMessage noSuchArticle = new ErrorMessage(300, "There are no articles with that title.");
	public static final ErrorMessage articleTitleTooLong = new ErrorMessage(301, "The article title is too long, max number of characters is 50!");
	public static final ErrorMessage articleAlreadyExists = new ErrorMessage(302, "An article with that title already exists!");
	
	public static final ErrorMessage commentTextTooLong = new ErrorMessage(400, "Text of the comment is too long, max 150 chars.");
	public static final ErrorMessage noSuchComment = new ErrorMessage(402, "Such comment doesn't exist");
	
	public static final ErrorMessage userDoesntExist = new ErrorMessage(500, "That user doesn't exist!");
	
	public static final ErrorMessage invalidRating = new ErrorMessage(600, "Rating must be between 0 and 5!");
	
	public static final ErrorMessage noSuchRating = new ErrorMessage(700, "No such rating!");
	
	public static final ErrorMessage tagTooLong = new ErrorMessage(800, "Tag is too long, max 20 characters!");
	
	public static final ErrorMessage noSuchTag = new ErrorMessage(900, "There are no such tags.");
	public static final ErrorMessage tagAlreadyExists = new ErrorMessage(901, "That tag already exists.");
}
 