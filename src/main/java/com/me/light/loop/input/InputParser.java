package com.me.light.loop.input;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.me.light.loop.RestartLoopException;

@Service
public class InputParser {
	
	// Converts string input to int.
	public int parseInput(String input) throws RestartLoopException{
        if(StringUtils.isNumeric(input)){
        	int seconds = this.parseNumeric(input);
        	return seconds;
        }else{
    	   throw new RestartLoopException();
        }
	}
	
	private int parseNumeric(String input) throws RestartLoopException{
		try {
        	int seconds= Integer.parseInt(input);
        	return seconds;
        } catch (NumberFormatException e) {
        	throw new RestartLoopException();
        }
	}
	
	
	
}
