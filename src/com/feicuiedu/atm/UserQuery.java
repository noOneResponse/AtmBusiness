package com.feicuiedu.atm;

import java.util.HashMap;

public class UserQuery extends AtmServices implements AbstractUser{
	public void action(UserBusiness user,HashMap<String, Object> map) {
		System.out.println("姓名:"+user.getName());
		System.out.println("余额:"+user.getAmount());
	}
}
