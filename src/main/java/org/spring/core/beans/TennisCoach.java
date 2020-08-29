package org.spring.core.beans;

import java.util.logging.Logger;

import org.spring.core.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")   /** spring container will create new bean instance every time inject this bean **/ 
public class TennisCoach implements Coach {

	final Logger logger = Logger.getLogger(this.getClass().getName());
	
	private FortuneService fortuneService;
	
	@Value("${coach.tennis}")
	private String sport;

	public TennisCoach() {
		logger.info(sport + "Coach Constructor called!!");
	}

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
