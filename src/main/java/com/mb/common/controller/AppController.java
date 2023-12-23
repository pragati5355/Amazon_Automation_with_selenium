package com.mb.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.common.constant.ApiPath;
import com.mb.common.constant.AppConstant;
import com.mb.common.constant.ResponseMessage;
import com.mb.common.model.HealthCheck;
import com.mb.common.model.SuccessResponse;
import com.mb.common.util.CustomResponseBuilder;

/**
 * @author Mindbowser | rohit.kavthekar@mindbowser.com
 */
@RestController
@RequestMapping(ApiPath.V1_BASE_URL)
public class AppController {

	@Autowired
	private Environment environment;

	@Autowired
	private CustomResponseBuilder responseBuilder;

	/**
	 * Health check api to return application and it's versions details.
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(ApiPath.HEALTH)
	public ResponseEntity<SuccessResponse<HealthCheck>> healthCheck() {

		HealthCheck healthCheck = HealthCheck.builder()
				.appName(environment.getProperty(AppConstant.APP_NAME))
				.appVersion(environment.getProperty(AppConstant.APP_VERSION))
				.artifactId(environment.getProperty(AppConstant.APP_ARTIFACT_ID))
				.groupId(environment.getProperty(AppConstant.APP_GROUP_ID))
				.build();

		return responseBuilder.buildSuccessResponse(environment.getProperty(ResponseMessage.SUCCESS), healthCheck,
				HttpStatus.OK);
	}

}