package com.me.light.loop.response.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExitResponse implements Response {
	private static final Logger logger = LogManager.getLogger(ExitResponse.class);
	@Override
	public void doResponse() {
		logger.info("Exiting Traffic Light Simulator");
    	System.exit(0);
	}

}
