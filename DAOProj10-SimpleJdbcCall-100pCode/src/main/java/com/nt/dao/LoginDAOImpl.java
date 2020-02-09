package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	
	@Autowired
	private SimpleJdbcCall sjc;
	
	private static Logger logger=Logger.getLogger(LoginDAOImpl.class);

	@Override
	public String resgister(String uname, String pwd) {
		logger.debug(" dao register method is started");
		
		Map<String,Object> inParams=null;
		//Map<String,Object> outParams=null;
		//create Map Object to set param values to procedure
		inParams=new HashMap();
		
		sjc.setProcedureName("P_AUTH");
		inParams.put("uname", uname);
		inParams.put("pwd", pwd);
		
		logger.info("procedure is set");
		
		
		// use sjc
		//outParams=sjc.execute(inParams);
		
		logger.debug("dao register method ended");
		
		//return sjc.executeObject(String.class, inParams);
		return (String) sjc.execute(inParams).get("RESULT");
	}

}
