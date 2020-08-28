package org.spring.core.beans;

import org.spring.core.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${coach.tennis}")
	private String sport;

	/** setter injection **/
	/** create setter method and annotate it with @Autowired **/
	/** setter method can be with any name, not like xml configuration **/
	@Autowired 
	@Qualifier("fortuneServiceImpl")   // specify the service to be injected
	public void setFortuneService11(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWork() {
		return "playing tennis!!";
	}

	public String getFortune() {
		return fortuneService.getFortune(sport);
	}
	
}
