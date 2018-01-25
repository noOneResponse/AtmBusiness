package com.feicuiedu.atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class SysModify extends AtmServices implements AbstractSys{
	public void action(HashMap<String, Object> map) {
		
		String key = existUser(map);
		while(true) {
			System.out.println("请输入新密码");
			String password =scr.next();
			if(checkPassword(password)) {
				((UserBusiness) map.get(key)).setPassword(password);
				break;
			}
			else {
				continue;
			}
		}
		while(true) {
			System.out.println("请输入新姓名");
			String name =scr.next();
			if(checkName(name)) {
				((UserBusiness) map.get(key)).setName(name);
				break;
			}
				continue;
		}
		
		while(true) {
			System.out.println("请输入新学历");
			System.out.println("1.小学，2.中学，3.大学，4.其他");
			String edu =scr.next();
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
			((UserBusiness) map.get(key)).setEdu(edu);
			break;
		}


		while(true){
			System.out.println("请输入联系地址");
			String address =scr.next();
			if(address.length()<=50) {
				((UserBusiness) map.get(key)).setAddress(address);
				break;
			}
			else {
				System.out.println("地址需要少于50字");
				continue;
			}
		}
		System.out.println("请输入新联系地址");
	}
}
