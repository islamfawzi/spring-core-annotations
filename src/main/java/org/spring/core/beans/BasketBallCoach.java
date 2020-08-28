package org.spring.core.beans;

import org.spring.core.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach {

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

}
