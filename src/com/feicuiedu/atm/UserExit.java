package com.feicuiedu.atm;

import java.util.HashMap;

public class UserExit extends AtmServices implements AbstractUser{
	public void action(UserBusiness user , HashMap<String, Object> map) {
		LogInBusiness lb = new LogInBusiness();
		InputObjStream(map);
		//输出集合到文件中
		lb.action(map);
	}
}
