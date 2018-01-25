package com.feicuiedu.atm;


import java.util.HashMap;


public class SysCancellation extends AtmServices implements AbstractSys {
	public void action (HashMap<String, Object> map) {
		
		String user = existUser(map);
		user = user.substring(0,21);
		
		while(true) {
			System.out.println("请输入身份证号");
			String idnum = scr.next();
			if(map.containsKey(user+idnum)) {
				map.remove(user+idnum);
				break;
			}
			else {
				System.out.println("身份证号输入错误，请重新输入");
			}
		}
		System.out.println("注销成功");
	}
}
