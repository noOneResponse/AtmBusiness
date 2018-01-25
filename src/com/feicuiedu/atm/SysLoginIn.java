package com.feicuiedu.atm;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class SysLoginIn extends AtmServices implements Serializable,AbstractSys{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void action (HashMap<String, Object> map) {
		
		UserBusiness user = null;
		String idnum;
		String password;
		String name;
		String gender;
		String edu;
		String address;
		double amount = 0;
		while(true) {
			System.out.println("请输入身份证号(18位数字）");	
			idnum = scr.next();
			if(checkIdNum(idnum)) {
				break;
			}
			else {
				continue;
			}
		}
		while(true) {
			System.out.println("请输入密码");
			password = scr.next();
			if(checkPassword(password)) {
				break;
			}
			else {
				continue;
			}
		}
		while(true) {
			System.out.println("请输入姓名");
			name = scr.next();
			if(checkName(name)) {
				break;
			}
				continue;
		}
		while(true) {
			System.out.println("请输入姓别(1.代表男，2.代表女)");
			gender = scr.next();
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("InformationTxt"+File.separator+"Gender.properties")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String className = prop.getProperty(gender);
			if (className == null) {
				System.out.println("输入错误，请重新输入");
				continue;
			}
			gender = className;
			break;
		}
		while(true) {
			System.out.println("请输入学历");
			System.out.println("1.小学，2.中学，3.大学，4.其他");
			edu = scr.next();
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("InformationTxt"+File.separator+"UserEdu.properties")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String className = prop.getProperty(edu);
			if (className == null) {
				System.out.println("输入错误，请重新输入");
				continue;
			}
			edu = className;
			break;
		}
		while(true) {
			System.out.println("请输入联系地址");
			address = scr.next();
			if(address.length()<=50) {
				break;
			}
			else {
				System.out.println("地址需要少于50字");
				continue;
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmssSSS");
		String time = sdf.format(new Date());
		String account = "37"+ gender +time;
		System.out.println("注册成功");
		System.out.println("你的账号是"+account);
		gender = "01".equals(gender)?"男":"女";
		user = new UserBusiness(account,password,name,idnum,
				gender,edu,amount,address);
		System.out.println(user);
		map.put(account+idnum,user);
		
		
		sysLogin(map);
		
		}
			
	public void sysLogin(HashMap<String, Object> map) {
		while(true) {
			System.out.println("1.继续注册，2.返回菜单，3，退卡");
			String str = scr.next();
			if("1".equals(str)) {
				action(map);
			}
			else if("2".equals(str)) {
				SysMenu sysmenu = new SysMenu();
				sysmenu.action(map);
			}
			else if("3".equals(str)) {
				SysExit se = new SysExit();
				//输出集合到文件中
				se.action(map);
			}
			else {
				System.out.println("输入错误，请重新输入");
				continue;
			}
		}
	}
}
