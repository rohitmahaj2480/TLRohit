package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configwithconstr {
	String file;
	public Configwithconstr(String filepath) {
		file=filepath;
	}
	public Properties returnProp()  {
		try {
			FileInputStream fis =new FileInputStream(file);
			Properties prop =new Properties();
			prop.load(fis);

			return prop;

		}catch(IOException e) {
			return null;
		}	
	}
	public String getPropertyValue(String key)  {
		try {
			FileInputStream fis =new FileInputStream(file);
			Properties prop =new Properties();
			prop.load(fis);

			return prop.getProperty(key);

		}catch(IOException e) {
			//return null;

		}
		return null;
	}

}


