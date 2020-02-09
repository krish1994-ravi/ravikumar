package com.nt.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class MappedSQLOperationsTest {

	private static Logger logger=Logger.getLogger(MappedSQLOperationsTest.class);
	public static void main(String[] args) {
		logger.info("main method started");
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		try {
		// create IOC container
		logger.debug("container is created");
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service bean id
		service=ctx.getBean("empService", EmployeeMgmtService.class);
		//invoke method
		
			logger.info("service method is invoked");
		System.out.println(service.getEmployeeById(7499));
		//close continer
		}
		catch(DataAccessException dae) {
			logger.error("Exception occured in database");
			dae.getSuppressed();
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.info("main method ended");
		((AbstractApplicationContext) ctx).close();

	}

}
