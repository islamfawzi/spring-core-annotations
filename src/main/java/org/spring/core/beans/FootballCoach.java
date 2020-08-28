package org.spring.core.beans;

import org.springframework.stereotype.Component;

@Component("myCoach")
public class FootballCoach implements Coach {
	
	public FootballCoach() {
	}

	public String getDailyWork() {
		return "Playing Football!";
	}	
}
