package com.nt.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.service.LoginMgmtService;


public class SimpleJdbcCallTest {

	private static Logger logger=Logger.getLogger(SimpleJdbcCallTest.class);
	
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		logger.debug("main method statred");
		
		ApplicationContext ctx=null;
		LoginMgmtService service=null;
		try {
		// create IOC Container
		logger.info("container is created");
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get service object
		service=ctx.getBean("loginService",LoginMgmtService.class);
		
		//invoke method
		
			logger.info("business method execute");
			System.out.println(service.validate("ravi","rama"));
		}
		catch(DataAccessException dae) {
			logger.error("internal db problem");
			//dae.printStackTrace();
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			//dae.printStackTrace();
		}
		logger.debug("main method is ended");
		
		((AbstractApplicationContext) ctx).close();

	}

}
