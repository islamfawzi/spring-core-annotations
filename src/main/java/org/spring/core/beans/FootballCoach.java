package org.spring.core.beans;

import org.spring.core.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("myCoach")
@Component // spring will generate default bean id=footballCoach
public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${coach.football}")
	private String sport;
	
	public FootballCoach() {
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
