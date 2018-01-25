package com.feicuiedu.atm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class UserCash extends AtmServices implements AbstractUser{
	
	public void action(UserBusiness user,HashMap<String, Object> map) {	
		
		while(true) {
			System.out.println("请输入取款金额");
			double amount = Integer.valueOf(scr.next());
			if(amount<user.getAmount() && amount>0) {
				user.setAmount(user.getAmount()-amount);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
				String time = sdf.format(new Date());
				user.getList().add(time+" "+"取款:"+amount+"元");
				break;
			}
			else {
				System.out.println("请输入正确金额");
				continue;
			}
	
		}	
	}
}
