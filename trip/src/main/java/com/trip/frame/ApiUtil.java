package com.trip.frame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ApiUtil {
	public static String getData() throws IOException{
		StringBuffer result=new StringBuffer();
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/6300000/openapi2022/restrnt/getrestrnt"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=MCJY0p58kVo3OZb0QUQANmNwsbjErH4jPJEsiaUQqtl5S%2FGWT7DQ1DzX%2F3DspB4ZwyoVJ2phmj2avjLJ0%2Fg5iQ%3D%3D"); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
		URL url=new URL(urlBuilder.toString());
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestMethod("GET");
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		/*
		 * JSONParser parser=new JSONParser(); try { Object
		 * obj=parser.parse(sb.toString()); JSONObject jo=(JSONObject)obj; JSONObject
		 * jo1=(JSONObject)jo.get("response"); JSONObject
		 * jo2=(JSONObject)jo1.get("body"); JSONArray ja=(JSONArray)jo2.get("items");
		 * JSONObject jo3=(JSONObject)ja.get(0); String
		 * str=(String)jo3.get("restrntNm"); return str; } catch (ParseException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); return ""; }
		 */
		return sb.toString();
		
		
	}
	
}


