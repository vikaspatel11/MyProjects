package com.vikas.SpringTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class ServiceImpl {

	@Autowired
	@Qualifier("emp2")
	private Employee emp;
	
	public void print() {
		System.out.println("I am inside Service Impl::"+emp.toString());
	}
}
