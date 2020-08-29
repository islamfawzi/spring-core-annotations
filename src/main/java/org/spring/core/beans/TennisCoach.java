package org.spring.core.beans;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
		logger.info(this.getClass().getSimpleName() + "Coach Constructor called!!");
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
	
	/** PostConstruct & PreDestory 
	  * The method can have any access modifier (public, protected, private)
	  * can have any return type. However, you will not be able to capture the return value
	  * can have any method name
	  * can not accept any arguments, The method should be no-arg.
	  **/
	@PostConstruct
	private void postConstruct() {
		logger.info(sport + "Coach -> PostConstruct");
	}
	
	/** PreDestory method are not called for prototype bean scope, that is also applied on XML configuration
	  * you have to make custom BeanPostProcessor to call destroy method of prototype beans **/
	@PreDestroy
	private void preDestory() {
		logger.info(sport + "Coach -> PreDestroy");
	}
	
}
