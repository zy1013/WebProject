package DAO;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Mapper.ChannelMapper;
import Mapper.UserMapper;
import PO.UUMessage;
import PO.UURelation;
import PO.User;
import PO.UserLoginData;
import test.TestForMail;

public class UserDAO {
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
	
	public User getUserByUID(String uid) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			User user = um.selectUserById(uid);
			
//			user.setUid("test01");
//			user.setPassword("testpw");
//			List<User> list = 
//			for(User u : list)
//			{
//				System.out.println(u.getUid()+"|"+u.getPassword());
//			}
//			User u = um.selectUserById("user1");
//			System.out.println(u==null);
//			session.commit();
//			System.out.println("OK");
			return user;
		} finally {
			session.close();
		}
	}
	public int getUserNumberByUID(String uid) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			int i = um.getUserNumber(uid);
//			user.setUid("test01");
//			user.setPassword("testpw");
//			List<User> list = 
//			for(User u : list)
//			{
//				System.out.println(u.getUid()+"|"+u.getPassword());
//			}
//			User u = um.selectUserById("user1");
//			System.out.println(u==null);
//			session.commit();
//			System.out.println("OK");
			return i;
		} finally {
			session.close();
		}
	}
	public void UserLogin(UserLoginData uld) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
//			uld.setUid(uld.getUid());
//			uld.setDate(uld.getDate());
			System.out.println(uld.getDate()+uld.getUid());
			System.out.println(um.loginUser(uld));
			session.commit();
			} finally {
				session.close();
			}
		}
	public String LastLogin(String uid) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		String s = "";
		try {
			UserMapper um = session.getMapper(UserMapper.class);
//			uld.setUid(uld.getUid());
//			uld.setDate(uld.getDate());
//			System.out.println(uld.getDate()+uld.getUid());
//			System.out.println(um.loginUser(uld));
			s=um.getUserLastLogin(uid);
			System.out.println("lastlog"+s);
			session.commit();
			} finally {
				session.close();
				return s;
			}
		}
	public void updateUser(User u ,String uid) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			um.updateUser(u.getName(),u.getPassword(),u.getIntro(),u.getOption(), uid);
			session.commit();
			System.out.println("commit");
			} finally {
				session.close();
			}
		}
	public List<UserLoginData> UserLoginData() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			return um.selectAllUserLoginData();
			} finally {
				session.close();
			}
		}
	public void insertUser(User u ) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			um.insertUser(u);
			session.commit();
			} finally {
				session.close();
			}
		}
	public List<UURelation> getUserRelation(String uid) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			
			return um.getUserRelation(uid);
			
			} finally {
				session.close();
			}
		}
	public List<UUMessage> getUserMessage(String uid) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ChannelMapper um = session.getMapper(ChannelMapper.class);
			
			return um.getMessage(uid);
			
			} finally {
				session.close();
			}
		}
	
	
	public List<UUMessage> getUserChatMessage(UUMessage u) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ChannelMapper um = session.getMapper(ChannelMapper.class);
			
			return um.getChatMessage(u);
			
			} finally {
				session.close();
			}
		}
	public void setUserMessage(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ChannelMapper um = session.getMapper(ChannelMapper.class);
			
			um.updateMessage(num);
			
			} finally {
				session.close();
			}
		}
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
//			um.updateUser(user.getName(), user.getPassword(), user.getIntro(), user.getOption(), user.getUid());
			} finally {
				session.close();
			}
		}
	
	public List<User> getUserBlackList()
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ChannelMapper um = session.getMapper(ChannelMapper.class);
			return um.getSpecialUser();
			
			} finally {
				session.close();
			}
		
	}
	
	public void changeUserOption(String uid,String option)
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			
			} finally {
				session.close();
			}
	}
	public List<User> getPresentUser(String cid)
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ChannelMapper um = session.getMapper(ChannelMapper.class);
			
			
			return um.getSpecialUser();
			
			
			} finally {
				session.close();
			}
	}
	public List<User> getRecommendUser(String uid)
	{
		List<UURelation> list = getUserRelation(uid);
		for(UURelation uu : list)
		{
			User u = getUserByUID(uu.getUid2());
			
		}
		return null;
		
	}
	
	public void insertMessage(UUMessage m )
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			
			int i = um.insertMessage(m);
			System.out.println(i);
			System.out.println(m.getMessage());
			session.commit();
			} finally {
				session.close();
			}
	}
	
	
	public void UpdateUser(User u )
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			
			um.UpdateUser(u);
			
			session.commit();
			} finally {
				session.close();
			}
	}
	public void prototype(UUMessage m )
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
//			um.insertMessage(m);
//			System.out.println(m.getContent());
			session.commit();
			} finally {
				session.close();
			}
	}
	
	public List<User> selectAllUser( )
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
//			
			return um.selectAllUser();
//			um.insertMessage(m);
//			System.out.println(m.getContent());

			} finally {
				session.close();
			}
	}
	public void forgetpw(String uid) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			UserMapper um=session.getMapper(UserMapper.class);
			User u =um.selectUserById(uid);
			String target=u.getEmail();
			String pw = u.getPassword();
			TestForMail.send(target, pw);
			System.out.println("youjian fale");
//			um.insertMessage(m);
//			System.out.println(m.getContent());
			session.commit();
			} finally {
				session.close();
			}
	}
	public UUMessage findMessage(int mid) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			UserMapper um=session.getMapper(UserMapper.class);
			return um.getMessageByID(mid);

//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	
	public UserLoginData selectLatestLogin(String mid) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			UserMapper um=session.getMapper(UserMapper.class);
			return um.selectLatestUserLogin(mid);

//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}

}
