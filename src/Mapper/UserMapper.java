package Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import PO.UUMessage;
import PO.UURelation;
import PO.User;
import PO.UserLoginData;

public interface UserMapper {
	//用户操作
	@Insert("INSERT INTO ALLUSER VALUES(#{uid},#{name},#{password},#{intro},#{createDate},#{option},#{email})")
	int saveUser(User user);
	
	
	
	@Select("SELECT * FROM ALLUSER")
	@Results({
		@Result(column="uid" ,property="uid"),
		@Result(column="password" ,property="password"),
		@Result(column="uname", property="name"),
		@Result(column="uintro", property="intro"),
		@Result(column="uoption", property="option"),
		@Result(column="register_date", property="createDate"),
		@Result(column="uemail", property="email")
	})
	List<User> selectAllUser();
	
	@Update("Update alluser set uname=#{name},password=#{password},uoption=#{option},uintro=#{intro},uemail=#{email} where (uid=#{uid})")
	void UpdateUser(User u);

	@Delete("delete from alluser where (uid=#{uid})")
	void deleteUser(User u);
	
	@Select("SELECT * FROM ALLUSER WHERE UID = #{uid}")
	@Results({
		@Result(column="uid" ,property="uid"),
		@Result(column="password" ,property="password"),
		@Result(column="uname", property="name"),
		@Result(column="uintro", property="intro"),
		@Result(column="uoption", property="option"),
		@Result(column="register_date", property="createDate"),
		@Result(column="uemail", property="email")
	})
	User selectUserById(String uid);
	
	
	@Select("Select Login_date from user_login where UID =#{uid}  order by autokey desc limit 1 ")
	String getUserLastLogin(String uid);
	@Insert("INSERT INTO USER_LOGIN(uid,login_date) VALUES(#{uid},#{date})")
	int loginUser(UserLoginData uld);
	@Update("UPDATE ALLUSER SET UNAME=#{name}, PASSWORD=#{password} , UINTRO = #{intro},UOPTION=#{option} where UID=#{uid};")
	int updateUser(@Param("name")String name,@Param("password")String password,@Param("intro")String intro,@Param("option")String option,@Param("uid")String uid);
	@Select("SELECT * FROM user_login")
	@Results({
		@Result(column="uid" ,property="uid"),
		@Result(column="login_date" ,property="date"),
	})
	List<UserLoginData> selectAllUserLoginData();
	
	@Insert("INSERT INTO alluser VALUES(#{uid},#{name},#{password},#{intro},#{createDate},#{option},#{email})")
	int insertUser(User user);
	
	@Select("Select count(*) from ALLUSER where UID =#{uid}")
	int getUserNumber(String uid);
	
	@Select("Select * from user_relation where (UID1 =#{uid})")
	@Results({
		@Result(column="uid1" ,property="uid1"),
		@Result(column="uid2" ,property="uid2"),
		@Result(column="uname" ,property="uname"),
		@Result(column="relation_type" ,property="date"),
		@Result(column="build_date" ,property="type")
	})
	List<UURelation> getUserRelation(String uid);
	
	@Select("Select * from user_message where (UID1 =#{uid})")
	@Results({
		@Result(column="uid" ,property="uid"),
		@Result(column="source" ,property="source"),
		@Result(column="mid" ,property="mid"),
		@Result(column="date" ,property="date"),
		@Result(column="type" ,property="type"),
		@Result(column="message" ,property="message"),
		@Result(column="checked" ,property="checked")
	})
	List<UUMessage> getUserMessage(String uid);//获取所有的消息
	
	@Select("Select * from user_message where (UID1 =#{uid} and checked = 0)")
	@Results({
		@Result(column="uid" ,property="uid"),
		@Result(column="source" ,property="source"),
		@Result(column="mid" ,property="mid"),
		@Result(column="date" ,property="date"),
		@Result(column="type" ,property="type"),
		@Result(column="message" ,property="message"),
		@Result(column="checked" ,property="checked")
	})
	List<UUMessage> getUserUncheckedMessage(String uid);//获取所有未看过的消息
	
	
	@Insert("INSERT INTO user_message (uid,source,checked,message,date,type)VALUES(#{uid},#{source},#{checked},#{message},#{date},#{type})")
	int insertMessage(UUMessage m);
	
	@Select("SELECT * FROM USER_LOGIN WHERE(autokey = (select max(autokey) from user_login where(uid=#uid)) )")
	UserLoginData selectLatestUserLogin(String uid);
	
	@Select("Select * from user_message where (mid =#{mid})")
	@Results({
		@Result(column="uid" ,property="uid"),
		@Result(column="source" ,property="source"),
		@Result(column="mid" ,property="mid"),
		@Result(column="date" ,property="date"),
		@Result(column="type" ,property="type"),
		@Result(column="message" ,property="message"),
		@Result(column="checked" ,property="checked")
	})
	UUMessage getMessageByID(int mid);//获取所有未看过的消息
}
