package org.spring.core.services;

import org.springframework.stereotype.Component;

@Component
//@Primary         // if more than bean you can specify which of them is the primary
public class FortuneServiceImpl implements FortuneService {

	public String getFortune(String coach) {
		return String.format("This is the %s fortune!", coach);
	}

}
