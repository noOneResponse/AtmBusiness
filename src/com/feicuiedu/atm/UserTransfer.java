package com.feicuiedu.atm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class UserTransfer extends AtmServices implements AbstractUser{
	
	private double amount;
	public void action(UserBusiness user,HashMap<String, Object> map) {	
	
		aa:
		while(true) {	
			UserBusiness another = (UserBusiness) map.get(existUser(map));
			
			if(!another.equals(user)) {		
				while(true) {
					System.out.println("请输入转账金额");
					amount = Integer.valueOf(scr.next());
					if(amount<user.getAmount() && amount>0) {
						tasferMenu(user,another,map);
						break aa;
					}
					else {
						System.out.println("余额不足，请重新输入");
						continue;
					}
				}
			}
			else {
				System.out.println("不能给自己转账");
				continue;
			}
		}
	}
	public void tasferMenu(UserBusiness user,UserBusiness another,HashMap<String, Object> map) {
		while(true) {
			System.out.println("1.确认，2.返回菜单，3.退卡");
			String str = scr.next();
			if("1".equals(str)) {
				System.out.println("对方用户名:"+another.getUser());
				System.out.println("转账金额:"+amount);
				confirmTransfer(user,another,map);
				break;
			}
			else if("2".equals(str)) {
				UserMenu menu = new UserMenu();
				menu.action(user,map);
			}
			else if("3".equals(str)) {
				UserExit exit = new UserExit();
				exit.action(user, map);
			}
			else {
				System.out.println("输入错误，请重新输入");
				continue;
			}
		}
	}
	public void confirmTransfer(UserBusiness user,UserBusiness another,HashMap<String, Object> map) {
		while(true) {
			System.out.println("1.确认，2.返回上一步，3.退卡");
			String str = scr.next();
			if("1".equals(str)) {
				user.setAmount(user.getAmount()-amount);
				another.setAmount(another.getAmount()+amount);
				System.out.println("现在的余额:"+user.getAmount());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
				String time = sdf.format(new Date());
				user.getList().add(time+" "+"转账支出:"+amount+"元");
				another.getList().add(time+" "+"转账收入:"+amount+"元");
				break;
			}
			else if("2".equals(str)) {
				action(user,map);
			}
			else if("3".equals(str)) {
				UserExit exit = new UserExit();
				exit.action(user, map);
			}
			else {
				System.out.println("输入错误，请重新输入");
				continue;
			}
		}
	}
}
