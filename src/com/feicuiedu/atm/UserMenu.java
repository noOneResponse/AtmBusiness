package com.feicuiedu.atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class UserMenu extends AtmServices implements AbstractUser{
	
	public void action(UserBusiness user,HashMap<String, Object> map) {
		
		while(true) {
			try {
				System.out.println("1.查询，2.转账，3.取款，4.存款，5.退出");
				String str = scr.next();
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File("InformationTxt"+File.separator+"UserMenu.properties")));
				String className = prop.getProperty(str);
				if (className == null) {
					System.out.println("输入错误，请重新输入");
					continue;
				}
				Object obj = Class.forName(className).newInstance();
				AbstractUser abs = (AbstractUser)obj;
				abs.action(user,map);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}	
}
