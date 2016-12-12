package com.me.light.loop.response.model;

import com.me.light.LightEnum;
import com.me.light.loop.RestartLoopException;
import com.me.light.loop.response.LightDisplayer;

public class DisplayLightResponse implements Response {
	final private LightDisplayer lightDisplayer;
	private int seconds;
	private LightEnum light;
	
	public DisplayLightResponse(LightDisplayer lightDisplayer, 
			LightEnum light, int seconds){
		this.lightDisplayer = lightDisplayer;
		this.light = light;
		this.seconds = seconds;
		
	}
	
	@Override
	public void doResponse() throws RestartLoopException {
		this.lightDisplayer.displayLight(light, seconds);
	}

}
