package com.feicuiedu.atm;

import java.util.HashMap;

public class SysExit extends AtmServices implements AbstractSys {
	public void action(HashMap<String, Object> map) {
		LogInBusiness lb = new LogInBusiness();
		InputObjStream(map);
		//输出集合到文件中
		lb.action(map);
	}
}
