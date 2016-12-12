package com.me.light.loop.input;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.light.LightEnum;
import com.me.light.loop.utility.TimeService;

/**
 * Asks the user how to long to show a light.
 */
@Service
public class InputQueryer {
    private static final Logger logger = LogManager.getLogger(InputQueryer.class);

	private final TimeService timeService;
	private final Scanner scanner;

	@Autowired
	public InputQueryer(TimeService timeService, Scanner scanner) {
		this.scanner = scanner;
		this.timeService = timeService;
	}

	public String getInputLine(LightEnum light) {
		logger.info(this.timeService.getTime() + " --- Enter seconds to show " + light.getLightName());
		
		String input = this.scanner.nextLine();
		return input;
	}

}
