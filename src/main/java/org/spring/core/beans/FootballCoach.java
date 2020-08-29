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
	
	public FootballCoach() {
		logger.info(sport + "Coach Constructor called!!");
	}

	/** Constructor injection **/
	/** create constructor and annotate it with @Autowired **/
	@Autowired
	public FootballCoach(@Qualifier("fortuneServiceImpl") FortuneService fortuneService) { /** @Qulaifier with constructor injection **/
		this.fortuneService = fortuneService;
	}

	public String getDailyWork() {
		return "Playing Football!";
	}

	public String getFortune() {
		return fortuneService.getFortune(sport); 
	}	
	
}
