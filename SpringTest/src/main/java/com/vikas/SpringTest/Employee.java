package com.vikas.SpringTest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee implements InitializingBean{

	private int id;
	private String name;
	private String dept;
	private String designation;
	private int salary;
	
	@Autowired
	@Qualifier("addr2")
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "Id:"+id+", Name:"+name+", Department:"+dept+", Designation:"+designation+", Salary:"+salary+"\n"+address;
	}
	
/*	public void xyz() {
		
	}
	*/
	public void cleanUp() throws Exception{
		System.out.println("Bean destroyed...");
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean initializing after property set...");
		
	}
}
