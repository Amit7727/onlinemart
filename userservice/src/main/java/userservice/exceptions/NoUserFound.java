package userservice.exceptions;

public class NoUserFound extends RuntimeException{

	public NoUserFound(String msg) {
		super(msg);
	}
}
