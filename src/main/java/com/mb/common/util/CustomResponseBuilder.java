package com.mb.common.util;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mb.common.exception.ValidationError;
import com.mb.common.model.ErrorResponse;
import com.mb.common.model.SuccessResponse;

/**
 * Component class used to build response entity for returning success, error
 * and validation responses
 * 
 * @author Mindbowser | rohit.kavthekar@mindbowser.com
 *
 */
@Component
public class CustomResponseBuilder {

	/**
	 * Build http succcess response entity
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param <T>
	 * @param message
	 * @param data
	 * @param httpStatus
	 * @return {@link ResponseEntity}
	 */
	public <T> ResponseEntity<SuccessResponse<T>> buildSuccessResponse(String message, T data, HttpStatus httpStatus) {

		SuccessResponse<T> response = new SuccessResponse<>();
		response.setStatus(httpStatus.value());
		response.setData(data);
		response.setMessage(message);
		response.setTimestamp(new Date());

		return new ResponseEntity<>(response, httpStatus);
	}

	/**
	 * Build error response with http status
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param message
	 * @param detail
	 * @param httpStatus
	 * @return {@link ResponseEntity}
	 */
	public ResponseEntity<ErrorResponse> buildErrorResponse(String message,String detail, HttpStatus httpStatus) {

		ErrorResponse errorResponse = ErrorResponse.builder()
				.status(httpStatus.value())
				.message(message)
				.timestamp(new Date())
				.detail(detail)
				.build();

		return new ResponseEntity<>(errorResponse, httpStatus);
	}

	/**
	 * Build http validation error response entity
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param message
	 * @param detail
	 * @param fieldErrors
	 * @return {@link ResponseEntity}
	 */
	public ResponseEntity<Object> buildValidationErrorResponse(String message, String detail, List<ValidationError> fieldErrors) {

		ErrorResponse errorResponse = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST.value())
				.message(message)
				.timestamp(new Date())
				.validationErrors(fieldErrors)
				.detail(detail)
				.build();

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
