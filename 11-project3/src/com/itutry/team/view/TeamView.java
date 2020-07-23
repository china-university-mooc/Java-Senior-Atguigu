package com.itutry.team.view;

import com.itutry.team.domain.Employee;
import com.itutry.team.domain.Programmer;
import com.itutry.team.service.NameListService;
import com.itutry.team.service.TeamException;
import com.itutry.team.service.TeamService;
import com.itutry.team.util.TSUtility;

public class TeamView {

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {
		boolean loopFlag = true;
		char selection = 0;
		while (loopFlag) {
			if (selection != '1') {
				listAllEmployees();
			}
			
			System.out.println("1-团队成员列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");

			selection = TSUtility.readMenuSelection();
			switch (selection) {
			case '1':
				listTeamMembers();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("确认是否退出(Y/N)：");
				char confirm = TSUtility.readComfirmSelection();
				if (confirm == 'Y') {
					loopFlag = false;
				}
				break;
			}
		}
	}

	private void listAllEmployees() {
		System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");
		Employee[] allEmployees = listSvc.getAllEmployees();
		if (allEmployees == null || allEmployees.length == 0) {
			System.out.println("公司暂时没有员工");
		} else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			for (int i = 0; i < allEmployees.length; i++) {
				System.out.println(allEmployees[i]);
			}
		}
		System.out.println("----------------------------------------------------------------------------------------------");
	}

	private void listTeamMembers() {
		System.out.println("--------------------团队成员列表---------------------");
		Programmer[] programmers = teamSvc.getTeam();
		if (programmers == null || programmers.length == 0) {
			System.out.println("团队暂时没有成员");
		} else {
			System.out.println("TDI/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
			for (int i = 0; i < programmers.length; i++) {
				System.out.println(programmers[i].getInfoForTeam());
			}
		}

		System.out.println("-----------------------------------------------------");
	}

	private void addMember() {
		System.out.println("---------------------添加成员---------------------");
		System.out.println("请输出要添加的员工ID：");
		int id = TSUtility.readInt();

		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		} 

		TSUtility.readReturn();
	}

	private void deleteMember() {
		System.out.println("---------------------删除成员---------------------");
		System.out.println("请输入要删除员工的TID：");
		int memberId = TSUtility.readInt();
		
		System.out.println("确认是否删除(Y/N)：");
		char confirm = TSUtility.readComfirmSelection();
		if (confirm == 'N') {
			return;
		}
		
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		} 
		
		TSUtility.readReturn();
	}

	public static void main(String[] args) {
		new TeamView().enterMainMenu();
	}
}
