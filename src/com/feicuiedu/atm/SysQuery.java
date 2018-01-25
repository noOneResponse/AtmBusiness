package com.feicuiedu.atm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SysQuery extends AtmServices implements AbstractSys{
	public void action(HashMap<String, Object> map) {
		Set<Entry<String, Object>> sets = map.entrySet();
		Iterator<Entry<String, Object>> its = sets.iterator();
		while(its.hasNext()) {
		Entry<String, Object> entry = its.next();
		Object user = entry.getValue();
		System.out.println(user);
		}
	}
}
