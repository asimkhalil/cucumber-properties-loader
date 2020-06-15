package com.cucumber.poc.configuration;

import java.util.Map;

public class SystemConfigurationImpl implements SystemConfiguration {

	private ConfigurationData configurationData;
	
	public Map getPropertyXMLMap(final String s) {
		return this.configurationData.getConfigMapData((String) this.getProperty(s));
	}

	private String getProperty(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setConfigurationData(ConfigurationData configurationData) {
		this.configurationData = configurationData;
	}

}
