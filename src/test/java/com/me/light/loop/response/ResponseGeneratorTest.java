package com.me.light.loop.response;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.me.light.LightEnum;
import com.me.light.loop.input.InputParser;
import com.me.light.loop.response.LightDisplayer;
import com.me.light.loop.response.ResponseGenerator;
import com.me.light.loop.response.model.DisplayLightResponse;
import com.me.light.loop.response.model.DisplayLightResponseFactory;
import com.me.light.loop.response.model.ExitResponse;
import com.me.light.loop.response.model.Response;
import com.me.light.loop.response.model.RestartLoopResponse;
import com.me.light.loop.utility.TimeService;

public class ResponseGeneratorTest {
	private static ResponseGenerator responseGenerator;
	
	@BeforeClass
	public static void createGenerator(){
		InputParser inputParser = new InputParser();
		TimeService timeService = new TimeService();
		LightDisplayer displayer = new LightDisplayer(timeService);
		DisplayLightResponseFactory factory = new DisplayLightResponseFactory(displayer);
		responseGenerator = new ResponseGenerator(inputParser, factory);
	}
	
	@Test
	public void testExitInput(){
		Response response = responseGenerator.getResponse(LightEnum.GREEN, "exit");
		assertTrue(response instanceof ExitResponse);
	}
	
	@Test
	public void testAlphabeticalInput(){
		Response response = responseGenerator.getResponse(LightEnum.GREEN, "aaaa");
		assertTrue(response instanceof RestartLoopResponse);
	}
	
	@Test
	public void testEmptyInput(){
		Response response = responseGenerator.getResponse(LightEnum.GREEN, "");
		assertTrue(response instanceof RestartLoopResponse);
	}
	
	@Test
	public void testNegativeInput(){
		Response response = responseGenerator.getResponse(LightEnum.GREEN, "-5");
		assertTrue(response instanceof RestartLoopResponse);
	}
	
	//max int value 2,147,483,647
	@Test
	public void testLongInput(){
		Response response = responseGenerator.getResponse(LightEnum.GREEN, "3000000000");
		assertTrue(response instanceof RestartLoopResponse);
	}
	
	@Test
	public void testGoodInput(){
		Response response = responseGenerator.getResponse(LightEnum.GREEN, "123");
		assertTrue(response instanceof DisplayLightResponse);
	}
	
}
