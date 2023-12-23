package com.mb.common.exception;

import lombok.Builder;
import lombok.Data;

/**
 * Response model class used to return validation field error messages and
 * value.
 * 
 * @author Mindbowser | rohit.kavthekar@mindbowser.com
 */
@Data
@Builder
public class ValidationError {

	private String property;

	private String message;

	private Object rejectedValue;

}
