package com.inteliment.counterapi.services;

import org.springframework.stereotype.Component;

@Component
public class GoodMorningServiceImpl implements HiService{

	@Override
	public String sayHi() {
		return "Good Morning";
	}

	
}
