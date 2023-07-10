package assignment;

public class bookmarkListVar {
	
		private String id;
		private String bookmarkName;
		private String wifiName;
		private String date;
		private String num;
		
		public void setWifiName(String value) {
			wifiName=value;
		}
		public void setBookmarkName(String value) {
			bookmarkName=value;
		}
	
		public void setId(String value) {
			id=value;
		}
		public void setDate(String value) {
			date=value;
		}
		public void setNum(String value) {
			num=value;
		}
		
		
		
		
		public String getWifiName() {
			return wifiName;
		}
	
		public String getBookmarkName() {
			return bookmarkName;
		}
	
		public String getId() {
			return id;
		}
		public String getNowDate() {
			return date;
		}
		public String getNum() {
			return num;
		}
		
	
}
