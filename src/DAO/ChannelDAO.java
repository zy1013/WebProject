package DAO;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Mapper.ChannelMapper;
import Mapper.UserMapper;
import PO.Channel;
import PO.UUMessage;
import PO.User;
import PO.UserLoginData;

public class ChannelDAO {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	public void insertChannel(Channel c)
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ChannelMapper um = session.getMapper(ChannelMapper.class);
			
			um.insertChannel(c.getCid(),c.getName(),c.getIntro(),c.getCreateDate(),c.getOption());
			
			
			} finally {
				session.close();
			}
	}
	
	public void insertMessage(UUMessage m) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper um = session.getMapper(UserMapper.class);
			um.insertMessage(m);
			session.commit();
			} finally {
				session.close();
			}
		}
}
