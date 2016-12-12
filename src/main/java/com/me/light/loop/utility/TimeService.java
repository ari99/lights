package com.me.light.loop.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TimeService {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public String getTime(){
		Date date = new Date();
		return DATE_FORMAT.format(date);
	}
}
