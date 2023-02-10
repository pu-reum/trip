package com.trip.frame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class ApiUtil3 {
	public static String getData(String pageNo) throws IOException{
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B551011/KorService/searchFestival"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=MCJY0p58kVo3OZb0QUQANmNwsbjErH4jPJEsiaUQqtl5S%2FGWT7DQ1DzX%2F3DspB4ZwyoVJ2phmj2avjLJ0%2Fg5iQ%3D%3D"); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=" + URLEncoder.encode("A", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("eventStartDate", "UTF-8") + "=" + URLEncoder.encode("20230301", "UTF-8"));
		
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
		
		System.out.println(sb.toString());
		return sb.toString();
		
		
	}
	
}


