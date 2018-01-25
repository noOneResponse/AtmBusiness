package com.feicuiedu.atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;

public class SysMenu extends AtmServices implements Serializable,AbstractSys{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void action(HashMap<String, Object> map) {
		
		while(true) {
		
			try {
				System.out.println("1.开户，2.销户，3.显示目前账号所有账户及基本信息，4修改账户信息，5退出");
				String str = scr.next();
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File("InformationTxt"+File.separator+"sysmenu.properties")));
				String className = prop.getProperty(str);
				if (className == null) {
					System.out.println("输入错误，请重新输入");
					continue;
				}
				Object obj = Class.forName(className).newInstance();
				AbstractSys abs = (AbstractSys)obj;
				abs.action(map);
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
