package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public EmployeeBO getEmployeeById(int id);
	
	//public List<EmployeeBO> getEmployeeDetailsByDesg(String desg1,String desg2);
	
	//public int insert(EmployeeBO bo);

}
