package test;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import PO.User;
public class TestForMybatis {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/myBatisConfigure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			System.out.println("test");
			List<User> list;
			list =session.selectList("test.findUserByName","abc");
			if(list.isEmpty()==false){
//				String userInfo = "名字："+user.getUid()+"密码"+user.getPassword();
//				System.out.println(userInfo);
				for(User u: list)
				{
					System.out.println(u.getUid()+"|"+u.getPassword());
				}
			}
			else
			{
				System.out.println("没");
			}
		} finally {
			session.close();
		}
	}
}
