package org.spring.core.beans;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.spring.core.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")  /** spring container will create single bean instance and save in memory
					  ** every time inject the bean will return the same object **/
public class BasketBallCoach implements Coach {

	final Logger logger = Logger.getLogger(this.getClass().getName());

	/** AutoWired the service using field injection **/
	/** accomplished using Java Reflection **/
	@Autowired
	@Qualifier("randomService")   // specify the service to be injected
	private FortuneService fortuneService;
	
	@Value("${coach.basketball}")
	private String sport;
	
	public String getDailyWork() {
		return "Playing BasketBall!!";
	}

	public String getFortune() {
		return fortuneService.getFortune(sport);
	}
	
	/** PostConstruct & PreDestory 
	  * The method can have any access modifier (public, protected, private)
	  * can have any return type. However, you will not be able to capture the return value
	  * can have any method name
	  * can not accept any arguments, The method should be no-arg.
	  **/
	@PostConstruct
	private void postConstruct() {
		logger.info(sport + "Coach -> PostConstruct");
	}
	
	@PreDestroy
	private void preDestory() {
		logger.info(sport + "Coach -> PreDestroy");
	}

}
