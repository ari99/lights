package com.me.light.loop.response;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.light.LightEnum;
import com.me.light.loop.RestartLoopException;
import com.me.light.loop.utility.TimeService;

@Service
public class LightDisplayer {
    private static final Logger logger = LogManager.getLogger(LightDisplayer.class);

	private TimeService timeService;
	
	@Autowired
	public LightDisplayer(TimeService timeService){
		this.timeService = timeService;
	}
	
	// Display a light for inputed seconds.
	public void displayLight(LightEnum light, int seconds) throws RestartLoopException{
		logger.info(light.getArt());
		logger.info(this.timeService.getTime());
		this.wait(seconds);
	}
	
	private void wait(int seconds) throws RestartLoopException{
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			logger.info("Light interrupted.");
    	    throw new RestartLoopException();
		}
	}
	
	
}
