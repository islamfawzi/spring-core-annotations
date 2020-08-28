package org.spring.core.services;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	public String getFortune() {
		return "This is your lucky day!";
	}

}
