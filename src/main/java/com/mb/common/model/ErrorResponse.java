package com.mb.common.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mb.common.exception.ValidationError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Custom http error response model to return custom error code, validation
 * erros and http status.
 * 
 * @author Mindbowser | rohit.kavthekar@mindbowser.com
 *
 */
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorResponse {

	private String message;

	private Integer status;

	private Date timestamp;

	private String detail;

	private List<ValidationError> validationErrors;

}
