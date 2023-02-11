package com.trip.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trip.dto.Placedet;
import com.trip.frame.ApiUtil3;
import com.trip.service.PlacedetService;


// 축제 api
@SpringBootTest
class ApiTests3 {
	
	@Autowired
	PlacedetService service;
	
	@Test
	@ResponseBody
	void contextLoads() {
		JSONParser parser=new JSONParser();
		Object obj=null;	
		
		try {
			for(int i=1;i<63;i++) {  // 1~62
				String pageNo=Integer.toString(i);
				obj = parser.parse(ApiUtil3.getData(pageNo));
				JSONObject jo=(JSONObject)obj;
				JSONObject jo1=(JSONObject)jo.get("response");
				JSONObject jo2=(JSONObject)jo1.get("body");
				JSONObject jo3=(JSONObject)jo2.get("items");
				JSONArray ja=(JSONArray)jo3.get("item");
				JSONObject jo4=(JSONObject)ja.get(0);
				String pdname=(String)jo4.get("title");
				String pddesc="tel : "+(String)jo4.get("tel");
				String pdaddr=(String)jo4.get("addr1");
				String imgname1=(String)jo4.get("firstimage");
				String lat=(String)jo4.get("mapy");
				String lng=(String)jo4.get("mapx");
				String pddate=(String)jo4.get("eventstartdate")+"~"+(String)jo4.get("eventenddate");
				Placedet pd=new Placedet(0, 2, pdname, pddesc, pdaddr, imgname1, pddate, lat, lng, 0, 0);
				service.insertPlace(pd);
				
			}
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
