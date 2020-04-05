package DAO;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Mapper.MovieMapper;
import PO.Action;
import PO.Movie;
import PO.Tag;
import PO.User;

public class MovieDAO {
	
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
	public List<Movie> getAllMovie() throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			System.out.println("全部电影！");
			System.out.println(um.getAllMovie().size());
			return um.getAllMovie();

//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	
	public List<Movie> getUserMovie(String uid) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			System.out.println("全部电影！");
			System.out.println("全部电影！");
			MovieMapper um=session.getMapper(MovieMapper.class);
			System.out.println(um.getAllMovie().size());
			return um.getUserMovie(uid);

//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	
	
	public void insertTag(String tag) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			um.insertTag(tag);
			session.commit();

//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	public int findTag(String tag) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			return um.findTag(tag);

//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	
	public List<Tag> findRandomTag() throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			return um.selectRandomTag();

//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	
	
	public void userSelectTag(Action a) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			um.userSelectTag(a);
			session.commit();
//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	
	public int isUserSelectTag(Action t) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			return um.findUserTag(t);
//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	
	
	public List<Action> findUserAllTag(User u) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			return um.findUserAllTag(u);
//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	
	
	public void deleteUserTag(Action a) throws Exception
	{
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			um.deletetag(a);
			session.commit();
//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	public Movie getMovie(String mid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			return um.getMovieByMid(mid);
//			um.insertMessage(m);
//			System.out.println(m.getContent());
			} finally {
				session.close();
			}
	}
	public void updateMovie(Movie m) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
//			ChannelMapper um = session.getMapper(ChannelMapper.class);
//			
			MovieMapper um=session.getMapper(MovieMapper.class);
			um.updateMovie();
			session.commit();
			} finally {
				session.close();
			}
	}
}
