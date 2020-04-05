package DAO;

import java.util.*;
import java.text.*;
import PO.User;
import PO.UserLoginData;

public class TestDAO {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		UserDAO userdao = new UserDAO();
		User u = new User();
		u.setName("wow");
		u.setUid("eee");
		userdao.insertUser(u);
		
	}

}
