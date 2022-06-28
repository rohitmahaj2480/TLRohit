package org.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public String getPropertyValue(String key,String propertyFilePath)  {
		try {
			FileInputStream fis =new FileInputStream(propertyFilePath);
			Properties prop =new Properties();
			prop.load(fis);

			return prop.getProperty(key);

		}catch(IOException e) {
			return null; 
		}
	}
}