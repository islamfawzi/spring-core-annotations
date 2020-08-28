package org.spring.core.beans;

import org.springframework.stereotype.Component;

//@Component("myCoach")
@Component // spring will generate default bean id=footballCoach
public class FootballCoach implements Coach {
	
	public FootballCoach() {
	}

	public String getDailyWork() {
		return "Playing Football!";
	}	
}
