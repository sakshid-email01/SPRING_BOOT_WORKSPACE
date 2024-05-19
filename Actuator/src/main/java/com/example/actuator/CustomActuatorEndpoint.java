package com.example.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
// this acts like a custom controller class for creating custom
// actuator endpoint
@Component
@Endpoint(id="customActuatorEndpoint")
public class CustomActuatorEndpoint {
	
	@ReadOperation
	public String customActuatorEndpoint() {
		return "this is the response from customActuatorEndpoint";
	}

}
