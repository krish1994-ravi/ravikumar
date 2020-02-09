package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository 
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPLOYEE_BY_ID="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=:id";
	//private static final String GET_EMPLOYEE_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(:desg1,:desg2)";
	//private static final String INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(:empNo,:ename,:job,:sal,:deptNo)";
	
	private static Logger logger=Logger.getLogger(EmployeeDAOImpl.class);
	
	private SelectEmployeeById select1=null;
	
	@Autowired
	public EmployeeDAOImpl(DataSource ds) {
		logger.info("EmployeeDAOImpl.EmployeeDAOImpl()-->constrctor with DataSource argument");
        select1=new SelectEmployeeById(ds, GET_EMPLOYEE_BY_ID); 		
	}
	

	@Override
	public EmployeeBO getEmployeeById(int id) {
		logger.info("dao methos is perform db operations");
		return select1.findObject(id);
	}
	
	private class SelectEmployeeById extends MappingSqlQuery<EmployeeBO>{
		
		public SelectEmployeeById(DataSource ds,String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
			
		}

		@Override
		protected EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			logger.debug("Inner class method with arguments is started with rs,rowNum");
			EmployeeBO bo=null;
			// convert rs to bo
			bo=new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			bo.setDeptNo(rs.getInt(5));
			logger.debug("Inner class method with arguments is ended with rs,rowNum");
			return bo;
			
		}
		
	}
	
	

}
