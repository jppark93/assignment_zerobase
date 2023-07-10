package assignment;
import java.util.List;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.*;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import org.json.simple.parser.JSONParser;
import assignment.pbwifi;
import assignment.insertData;
public class data {
	 public static void main(String[] args) throws IOException {
	        // 실행할 코드 작성
		 	datas();
	    }
	public static void datas()  throws IOException {
		try {
			int idx = 1;
			int total =23304;
			for(int i=0; i<total/1000+1; i++) {
				String filePath = "C:/Users/yello/Desktop/data.json";
				StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
				urlBuilder.append("/" +  URLEncoder.encode("514a76655674616a38315265535164","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
				urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
				urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
				urlBuilder.append("/" + URLEncoder.encode(String.valueOf(idx),"UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
				urlBuilder.append("/" + URLEncoder.encode(String.valueOf(idx+999),"UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
				
				
		
				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/xml");
				System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
				BufferedReader rd;
		
				// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
				if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
				//System.out.println(sb.toString());
				/*
				 * FileWriter fileWriter = new FileWriter(filePath);
				 * fileWriter.write(sb.toString()); fileWriter.close();
				 */
				JSONObject result = (JSONObject) new JSONParser().parse(sb.toString());
				JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
				JSONArray array = (JSONArray) data.get("row");
				JSONObject tmp; 
				
				for (int j=0; j<array.size(); j++) {
					pbwifi pw = new pbwifi();
			        tmp = (JSONObject) array.get(j);
			        
			        pw.setMgrNo(String.valueOf(tmp.get("X_SWIFI_MGR_NO")));
			        
			        pw.setWrdofc(String.valueOf(tmp.get("X_SWIFI_WRDOFC")));
			        
			        pw.setMainNM(String.valueOf(tmp.get("X_SWIFI_MAIN_NM")));
			        
			        pw.setAddress1(String.valueOf(tmp.get("X_SWIFI_ADRES1")));
			 
			        pw.setAddress2(String.valueOf(tmp.get("X_SWIFI_ADRES2")));
			        pw.setFloor(String.valueOf(tmp.get("X_SWIFI_INSTL_FLOOR")));
			        pw.setTy(String.valueOf(tmp.get("X_SWIFI_INSTL_TY")));
			        pw.setMby(String.valueOf(tmp.get("X_SWIFI_INSTL_MBY")));
			        pw.setSVC(String.valueOf(tmp.get("X_SWIFI_SVC_SE")));
			        pw.setCMCWR(String.valueOf(tmp.get("X_SWIFI_CMCWR")));
			        pw.setYear(String.valueOf(tmp.get("X_SWIFI_CNSTC_YEAR")));
			        pw.setInOut(String.valueOf(tmp.get("X_SWIFI_INOUT_DOOR")));
			        pw.setRemars(String.valueOf(tmp.get("X_SWIFI_REMARS3")));
			        pw.setLat(String.valueOf(tmp.get("LAT")));
			        pw.setLnt(String.valueOf(tmp.get("LNT")));
			        pw.setDttm(String.valueOf(tmp.get("WORK_DTTM")));
			        insertData.insert(pw);
				}
				
				
				idx += 1000;
				
			 }
		
			}
			catch(Exception e) {
				System.out.print(e);
			}
	}

}
