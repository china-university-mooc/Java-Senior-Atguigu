package com.itutry.team.test;

import org.junit.Test;

import com.itutry.team.domain.Employee;
import com.itutry.team.service.NameListService;
import com.itutry.team.service.TeamException;

public class NameListServiceTest {

	@Test
	public void testGetAllEmployees() {
		NameListService nameListService = new NameListService();
		Employee[] allEmployees = nameListService.getAllEmployees();
		for (int i = 0; i < allEmployees.length; i++) {
			System.out.println(allEmployees[i]);
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
