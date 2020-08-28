package org.spring.core.services;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	public String getFortune(String coach) {
		return String.format("This is the %s fortune!", coach);
	}

}
