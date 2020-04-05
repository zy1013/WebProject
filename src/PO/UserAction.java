package PO;

public class UserAction {
	String uid;
	String mid;
	int type;
	public void setType(int type) {
		this.type = type;
	}
	String date;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getType() {
		return type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
