package com.vikas.SpringTest;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext  appContext = new ClassPathXmlApplicationContext("beans.xml");
    	appContext.start();
    	ServiceImpl service = (ServiceImpl) appContext.getBean("service");
    	service.print();
    }
}

