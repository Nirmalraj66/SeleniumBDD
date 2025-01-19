package utils;

import java.util.Properties;
import java.io.*;
public class ConfigReader {
	
	Properties prop;
	
	public String getConfigValue(String configName) 
	{
		String congfigValue = null;
		try {
		String configFilePath = "F:/eclipse-workspace/SeleniumBDD/src/main/resources/config.properties";
		File configFile = new File(configFilePath);
		FileInputStream fis = new FileInputStream(configFile);
		prop = new Properties();
		prop.load(fis);
		congfigValue = prop.getProperty(configName);
		System.out.println(congfigValue);
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return congfigValue;
	}
	

}
