package com.me.light.loop.response.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.me.light.loop.RestartLoopException;

public class RestartLoopResponse implements Response {
	private static final Logger logger = LogManager.getLogger(RestartLoopResponse.class);
	
	@Override
	public void doResponse() throws RestartLoopException {
		logger.info("Please enter a positive integer. Restarting.");
     	throw new RestartLoopException();
	}

}
