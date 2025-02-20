package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
	
	public static Properties readData(String fileName) {
		Properties prop = new Properties();		
			
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Config\\"+fileName);
				prop.load(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
		return prop;
	}

}
