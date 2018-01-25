package com.feicuiedu.atm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AtmServices {
	
	public static Scanner scr = new Scanner(System.in);
	
	public static boolean checkUser(String user) {
		return user.matches("^[0-9]{18,22}$");
	}
	
	public static boolean checkPassword(String idnum) {
		return idnum.matches("^[0-9]{4}$")&&!idnum.matches("[A-Z]+");
	}
	
	public static boolean checkName(String name) {
		return name.matches("^[0-9a-zA-Z]{1,10}$");
	}
	
	public static boolean checkIdNum(String idnum) {
		return idnum.matches("^[0-9]{18}$");
	}
	
	public static HashMap<String,Object> LoginFile(HashMap<String,Object> map) {
		try {
			File file = new File("InformationTxt"+File.separator+"User.txt");
			FileInputStream fos = new FileInputStream(file);	
			if(file!=null&&file.length()!=0) {                           
				//如果文件内存在集合,则把文件内的集合提出
				ObjectInputStream ois = new ObjectInputStream(fos);
				map = (HashMap<String, Object>) ois.readObject();
				fos.close();
			}
			else {
				//如果文件内为空，则新建一个集合放入文件中
				FileOutputStream ops = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(ops);
				oos.writeObject(map);
				oos.close();
			}		 
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void InputObjStream(HashMap<String,Object> map) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("InformationTxt"+File.separator+"User.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			oos.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String existUser(HashMap<String, Object> map) {
		
		while(true) {
			boolean bln = false ;
			System.out.println("请输入账号");
			String user = scr.next();
			Set<String> set = map.keySet();
			for(String str : set) {
				if(str.startsWith(user)) {
					bln = true;
					user = str;
					break;
				}
			}
			if(bln==true) {
				return user;
			}
			System.out.println("账号不存在，请重新输入");
		}
		
		
	}
	
}
