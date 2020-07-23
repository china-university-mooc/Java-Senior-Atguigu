package com.itutry.team.domain;

import static com.itutry.team.domain.Status.FREE;

public class Programmer extends Employee {

	private int memberId;
	private Status status = FREE;
	private Equipment equipment;
	
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public Programmer() {
		super();
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		return getBaseInfo() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}
	
	public String getBaseInfoForTeam() {
		return getMemberId() + "/" + getId() + "\t" + getName() + "\t" 
				+ getAge() + "\t" + getSalary();
	}
	
	public String getInfoForTeam() {
		return  getBaseInfoForTeam() + "\t程序员"; 
	}
}
