package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class ExampleComponent.
 */
@Component("exampleComponent")
public class ExampleComponent {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	/**
	 * Say hello.
	 */
	public void sayHello() {
		LOG.info("HELLO FROM EXAMPLECOMPONENT ");
	}

}
