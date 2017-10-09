package com.inteliment.counterapi.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
	static JSONObject outputObj = new JSONObject();
	static JSONArray arr = new JSONArray();
	static {
		
		
		outputObj.put("Employee", arr);
		
		JSONObject obj1 = new JSONObject();
		obj1.put("id", 1001);
		obj1.put("name", "vikas");
		obj1.put("dept", "dev");
		obj1.put("salary", 50000);
		
		JSONObject obj2 = new JSONObject();
		obj2.put("id", 1002);
		obj2.put("name", "dham");
		obj2.put("dept", "remedy");
		obj2.put("salary", 80000);
		
		JSONObject obj3 = new JSONObject();
		obj3.put("id", 1003);
		obj3.put("name", "kushan");
		obj3.put("dept", "sales");
		obj3.put("salary", 30000);
		
		arr.put(obj1);
		arr.put(obj2);
		arr.put(obj3);
		
	}
	
	public String getAll() {
		System.out.println("Get Employee Json:"+outputObj.toString());
		return outputObj.toString();
	}
	
	public String add(JSONObject object) {
		arr.put(object);
		return outputObj.toString();
	}
	
	public String remove(int id) {
		if (id>0) {
			for (int i=0; i<arr.length();i++) {
				JSONObject obj = arr.getJSONObject(i);
				if (obj.get("id")!=null && obj.getInt("id") == id) {
					arr.remove(i);
					System.out.println("Removed from server...");
					break;
				}
			}
		}
		return outputObj.toString();
	}
}
