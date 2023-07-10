package assignment;
import java.util.List;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class history {
	private String id;
	private String lat;
	private String lnt;
	private String date;

	
	public void setHid(String value) {
		id=value;
	}
	public void setLat(String value) {
		lat=value;
	}

	public void setLnt(String value) {
		lnt=value;
	}
	public void setDate(String value) {
		date=value;
	}
	
	
	
	
	public String getHid() {
		return id;
	}

	public String getLat() {
		return lat;
	}

	public String getLnt() {
		return lnt;
	}
	public String getNowDate() {
		return date;
	}

	
}
