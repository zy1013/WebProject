package Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import PO.Channel;
import PO.UUMessage;
import PO.User;

public interface ChannelMapper {

	@Select("SELECT * FROM Channel")
	@Results({
		@Result(column="uid" ,property="uid"),
		@Result(column="source" ,property="source"),
		@Result(column="date" ,property="date"),
		@Result(column="message" ,property="message"),
		@Result(column="checked" ,property="checked"),
		@Result(column="num" ,property="num")
	})
	List<Channel> selectAllChannel();
	@Select("SELECT * FROM USER_MESSAGE where (UID =#{uid} and checked=0)")
	List<UUMessage> getMessage(String uid);
	
	@Select("SELECT * FROM USER_MESSAGE where (UID =#{uid} and checked=0)")
	List<UUMessage> getChatMessage(UUMessage m);
	
	@Insert("INSERT INTO User_message VALUES(#{uid},#{source},#{checked},#{content},#{date})")

	int insertUser(UUMessage u);
	
	@Select("update USER_MESSAGE set checked = 1 where (num =#{num} and checked=0)")
	int updateMessage(int num);
	
	@Insert("INSERT INTO CHANNEL VALUES(#{cid},#{cname},#{cintro},#{create_date},#{option})")
	void insertChannel(String cid,String canme,String cintro,String date,String option);
	
	@Insert("INSERT INTO USER_MESSAGE(uid,source,checked,message,date) VALUES(#{uid},#{source},#{checked},#{content},#{date})")
	void insertMessage(UUMessage m);
	
	void insertSpecialUser(String uid,String cid);
	
	void deleteSpecialUser(String uid,String cid);
	
	void changeChannelOption(String cid,String option);
	
	List<User> getPresentUser(String cid);
	
	List<User> getSpecialUser();
	
	List<User> getBlackList();
	
	@Select("Select count(*) from Channel")
	int getChannelNumber();
}
