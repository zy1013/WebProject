package Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import DAO.MovieDAO;
import DAO.UserDAO;
import PO.Action;
import PO.Movie;
import PO.Tag;
import PO.UUMessage;
import PO.User;
import Utils.DateFormater;
import Utils.UserOption;
import net.sf.json.JSONArray;

@Controller
public class UserController {
	@RequestMapping(value="/notificationlist")
	public ModelAndView login(
			@CookieValue(name="uid",defaultValue="") String cookieuid,
			@CookieValue(name="login",defaultValue="") String login,
			@CookieValue(name="lastlogin",defaultValue="") String lastlogin,
			HttpServletResponse response) throws ParseException
	{
		
		UserDAO dao = new UserDAO();
		
		List<UUMessage> list = dao.getUserMessage(cookieuid);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject(list);
		System.out.println("cookie:"+cookieuid+"|"+login);
		
		return mv;
	}
	
	
	@RequestMapping(value="/setting")
	public ModelAndView updateusersetting(
			@CookieValue(name="uid",defaultValue="") String uid
			) throws ParseException
	{
		
		UserDAO dao = new UserDAO();
		User u = dao.getUserByUID(uid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("intro", u.getIntro());
		mv.addObject("name", u.getName());
		mv.addObject("email", u.getEmail());
		mv.addObject("uid", u.getUid());
		mv.addObject("password", u.getPassword());
		mv.setViewName("/WEB-INF/pages/usersetting.jsp");

		return mv;
	}
	
	@RequestMapping(value="/notification")
	public ModelAndView notification(
			@CookieValue(name="uid",defaultValue="") String cookieuid,

			HttpServletResponse response) throws ParseException
	{
		
		UserDAO dao = new UserDAO();
		
		List<UUMessage> list = dao.getUserMessage(cookieuid);
		
		List<UUMessage> list1 =new ArrayList<UUMessage>();
		for(UUMessage m:list)
		{
			if(m.getType()==1&&m.getChecked()==0)
				list1.add(m);
		}
		System.out.println(list1.size()+"|"+list.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list1);
		mv.addObject("messagenumber", list1.size());
		mv.setViewName("/WEB-INF/pages/notification.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/updateuser")
	public ModelAndView updateuser1(@CookieValue(name="uid",defaultValue="") String uid,
			@RequestParam("password") String password,
			@RequestParam("uname") String uname,
			@RequestParam("intro") String intro,
			@RequestParam("email") String email,
			@RequestParam("allowrecommend") String option1,
			@RequestParam("allowwatch") String option2,
			@RequestParam("allowadd") String option3)
	{
		ModelAndView mv = new ModelAndView();
		UserDAO dao = new UserDAO();
//		
		System.out.println("updateuser!");
		User u= new User();
		u.setUid(uid);
		u.setName(uname);
		u.setEmail(email);
		u.setPassword(password);
		u.setIntro(intro);
		String option="";
		if(option1.equals("true"))
		{
			option+=1;
		}
		else
		{
			option+=0;
		}
		if(option2.equals("true"))
		{
			option+=1;
		}
		else
		{
			option+=0;
		}
		if(option3.equals("true"))
		{
			option+=1;
		}
		else
		{
			option+=0;
		}
		u.setOption(option);
		dao.updateUser(u);
		mv.setViewName("/WEB-INF/pages/home.jsp");

		System.out.println("/WEB-INF/pages/home.jsp");
		return mv;
	}
	
	@RequestMapping(value="/forgetpassword")
	public ModelAndView forgetpw1()
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("fogetps!");
		mv.setViewName("/WEB-INF/pages/forgetpassword.jsp");
		return mv;
	}
	
	@RequestMapping(value="/sendpw")
	public ModelAndView forgetpw(@RequestParam("uid") String uid
			) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		UserDAO dao = new UserDAO();
		int i = dao.getUserNumberByUID(uid);
		if(i!=0)
		{
			dao.forgetpw(uid);
			mv.addObject("message", "邮件发送成功");
		}
		else
		{
			mv.addObject("message", "不存在此用户");
		}
		mv.setViewName("/WEB-INF/pages/result.jsp");
		return mv;
	}
	
	@RequestMapping(value="/updatemovie")
	public void updatemovie1(
			@RequestParam("mid") String mid,
			@RequestParam("title") String title,
			@RequestParam("year") String year,
			@RequestParam("director") String director,
			@RequestParam("tag") String tag,
			@RequestParam("genre") String genre,
			@RequestParam("language") String language,
			@RequestParam("actor1name") String actor1name,
			@RequestParam("actor2name") String actor2name,
			@RequestParam("actor3name") String actor3name)
	{
		ModelAndView mv = new ModelAndView();
		MovieDAO dao = new MovieDAO();
		Movie m = dao.getMovie(mid);
		m.setTitle(title);
		m.setDirector(director);
		m.setActor1name(actor1name);
		m.setActor2name(actor2name);
		m.setActor3name(actor3name);
		m.setGenre(genre);
		m.setTag(tag);
		m.setLanguage(language);
		dao.updateMovie(m);
	}
	
	
	@RequestMapping(value="/usersetting")
	public ModelAndView usersettingpage(@CookieValue(name="uid",defaultValue="") String uid
			) throws Exception
	{
		ModelAndView mv = new ModelAndView();
		UserDAO dao = new UserDAO();
		int i = dao.getUserNumberByUID(uid);
		
		mv.setViewName("/WEB-INF/pages/usersetting.jsp");
		return mv;
	}
	
//	@RequestMapping(value="/setting")
//	public ModelAndView updateuserpage(@CookieValue(name="uid",defaultValue="") String uid
//			) throws Exception
//	{
//		ModelAndView mv = new ModelAndView();
//		UserDAO dao = new UserDAO();
//		int i = dao.getUserNumberByUID(uid);
//		
//		mv.setViewName("/WEB-INF/pages/usersetting.jsp");
//		return mv;
//	}
	
	@RequestMapping(value="/message/{target}")
	public ModelAndView messagepage(@CookieValue(name="uid",defaultValue="") String uid,@PathVariable String target) throws NumberFormatException, Exception
	{
		ModelAndView mv = new ModelAndView();
		UserDAO dao= new UserDAO();
		UUMessage u  = dao.findMessage(Integer.parseInt(target));
		mv.addObject("mid", u.getMid());
		mv.addObject("message", u.getMessage());
		mv.addObject("date", u.getDate());
		mv.addObject("source", u.getSource());
		mv.addObject("type",u.getType());
		mv.setViewName("/WEB-INF/pages/message.jsp");
		return mv;
	}
	
	@RequestMapping(value="/movieadmin/{target}")
	public ModelAndView movieadminpage(@CookieValue(name="uid",defaultValue="") String uid,@PathVariable String target) throws NumberFormatException, Exception
	{
		System.out.println("moviepage"+target);
		ModelAndView mv = new ModelAndView();
		MovieDAO dao = new MovieDAO();
		List<Movie> list = dao.getAllMovie();
		Movie m=new Movie();
		for(Movie m1 :list)
		{
			if(m1.getMid()==Integer.parseInt(target))
				m=m1;
		}
		mv.addObject("mid", m.getMid());
		mv.addObject("title", m.getTitle());
		mv.addObject("director", m.getDirector());
		mv.addObject("year", m.getYear());
		mv.addObject("language", m.getLanguage());
		mv.addObject("actor1name", m.getActor1name());
		mv.addObject("actor2name", m.getActor2name());
		mv.addObject("actor3name", m.getActor3name());
		mv.addObject("tag", m.getTag());
		mv.addObject("genre", m.getGenre());

		

		mv.setViewName("/WEB-INF/pages/moviesetting.jsp");
		return mv;
	}
	
	@RequestMapping(value="/movie/{target}")
	public ModelAndView moviepage(@CookieValue(name="uid",defaultValue="") String uid,@PathVariable String target) throws NumberFormatException, Exception
	{
		System.out.println("moviepage"+target);
		ModelAndView mv = new ModelAndView();
		MovieDAO dao = new MovieDAO();
		List<Movie> list = dao.getAllMovie();
		Movie m=new Movie();
		for(Movie m1 :list)
		{
			if(m1.getMid()==Integer.parseInt(target))
				m=m1;
		}
		mv.addObject("mid", m.getMid());
		mv.addObject("title", m.getTitle());
		mv.addObject("director", m.getDirector());
		mv.addObject("year", m.getYear());
		mv.addObject("language", m.getLanguage());
		mv.addObject("actor1name", m.getActor1name());
		mv.addObject("actor2name", m.getActor2name());
		mv.addObject("actor3name", m.getActor3name());
		mv.addObject("tag", m.getTag());
		mv.addObject("genre", m.getGenre());

		

		mv.setViewName("/WEB-INF/pages/movie.jsp");
		return mv;
	}
	
	
	@RequestMapping(value="/user/{target}")
	public ModelAndView userpage(@CookieValue(name="uid",defaultValue="") String uid,@PathVariable String target) throws NumberFormatException, Exception
	{
		ModelAndView mv = new ModelAndView();
		UserDAO dao= new UserDAO();
		User u = dao.getUserByUID(target);
		mv.addObject("name", u.getName());
		if(UserOption.allowInfo(u.getOption()))
		{
			mv.addObject("intro", u.getIntro());
			mv.addObject("email", u.getEmail());
			mv.addObject("date", u.getCreateDate());
		}
		else
		{
			mv.addObject("intro", "由于用户设置你不能查看");
			mv.addObject("email", "由于用户设置你不能查看");
			mv.addObject("date", "由于用户设置你不能查看");

		}
		

		mv.addObject("name", u.getName());
		
		mv.setViewName("/WEB-INF/pages/user.jsp");
		return mv;
	}
	
	@RequestMapping(value="/selecttag")
	public ModelAndView tagtag(@CookieValue(name="uid",defaultValue="") String uid) throws NumberFormatException, Exception
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/WEB-INF/pages/selectTag.jsp");
		return mv;
	}
	
	@RequestMapping(value="/tagsetting")
	public ModelAndView tagtag1(@CookieValue(name="uid",defaultValue="") String uid) throws NumberFormatException, Exception
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/WEB-INF/pages/tagsetting.jsp");
		return mv;
	}
	
	@RequestMapping(value="/pullNotification")
	public @ResponseBody String notificationlist(@CookieValue(name="uid",defaultValue="abc") String uid) throws Exception
	{
		MovieDAO dao = new MovieDAO();
		List<Tag> list = dao.findRandomTag();
		JSONArray array= JSONArray.fromObject(list);
		return array.toString();
	}
	
	@RequestMapping(value="/pullusertag")
	public @ResponseBody String usertaglist(@CookieValue(name="uid",defaultValue="abc") String uid) throws Exception
	{
		MovieDAO dao = new MovieDAO();
		UserDAO udao =new UserDAO();
		List<Action> list = dao.findUserAllTag(udao.getUserByUID(uid));
		JSONArray array= JSONArray.fromObject(list);
		return array.toString();
	}
	
	@RequestMapping(value="/sendusermessage")
	public @ResponseBody String sendmessage(@CookieValue(name="uid",defaultValue="abc") String uid,
			@RequestParam("target") String target,
			@RequestParam("content") String content) throws Exception
	{
		MovieDAO dao = new MovieDAO();
		UserDAO udao =new UserDAO();
		UUMessage m = new UUMessage();
		m.setUid(target);
		m.setSource(uid);
		m.setDate(new Date().toString());
		m.setType(3);
		m.setChecked(0);
		udao.insertMessage(m);
		List<Action> list = dao.findUserAllTag(udao.getUserByUID(uid));
		JSONArray array= JSONArray.fromObject(list);
		return array.toString();
	}
	
	
	@RequestMapping(value="/selectTag")
	public @ResponseBody String selecttag(@CookieValue(name="uid",defaultValue="abc") String uid
			,@RequestParam("target") String name) throws Exception
	{
		System.out.println("用户选了！"+name);
		MovieDAO dao = new MovieDAO();
		String s ="";
		Action a = new Action();
		a.setUid(uid);
		a.setMid(name);
		System.out.println(dao.isUserSelectTag(a));
		if(dao.isUserSelectTag(a)==0)
		{
			System.out.println(dao.isUserSelectTag(a));
			Action b = new Action();
			b.setUid(uid);
			name =name.trim();
			b.setMid(name);
			dao.userSelectTag(b);
			s = "ready";
		}
		return s;
	}
	
	
	@RequestMapping(value="/deleteTag")
	public @ResponseBody String deletetag(@CookieValue(name="uid",defaultValue="abc") String uid
			,@RequestParam("target") String name) throws Exception
	{
		System.out.println("用户:"+uid+"删了！"+name);
		MovieDAO dao = new MovieDAO(); 
		String s ="";
		Action b = new Action();
		name=name.trim();
		b.setUid(uid);
		b.setMid(name);
		dao.deleteUserTag(b);
		System.out.println(dao.isUserSelectTag(b));

		return s;
	}
	
}
