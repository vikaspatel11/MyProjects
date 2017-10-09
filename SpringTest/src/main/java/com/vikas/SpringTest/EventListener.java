package com.vikas.SpringTest;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class EventListener implements ApplicationListener<ContextStartedEvent>{

	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("Context has been Started....");
	}
	
}
