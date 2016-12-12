package com.me.light.loop.response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.light.LightEnum;
import com.me.light.loop.RestartLoopException;
import com.me.light.loop.input.InputParser;
import com.me.light.loop.response.model.DisplayLightResponseFactory;
import com.me.light.loop.response.model.ExitResponse;
import com.me.light.loop.response.model.Response;
import com.me.light.loop.response.model.RestartLoopResponse;

/**
 * Generates a Response object from input.
 */
@Service
public class ResponseGenerator {

	private final InputParser inputParser;
	private static final String EXIT_COMMAND = "exit";
	private final DisplayLightResponseFactory displayLightResponseFactory;
	
	@Autowired
	public ResponseGenerator(InputParser inputParser,
			DisplayLightResponseFactory displayLightResponseFactory){
		
		this.inputParser = inputParser;
		this.displayLightResponseFactory =  displayLightResponseFactory;
	}
	
	public Response getResponse(LightEnum light, String inputLine){
		try {
			
			if(this.isExitCommand(inputLine)){
				return new ExitResponse();
			}
			
			int seconds = this.inputParser.parseInput(inputLine);
			
			return  displayLightResponseFactory.getResponse(light, seconds);
			
		} catch (RestartLoopException e) {
			return new RestartLoopResponse();
		}
	}
	
	private boolean isExitCommand(String input){
		 if(input.equals(EXIT_COMMAND)){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	
	
	
}
