package org.spring.core.beans;

import org.spring.core.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	/** setter injection **/
	/** create setter method and annotate it with @Autowired **/
	@Autowired 
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWork() {
		return "playing tennis!!";
	}

	public String getFortune() {
		return fortuneService.getFortune("Tennis");
	}

}