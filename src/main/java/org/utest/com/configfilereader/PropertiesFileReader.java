package org.utest.com.configfilereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.utest.com.base.Base;

/**
 * Bahubali P R
 */
public class PropertiesFileReader {

	/*
	 * Creating a reference for Properties class.
	 */
	private Properties properties = null;
	private Base base = new Base();

	/*
	 * Assigning config.propertis file path the variable propertyFilePath.
	 */
	private final String propertyFilePath = base.userdir + "/Configurations/config.properties";

	/*
	 * creating a constructor and reading property file from the configurations
	 * folder.
	 */
	public PropertiesFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	/*
	 * This block of code will be helpful to get driver path from the properties
	 * file.
	 */
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	/*
	 * This block of code will be helpful to get implicit wait value(in Seconds)
	 * from the properties file.
	 */
	public long getImplicitlyWait() {
		String implicitWait = properties.getProperty("implicitWait");
		if (implicitWait != null)
			return Long.parseLong(implicitWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	/*
	 * This block of code will be helpful to get explicit wait value(in Seconds)
	 * from the properties file.
	 */
	public long getExplicitWait() {
		String explicitWait = properties.getProperty("explicitWait");
		if (explicitWait != null)
			return Long.parseLong(explicitWait);
		else
			throw new RuntimeException("explicitlyWait not specified in the Configuration.properties file.");
	}

	/*
	 * This block of code will be helpful to get application URL from the
	 * properties file.
	 */
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public long getPollingTime() {
		String pollTime = properties.getProperty("pollingTime");
		if(pollTime != null){
			return Long.parseLong(pollTime);
		}
		else {
			throw new RuntimeException("Polling time not found in specified configuration file.");
		}
	}
	
	public String getTestDataFolderPath() {
		String testDatasheetPath = properties.getProperty("testDataPath");
		if(testDatasheetPath != null) {
			return testDatasheetPath;
		}
		else {
			throw new RuntimeException("The test data sheet path is not specified in configuration file.");
		}
	}
}