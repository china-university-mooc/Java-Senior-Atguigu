package com.itutry.team.service;

import static com.itutry.team.domain.Status.BUSY;
import static com.itutry.team.domain.Status.FREE;

import com.itutry.team.domain.Architect;
import com.itutry.team.domain.Designer;
import com.itutry.team.domain.Employee;
import com.itutry.team.domain.Programmer;

public class TeamService {

	private static int counter = 1;
	private static final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;

	public Programmer[] getTeam() {
		Programmer[] result = new Programmer[total];
		for (int i = 0; i < result.length; i++) {
			result[i] = team[i];
		}
		return result;
	}

	public void addMember(Employee e) throws TeamException {
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}

		if (!(e instanceof Programmer)) {
			throw new TeamException("该员工不是开发人员，无法添加");
		}

		if (isInTeam(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}

		Programmer p = (Programmer) e;

		switch (p.getStatus()) {
			case BUSY:
				throw new TeamException("该员工已是某团队成员");
			case VOCATION:
				throw new TeamException("该员工正在休假，无法添加");
		}

		int numOfArchitect = 0;
		int numOfDesigner = 0;
		int numOfProgrammer = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArchitect++;
			} else if (team[i] instanceof Designer) {
				numOfDesigner++;
			} else if (team[i] instanceof Programmer) {
				numOfProgrammer++;
			}
		}

		if (p instanceof Architect) {
			if (numOfArchitect >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		} else if (p instanceof Designer) {
			if (numOfDesigner >= 2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		} else {
			if (numOfProgrammer >= 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}

		p.setMemberId(counter++);
		p.setStatus(BUSY);
		team[total++] = p;
	}

	private boolean isInTeam(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeMember(int memberId) throws TeamException {
		int i;
		for (i = 0; i < total; i++) {
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(FREE);
				team[i].setMemberId(0);
				break;
			}
		}

		if (i == total) {
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}

		for (int j = i + 1; j < total; j++) {
			team[j - 1] = team[j];
		}

		team[--total] = null;
	}
}
