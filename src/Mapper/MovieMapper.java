package Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import PO.Action;
import PO.Movie;
import PO.Tag;
import PO.User;

public interface MovieMapper {
	
	Movie getMovieByMid(String mid);
	
	
	List<Movie> getRecommentMovie(String uid);
	
	@Select("SELECT mid,director_name, duration,  actor2_name,  gross, grnres, actor1_name, actor3_name,title, total_likes,keywords, link,  language,  content_rating, budget, year,  score, ratio FROM movie limit 100")
	@Results({
		@Result(column="mid" ,property="mid"),
		@Result(column="title" ,property="title"),
		@Result(column="director_name" ,property="director"),
		@Result(column="actor1_name" ,property="actor1name"),
		@Result(column="actor2_name" ,property="actor2name"),
		@Result(column="actor3_name" ,property="actor3name"),
		@Result(column="grnres" ,property="genre"),
		@Result(column="keywords" ,property="tag"),
		@Result(column="gross" ,property="gross"),
		@Result(column="link" ,property="link"),
		@Result(column="duration" ,property="duration"),
		@Result(column="language" ,property="language"),
		@Result(column="score" ,property="score"),
		@Result(column="budget" ,property="budget"),
		@Result(column="content_rating" ,property="rank"),
		@Result(column="year" ,property="year"),
		@Result(column="ratio" ,property="ratio"),
		@Result(column="total_likes" ,property="number_likes"),
	})
	List<Movie> getAllMovie();
	
	@Select("SELECT * FROM movie where (uid = (select distinct mid from user_action where (uid = #{uid}) ))")
	List<Movie> getUserMovie(String uid);
	
	
	@Insert("INSERT INTO tag (tagname)values (#{name})")
	int insertTag(String name);
	
	@Select("select count(tagname) from tag where (tagname = #{name})")
	int findTag(String name);
	
	@Select("select * from tag")
	List<Tag> selectAllTag();
	
	@Select("select * from tag ORDER BY RAND() LIMIT 12")
	@Results({
		@Result(column="idtag" ,property="num"),
		@Result(column="tagname" ,property="name"),
	})
	List<Tag> selectRandomTag();
	
	@Insert("INSERT INTO user_action values (#{uid},#{mid},2,now())")
	int userSelectTag(Action a);
	
	@Select("select count(uid) from user_action where (uid = #{uid} and mid=#{mid})")
	int findUserTag(Action a );
	
	
	@Select("select * from user_action where (uid = #{uid} and type =2)")
	@Results({
		@Result(column="uid" ,property="uid"),
		@Result(column="mid" ,property="mid"),
		@Result(column="type" ,property="type"),
		@Result(column="date" ,property="date"),
	})
	List<Action> findUserAllTag(User u);
	
	
	@Delete("DELETE FROM user_action WHERE (uid=#{uid} and mid=#{mid})")
	void deletetag(Action a);


	void updateMovie();
}
