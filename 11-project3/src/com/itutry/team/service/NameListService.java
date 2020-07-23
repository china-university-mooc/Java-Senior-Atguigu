package com.itutry.team.service;

import static com.itutry.team.util.Data.ARCHITECT;
import static com.itutry.team.util.Data.DESIGNER;
import static com.itutry.team.util.Data.EMPLOYEE;
import static com.itutry.team.util.Data.EMPLOYEES;
import static com.itutry.team.util.Data.NOTEBOOK;
import static com.itutry.team.util.Data.PC;
import static com.itutry.team.util.Data.PRINTER;
import static com.itutry.team.util.Data.PROGRAMMER;

import com.itutry.team.domain.Architect;
import com.itutry.team.domain.Designer;
import com.itutry.team.domain.Employee;
import com.itutry.team.domain.Equipment;
import com.itutry.team.domain.NoteBook;
import com.itutry.team.domain.PC;
import com.itutry.team.domain.Printer;
import com.itutry.team.domain.Programmer;
import com.itutry.team.util.Data;

public class NameListService {

	private Employee[] employees;

	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		for (int i = 0; i < employees.length; i++) {
			employees[i] = parseEmployee(EMPLOYEES[i], i);
		}
	}

	private Employee parseEmployee(String[] arr, int index) {
		int type = Integer.parseInt(arr[0]);

		int id = Integer.parseInt(arr[1]);
		String name = arr[2];
		int age = Integer.parseInt(arr[3]);
		double salary = Double.parseDouble(arr[4]);

		Equipment equitment = null;
		double bonus = 0.0;
		switch (type) {
		case EMPLOYEE:
			return new Employee(id, name, age, salary);
		case PROGRAMMER:
			equitment = parseEquipment(Data.EQUIPMENTS[index]);
			return new Programmer(id, name, age, salary, equitment);
		case DESIGNER:
			equitment = parseEquipment(Data.EQUIPMENTS[index]);
			bonus = Double.parseDouble(arr[5]);
			return new Designer(id, name, age, salary, equitment, bonus);
		case ARCHITECT:
			equitment = parseEquipment(Data.EQUIPMENTS[index]);
			bonus = Double.parseDouble(arr[5]);
			int stock = Integer.parseInt(arr[6]);
			return new Architect(id, name, age, salary, equitment, bonus, stock);
		}
		return null;
	}

	private Equipment parseEquipment(String[] arr) {
		int key = Integer.parseInt(arr[0]);

		String modelOrName = arr[1];
		switch (key) {
		case PC:
			String display = arr[2];
			return new PC(modelOrName, display);
		case NOTEBOOK:
			double price = Double.parseDouble(arr[2]);
			return new NoteBook(modelOrName, price);
		case PRINTER:
			String type = arr[2];
			return new Printer(modelOrName, type);
		}
		return null;
	}

	public Employee[] getAllEmployees() {
		return employees;
	}

	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		
		throw new TeamException("找不到指定员工");
	}
}
