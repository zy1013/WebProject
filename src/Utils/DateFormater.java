package Utils;

import java.util.*;
import java.text.*;
public class DateFormater {
	DateFormat chinesedf;
	
	public DateFormater() {
		super();
		this.chinesedf = new SimpleDateFormat("yyyy年MM月dd日  hh时mm分ss秒");
	}

	public String date2CString(Date date)
	{
		date = new Date();
//		DateFormat df = new DateFormat(date);
//		String s = "2016年5月12日  22时47分15秒";
//		DateFormat dateFormat2 = new SimpleDateFormat("yyyy年MM月dd日  hh时mm分ss秒");
		String s1 = chinesedf.format(date);
		return s1;
//		Date date2 = dateFormat2.parse(s1);
	}
	public String date2String(Date date)
	{
		date = new Date();
//		DateFormat df = new DateFormat(date);
//		String s = "2016年5月12日  22时47分15秒";
//		DateFormat dateFormat2 = new SimpleDateFormat("yyyy年MM月dd日  hh时mm分ss秒");
		String s1 = date.toString();
		return s1;
//		Date date2 = dateFormat2.parse(s1);
	}
	public Date string2Date(String s1) throws ParseException
	{
		Date date = chinesedf.parse(s1);
		return date;
	}
	
}
