package userservice.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleGlobal {

	@ExceptionHandler(NoUserFound.class)
	public String HandleBasicError(NoUserFound ex) {
		return ex.getLocalizedMessage();
	}
}
