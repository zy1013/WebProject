package PO;

public class Action {
	String uid;
	String mid;
	int type;
	String date;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMid() {
		String temp =mid.trim();
		return temp;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
