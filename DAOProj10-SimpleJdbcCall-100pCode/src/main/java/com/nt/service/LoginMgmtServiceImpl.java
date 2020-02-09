package com.nt.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.LoginDAO;


@Service("loginService")
public class LoginMgmtServiceImpl implements LoginMgmtService {
	@Autowired
	private LoginDAO dao;

	private static Logger logger=Logger.getLogger(LoginMgmtServiceImpl.class);
	@Override
	public String validate(String uname, String pwd) {
		logger.info("service validate method started");
		// use dao
		return dao.resgister(uname, pwd);
	}

}
