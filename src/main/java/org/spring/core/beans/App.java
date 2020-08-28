package org.spring.core.beans;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	final static Logger logger = Logger.getLogger(App.class.getName());
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// inject myCoach bean
		Coach myCoach = applicationContext.getBean("myCoach", Coach.class);
	
		logger.info(myCoach.getDailyWork());
		
		// clean up applicationContext
		applicationContext.close();
		
	}

}