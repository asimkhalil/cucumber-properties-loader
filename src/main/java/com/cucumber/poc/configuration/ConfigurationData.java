package com.cucumber.poc.configuration;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.cucumber.poc.configuration.exception.DeltaException;

import it.svario.xpathapi.jaxp.XPathAPI;

public class ConfigurationData {

	public Map getConfigMapData(final String s) {
		final HashMap hashMap = new HashMap();
		Document parse;

		try {
			parse = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new InputSource(new StringReader(s)));
		} catch (SAXException e) {
			throw new DeltaException("com.ipd.common.util.GetConfigMapDataError", e);
		} catch (IOException e) {
			throw new DeltaException("com.ipd.common.util.GetConfigMapDataError", e);
		} catch (ParserConfigurationException e) {
			throw new DeltaException("com.ipd.common.util.GetConfigMapDataError", e);
		}

		NodeList selectedNodeList;

		try {
			parse.getDocumentElement().normalize();
			selectedNodeList = XPathAPI.selectNodeList((Node) parse.getDocumentElement(), "/ValueObject/Fields/Field");
		} catch (Exception e) {
			throw new DeltaException("com.ipd.common.util.GetConfigMapDataError", e);
		}

		for (int i = 0; i < selectedNodeList.getLength(); ++i) {
			hashMap.putAll(this.configValues(selectedNodeList.item(i)));
		}

		return hashMap;
	}

	private Map configValues(Node item) {
		// TODO Auto-generated method stub
		return null;
	}

}
