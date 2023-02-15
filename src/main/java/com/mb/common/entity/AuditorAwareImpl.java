package com.mb.common.entity;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	/**
	 * custom implementation of auditing
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @return {@link Optional}
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.empty();
	}

}
