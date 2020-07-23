package com.itutry.team.service;

import static com.itutry.team.domain.Status.BUSY;
import static com.itutry.team.domain.Status.FREE;

import com.itutry.team.domain.Architect;
import com.itutry.team.domain.Designer;
import com.itutry.team.domain.Employee;
import com.itutry.team.domain.Programmer;
import java.util.ArrayList;
import java.util.List;

public class TeamService {

	private static int counter = 1;
	private static final int MAX_MEMBER = 5;
	private List<Programmer> team = new ArrayList<>(MAX_MEMBER);

	public List<Programmer> getTeam() {
		return team;
	}

	public void addMember(Employee e) throws TeamException {
		if (team.size() >= MAX_MEMBER) {
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
		for (int i = 0; i < team.size(); i++) {
			if (team.get(i) instanceof Architect) {
				numOfArchitect++;
			} else if (team.get(i) instanceof Designer) {
				numOfDesigner++;
			} else if (team.get(i) instanceof Programmer) {
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
		team.add(p);
	}

	private boolean isInTeam(Employee e) {
		for (Programmer p : team) {
			if (p.getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeMember(int memberId) throws TeamException {
		int i;
		for (i = 0; i < team.size(); i++) {
			if (team.get(i).getMemberId() == memberId) {
				team.get(i).setStatus(FREE);
				team.get(i).setMemberId(0);
				break;
			}
		}

		if (i == team.size()) {
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}

		team.remove(i);
	}
}
