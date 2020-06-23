package com.cucumber.poc;

import java.sql.Connection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cucumber.poc.configuration.SystemConfiguration;
import com.cucumber.poc.configuration.exception.DeltaException;
import com.cucumber.poc.vo.Response;
import com.cucumber.poc.vo.UserVO;

@Service
public class TestService {

	@Autowired
	TestConfiguration testConfiguration;

	private Object peSession;

	SystemConfiguration systemConfiguration;

	public boolean login(String username, String password) throws Exception {

		System.out.println("username: " + testConfiguration.username);

		if (username.equalsIgnoreCase(testConfiguration.username)
				&& password.equalsIgnoreCase(testConfiguration.password)) {
			return true;
		}

		throw new Exception("Invalid credentials");

	}
	
	public Response testMethod(String arg1, String arg2, String arg3, String arg4) {
	    
	    Response response = null;
	    
	    if(arg1.equalsIgnoreCase(arg2) && arg3.equalsIgnoreCase(arg4)) {
	        response = new Response();
	        response.setStatus(HttpStatus.OK);
	        response.setMessage("Method verified");
	    }
	    
	    return response;
	    
	}
	
//	public synchronized Object getPESession(UserVO userVO, String connectionPointProperty) throws DeltaException {
//
//		Object object3 = null;
//
//		if (peSession == null) {
//			Map ceXmlMap = this.systemConfiguration.getPropertyXMLMap("CeData1");
//			String connectionUrl = (String) ceXmlMap.get("connectionUrl");
//			if (connectionUrl.startsWith("http")) {
//				System.setProperty("java.naming.factory.initial", (String) ceXmlMap.get("InitialContextValue"));
//				System.setProperty((String) ceXmlMap.get("WaspLocation"), (String) ceXmlMap.get("WaspLocationValue"));
//			}
//
//			if (connectionPointProperty != null) {
//				try {
//					Connection connection = com.filenet.api.core.Factory.Connection.getConnection(connectionUrl);
//					userContext userContext = UserContext.get();
//					Subject subject = UserContext.createSubject(connection, userVO.getUserId(), userVO.getPassword(),
//							(Striing) ceXmlMap.get("JaasLogin"));
//					userContext.pushSubject(subject);
//					this.peSession = new VWSession();
//					this.peSession.setBootStrapEURIL(connectionUrl);
//					this.peSession.logon(userVO.getUserId(), userVO.getPassword(), connectionPointProperty);
//					return peSession;
//				} catch (Exception e) {
//					this.peSession = object3;
//					e.printStackTrace();
//					throw new DeltaException("com.ipd.common.peserivice.perserviceimpl.pesessionproblem", e);
//				}
//			}
//		}
//	}
}
