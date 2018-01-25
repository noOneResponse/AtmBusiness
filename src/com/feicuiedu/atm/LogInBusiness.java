package com.feicuiedu.atm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class LogInBusiness extends AtmServices implements Serializable,AbstractSys{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sysUser ="000000000000000000";
	private String sysPassword="000A";

	
	public void action(HashMap<String, Object> map) {
		
		map = new HashMap<String, Object>();
		map = LoginFile(map);
		

		System.out.println("1.管理员，2.普通用户");
		String csuer = scr.next();
		while(true) {
			if("1".equals(csuer)) {
				System.out.println("请输入账号");
				String user = scr.next();
				if(checkUser(user)) {
					if(sysUser.equals(user)) {
						System.out.println("请输入密码");
						String password = scr.next();
						existSysPassword(password,map);
					}
				}
				else{
					System.out.println("卡号格式不正确（21位）");
					continue;
				}
			}
			else if("2".equals(csuer)) {
				String key = existUser(map);
				System.out.println("请输入密码");
				String password = scr.next();
				UserBusiness user = (UserBusiness) map.get(key);
				if(user.getPassword().equals(password)) {
					UserMenu usermenu = new UserMenu();
					usermenu.action(user,map);
				}
				
			}
		}
	}
	public void existSysPassword(String Password,HashMap<String, Object> map) {
		if(sysPassword.equals(Password)) {
			System.out.println("登陆成功");
			
			SysMenu sm = new SysMenu();
			sm.action(map);
		}
		else {
			System.out.println("密码错误，请重新输入");
			action(null);
		}
		
	}
	public boolean existUser(String user) {
		return true;
	}

}
