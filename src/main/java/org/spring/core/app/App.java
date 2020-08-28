package org.spring.core.app;

import java.util.logging.Logger;

import org.spring.core.beans.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	final static Logger logger = Logger.getLogger(App.class.getName());
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/** explicit bean id **/
		// Coach myCoach = applicationContext.getBean("myCoach", Coach.class);
		// logger.info(myCoach.getDailyWork());
		
		/** default bean id **/
		Coach footballCoach = applicationContext.getBean("footballCoach", Coach.class);
		logger.info(footballCoach.getDailyWork());
		
		/** constructor injection **/ 
		logger.info(footballCoach.getFortune());
		
		/** setter injection **/
		Coach tennisCoach = applicationContext.getBean("tennisCoach", Coach.class);
		logger.info(tennisCoach.getFortune());
		
		/** field injection **/
		Coach basketBallCoach = applicationContext.getBean("basketBallCoach", Coach.class);
		logger.info(basketBallCoach.getFortune());
		
		/** clean up applicationContext **/
		applicationContext.close();
		
	}

}
