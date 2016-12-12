package com.me.light;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public enum LightEnum {
	GREEN("green", "greenLight.txt"),
	YELLOW("yellow", "yellowLight.txt"),
	RED("red", "redLight.txt");
	
	private static final Logger logger = LogManager.getLogger(LightEnum.class);
	private String lightName;
	private String art;
	
	/**
	 * Enum to hold information about the light colors.
	 * @param lightName Color of the light.
	 * @param artFile File in classpath holding ascii art for the light.
	 */
	LightEnum(String lightName, String artFile){
		this.lightName = lightName;
		this.art = this.makeArt(artFile);
	}
	
	public String getLightName(){
		return this.lightName;
	}
	
	public String getArt(){
		return this.art;
	}
	
	// Loads ascii art file and converts it to a String.
	private String makeArt(String artFile){
		try {
			return Resources.toString(Resources.getResource(artFile), Charsets.UTF_8);
		} catch (IOException e) {
			logger.error("Error getting art resources",e);
			System.exit(1);
			return "";
		}
	}
}
