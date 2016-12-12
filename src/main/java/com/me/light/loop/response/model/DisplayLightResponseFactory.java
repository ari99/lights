package com.me.light.loop.response.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.light.LightEnum;
import com.me.light.loop.response.LightDisplayer;

@Component
public class DisplayLightResponseFactory {
	private final LightDisplayer lightDisplayer;
	
	@Autowired
	public DisplayLightResponseFactory(LightDisplayer lightDisplayer){
		this.lightDisplayer = lightDisplayer;
	}
	
	public DisplayLightResponse getResponse(LightEnum light, int seconds){
		return new DisplayLightResponse(this.lightDisplayer, light, seconds);
	}
}
