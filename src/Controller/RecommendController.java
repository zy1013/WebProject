package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import DAO.MovieDAO;
import DAO.UserDAO;
import PO.Action;
import PO.Movie;
import PO.RecommendMovie;
import PO.User;
import Utils.Recommend;
import Utils.UserOption;
import net.sf.json.JSONArray;

@Controller
public class RecommendController {
	@RequestMapping(value="/getrecommendmovie")
	public @ResponseBody String getMovie(@CookieValue(name="uid",defaultValue="abc") String uid) throws Exception
	{
		MovieDAO dao = new MovieDAO();
		UserDAO udao = new UserDAO();
		
		List<Movie> list = dao.getAllMovie();
		User u = udao.getUserByUID(uid);
		List<Action> list1 = dao.findUserAllTag(u);
		List<Movie> result =  new ArrayList<Movie>();
		List<RecommendMovie> result1 =  new ArrayList<RecommendMovie>();
		String temp="";
		for(Action a:list1)
		{
			temp=temp+a.getMid()+"|";
		}
		System.out.println(temp);
		for(Movie m:list)
		{
			System.out.println(Recommend.getRelation(m.getTag(), temp));
			if(Recommend.getRelation(m.getTag(), temp)>50){
				RecommendMovie r = new RecommendMovie();
				r.setMid(m.getMid());
				r.setTitle(m.getTitle());
				r.setReason(Recommend.getSameTag(m.getTag(),temp ));
				result1.add(r);
				result.add(m);
			}
		}
		
		
		JSONArray array= JSONArray.fromObject(result1);
		return array.toString();
	}
	
	
	@RequestMapping(value="/getrecommenduser")
	public @ResponseBody String getUser(@CookieValue(name="uid",defaultValue="abc") String uid) throws Exception
	{
		
		UserDAO udao = new UserDAO();
		User user = udao.getUserByUID(uid);
		MovieDAO mdao = new MovieDAO();
		List<User> list= udao.selectAllUser();
		List<String> temp =new ArrayList<String>();
		List<User> result= new ArrayList<User>();
		List<Action> lista,listb ;
		for(User u:list)
		{
			lista=mdao.findUserAllTag(u);
			listb = mdao.findUserAllTag(user);
			for(Action a: lista)
			{
				if(!a.getUid().equals(uid))
				for(Action b:listb)
				{
					
					if(b.getMid().equals(a.getMid()))
					{
						System.out.println("b:"+b.getMid()+"a:"+a.getMid());
						if(!temp.contains(a.getUid()))
						temp.add(a.getUid());
					}
						
				}
			}
			
		}
		for(String s :temp)
		{
			User u =udao.getUserByUID(s);
			if(UserOption.allowRecommend(u.getOption()))
			result.add(u);
		}
		JSONArray array= JSONArray.fromObject(result);
		return array.toString();
	}
	

	
}
