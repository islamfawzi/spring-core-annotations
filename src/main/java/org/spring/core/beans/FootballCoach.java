package org.spring.core.beans;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.spring.core.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("myCoach")
@Component // spring will generate default bean id=footballCoach
public class FootballCoach implements Coach {
	
	final Logger logger = Logger.getLogger(this.getClass().getName());
	
	private FortuneService fortuneService;
	
	@Value("${coach.football}")
	private String sport;
	

	/** Constructor injection **/
	/** create constructor and annotate it with @Autowired **/
	@Autowired
	public FootballCoach(@Qualifier("fortuneServiceImpl") FortuneService fortuneService) { /** @Qulaifier with constructor injection **/
		
		logger.info(this.getClass().getSimpleName() + " Constructor called!!");
		
		this.fortuneService = fortuneService;
	}

	public String getDailyWork() {
		return "Playing Football!";
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
