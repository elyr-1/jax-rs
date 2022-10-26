package com.example.demo.configuration;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.example.demo.controllers.UserController;

@Component
@ApplicationPath("/boot-jersey")
public class JerseyConfiguration extends ResourceConfig {
	
	public JerseyConfiguration() {
		register(UserController.class);
	}

}
