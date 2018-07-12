/**
 * 
 */
package ir.kuroshfarsimadan.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author User
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {

	public PersonNotFoundException(Exception cause) {
		super(cause);
	}

}