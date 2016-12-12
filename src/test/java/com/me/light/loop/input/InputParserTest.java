package com.me.light.loop.input;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.me.light.loop.RestartLoopException;
import com.me.light.loop.input.InputParser;

public class InputParserTest {
	@Rule
	 public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testAlphabeticalInput() throws RestartLoopException{
		exception.expect(RestartLoopException.class);
		InputParser parser = new InputParser();
		parser.parseInput("aaa");
	}
	
	@Test
	public void testEmptyInput() throws RestartLoopException{
		exception.expect(RestartLoopException.class);
		InputParser parser = new InputParser();
		parser.parseInput("");
	}
	
	@Test
	public void testNegativeInput() throws RestartLoopException{
		exception.expect(RestartLoopException.class);
		InputParser parser = new InputParser();
		parser.parseInput("-5");
	}
	
	@Test
	public void testLongInput() throws RestartLoopException{
		exception.expect(RestartLoopException.class);
		InputParser parser = new InputParser();
		// Max int value in Java is 2,147,483,647.
		parser.parseInput("3000000000");
	}
	
	@Test
	public void testIntInput() throws RestartLoopException{
		InputParser parser = new InputParser();
		int i = parser.parseInput("300");
		assertEquals(300, i);
	}
	
	
	
	
}
