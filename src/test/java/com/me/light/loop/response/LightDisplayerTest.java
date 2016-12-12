package com.me.light.loop.response;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;

import com.me.light.LightEnum;
import com.me.light.loop.RestartLoopException;
import com.me.light.loop.response.LightDisplayer;
import com.me.light.loop.utility.TimeService;

public class LightDisplayerTest {
	 @Rule
     public Stopwatch stopwatch = new Stopwatch(){};
     
     @Test
     public void testDisplayerTime() throws RestartLoopException{
    	 TimeService timeService = new TimeService();
    	 LightDisplayer displayer = new LightDisplayer(timeService);
    	 int seconds = 3;
    	 displayer.displayLight(LightEnum.YELLOW, seconds);
    	 //Assert this method ran for 3 seconds with a 700 millisecond delta range of acceptance.
         assertEquals(3000, stopwatch.runtime(TimeUnit.MILLISECONDS), 700);
     }
     
}
