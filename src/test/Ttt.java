package test;

import java.util.Date;

import DAO.UserDAO;
import PO.UUMessage;
import PO.User;

public class Ttt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UserDAO udao = new UserDAO();
		UUMessage u =new UUMessage();
		u.setUid("abc");
		u.setSource("def");
		System.out.println(udao.selectAllUser().get(2).getCreateDate());
		
//		User user = udao.getUserByUID("abc");
//		System.out.println(user.getOption());
		
		
	}

}
