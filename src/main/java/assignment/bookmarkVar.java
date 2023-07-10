package assignment;

public class bookmarkVar {
	private String id;
	private String orderNum;
	private String bookmarkName;
	private String date;
	private String updateDate;
	
	public void setOrderNum(String value) {
		orderNum=value;
	}
	public void setBookmarkName(String value) {
		bookmarkName=value;
	}
	public void setDate(String value) {
		date=value;
	}
	public void setId(String value) {
		id=value;
	}
	public void setUpdateDate(String value) {
		if(value==null) updateDate= "";
		else updateDate=value;
	}
	
	
	
	public String getOrderNum() {
		return orderNum;
	}
	public String getBookmarkName() {
		return bookmarkName;
	}
	public String getDate() {
		return date;
	}
	public String getUpdateDate() {
		return updateDate == null? "" :updateDate;
	}
	public String getId() {
		return id;
	}
}
