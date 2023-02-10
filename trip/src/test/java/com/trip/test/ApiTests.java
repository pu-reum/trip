package com.trip.test;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trip.frame.ApiUtil;



@SpringBootTest
class ApiTests {

	@Test
	@ResponseBody
	void contextLoads() {
		JSONParser parser=new JSONParser();
		Object obj=null;	
		try {
			obj = parser.parse(ApiUtil.getData());
			JSONObject jo=(JSONObject)obj;
			JSONObject jo1=(JSONObject)jo.get("response");
			JSONObject jo2=(JSONObject)jo1.get("body");
			JSONArray ja=(JSONArray)jo2.get("items");
			JSONObject jo3=(JSONObject)ja.get(0);
			String str=(String)jo3.get("restrntNm");
			System.out.println(obj);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
