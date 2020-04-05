package test;

import java.util.ArrayList;
import java.util.List;

public class TestGrammar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 ="abc";
		String s2 = "abc";
		List<String> list = new ArrayList<String>();
		list.add(s1);
		System.out.println(list.contains(s2));
	}

}
