package org.spring.core.app;

import java.util.logging.Logger;

import org.spring.core.beans.Coach;
import org.spring.core.beans.FootballCoach;
import org.spring.core.config.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigurationApp {

	final static Logger logger = Logger.getLogger(JavaConfigurationApp.class.getName());
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach coach = applicationContext.getBean(FootballCoach.class);
		logger.info(coach.getDailyWork());
		
		// cleanup 
		applicationContext.close();
	}

}
