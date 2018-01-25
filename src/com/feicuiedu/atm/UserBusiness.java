package com.feicuiedu.atm;

import java.io.Serializable;
import java.util.ArrayList;

public class UserBusiness implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String password;
	private String name;
	private String gender;
	private String idnum;
	private String edu; 
	private double amount;
	private String address;
	private ArrayList<String> list;
	
	public UserBusiness(String user,String password,String name,String idnum,
			String gender,String edu,double amount, String address) {
		this.idnum = idnum;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.edu = edu;
		this.amount = amount;
		this.user = user;
		this.address = address;
		list = new ArrayList<>();
	}
	public UserBusiness() {
		
	}
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public String getIdnum() {
		return idnum;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "用户名:" + user +" " + "名字:" + name +" "  + "性别:" + gender +" "
				+"身份证号:" + idnum +" "  + "学历:" + edu +" "  + "地址:" + address;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(!(obj instanceof UserBusiness)) {
			return false;
		}
		if(((UserBusiness)obj).user.equals(user)) {
			return true;
		}
		if(((UserBusiness)obj).idnum.equals(idnum)) {
			return true;
		}
		return false;
	}
	
	
	
	
}
