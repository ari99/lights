package com.me.light.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.light.LightEnum;
import com.me.light.loop.input.InputQueryer;
import com.me.light.loop.response.ResponseGenerator;
import com.me.light.loop.response.model.Response;


@Component
public class LightLooper {

	private final ResponseGenerator responseGenerator;
	private final InputQueryer inputQueryer;
	
	@Autowired
	public LightLooper(ResponseGenerator responseGenerator, InputQueryer inputQueryer){
		this.responseGenerator = responseGenerator;
		this.inputQueryer = inputQueryer;
	}
	
	public void start(){
		// Continuously ask the user for how long to display light colors.
		while(true){
			for(LightEnum light : LightEnum.values()){
				try {
					// Get number of seconds to display color.
					String inputLine = this.inputQueryer.getInputLine(light);
					
					// Generate a response based on the input.
					Response inputResponse = this.responseGenerator.getResponse(light, inputLine);
					inputResponse.doResponse();
					
				} catch (RestartLoopException e) {
					//Restart loop if we get a RestartLoopException.
					break;
				}
			}
		}

	}




}
