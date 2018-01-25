package com.feicuiedu.atm;

import java.util.HashMap;

public class UserInfoRecord implements AbstractUser{
	public void action(UserBusiness user,HashMap<String, Object> map) {	
		System.out.println(user.getList());
	}
}
