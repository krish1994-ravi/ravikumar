package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeDAO dao;

	private static Logger logger=Logger.getLogger(EmployeeDAOImpl.class);
	
	@Override
	public EmployeeDTO getEmployeeById(int id) {
		logger.debug("service method started");
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		// use dao
		bo=dao.getEmployeeById(id);
		//convert bo to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		logger.debug("service method ended");
		return dto;
	}
	
	/*@Override
	public List<EmployeeDTO> getEmployeeByDesgs(String desg1, String desg2) {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		// use dao
		listBO=dao.getEmployeeDetailsByDesg(desg1, desg2);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}
	@Override
	public String addEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		// convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.insert(bo);
		return (count==0)?"employee Registration failed":"Employee registration success";
	}
	*/
}
