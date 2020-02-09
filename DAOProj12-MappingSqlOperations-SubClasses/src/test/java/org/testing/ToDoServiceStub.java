package org.testing;

import java.util.Arrays;
import java.util.List;

import com.nt.xyz.ToDoService;

public class ToDoServiceStub implements ToDoService {

	@Override
	public List<String> getTodos(String user) {
		return Arrays.asList(" Use Core Java ", " Use Spring Core ", " Use Hibernate ", " Use Spring MVC "); 
	}

}
