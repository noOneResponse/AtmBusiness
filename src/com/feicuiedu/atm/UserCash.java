package com.feicuiedu.atm;

import java.util.HashMap;

public class UserCash extends AtmServices implements AbstractUser{
	
	public void action(UserBusiness user,HashMap<String, Object> map) {	
		
		while(true) {
			System.out.println("请输入取款金额");
			double amount = Integer.valueOf(scr.next());
			if(amount<user.getAmount() && amount>0) {
				user.setAmount(user.getAmount()-amount);
				break;
			}
			else {
				System.out.println("请输入正确金额");
				continue;
			}
	
		}	
	}
}
