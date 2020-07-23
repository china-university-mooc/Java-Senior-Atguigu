package com.itutry.team.test;

import com.itutry.team.domain.Employee;
import com.itutry.team.service.NameListService;
import com.itutry.team.service.TeamException;
import java.util.List;
import org.junit.Test;

public class NameListServiceTest {

	@Test
	public void testGetAllEmployees() {
		NameListService nameListService = new NameListService();
		List<Employee> allEmployees = nameListService.getAllEmployees();
		for(Employee e : allEmployees) {
			System.out.println(e);
		}
	}

	@Test
	public void testGetEmployee() {
		NameListService nameListService = new NameListService();
		int id = 111;
		try {
			Employee employee = nameListService.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
