package com.cucumber.poc.configuration;

import java.util.Map;

public interface SystemConfiguration {
	public Map getPropertyXMLMap(final String s);
	
	public void setConfigurationData(final ConfigurationData configurationData);
}
