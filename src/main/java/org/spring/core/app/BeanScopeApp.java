package org.spring.core.app;

import java.util.logging.Logger;

import org.spring.core.beans.BasketBallCoach;
import org.spring.core.beans.Coach;
import org.spring.core.beans.FootballCoach;
import org.spring.core.beans.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

	final static Logger logger = Logger.getLogger(BeanScopeApp.class.getName());
	
	public static void main(String[] args) {

		// load application context
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		/** check Singleton default Bean Scope **/
		Coach footballCoach1 = applicationContext.getBean(FootballCoach.class);
		Coach footballCoach2 = applicationContext.getBean(FootballCoach.class);            // will inject the same instance every time
		logger.info("Default Scope: Same object: " + (footballCoach1 == footballCoach2));  // true

		/** check Singleton Bean scope **/
		Coach basketBallCoach1 = applicationContext.getBean(BasketBallCoach.class);
		Coach basketBallCoach2 = applicationContext.getBean(BasketBallCoach.class);             // will inject the same instance every time 
		logger.info("Singleton Scope: Same object: " + (basketBallCoach1 == basketBallCoach2)); // true
		
		Coach tennisCoach1 = applicationContext.getBean(TennisCoach.class);
		Coach tennisCoach2 = applicationContext.getBean(TennisCoach.class);  		     // will inject new instance every time 
		logger.info("Prototype Scope: Same object: " + (tennisCoach1 == tennisCoach2));  // false
		
		// cleanup the spring application context
		applicationContext.close();
	}

}
