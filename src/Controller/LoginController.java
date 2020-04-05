package Controller;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DAO.UserDAO;
import PO.User;
import PO.UserLoginData;
import Utils.DateFormater;

@Controller
public class LoginController {
	@RequestMapping(value="/checklogin")
	public ModelAndView getValidateUID(@RequestParam("uid") String uid,@RequestParam("password") String password)
	{
		System.out.println(uid+"|"+password);
		UserDAO dao = new UserDAO();
		int i = dao.getUserNumberByUID(uid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("uid", uid);
		if(i==0)
		{
			mv.addObject("result", 0);
			mv.addObject("message","没有此用户");
			mv.setViewName("/WEB-INF/pages/result.jsp");
		}
		else
		{
			mv.addObject("result", 1);
			mv.addObject("message","此用户已存在");
			mv.setViewName("/WEB-INF/pages/home.jsp");
		}
		return mv;
	}
	@RequestMapping(value="/home")
	public ModelAndView login(@RequestParam(name="uid",defaultValue="") String uid,@RequestParam(name="password",defaultValue="") String password,
			@CookieValue(name="uid",defaultValue="") String cookieuid,
			@CookieValue(name="login",defaultValue="") String login,
			@CookieValue(name="lastlogin",defaultValue="") String lastlogin,
			@CookieValue(name="admin",defaultValue="") String admin,
			HttpServletResponse response) throws ParseException
	{
		
		System.out.println(uid+"|"+password);
		UserDAO dao = new UserDAO();
		int i = dao.getUserNumberByUID(uid);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("uid", uid);
		System.out.println("cookie:"+cookieuid+"|"+login);

		if(i==0)//不仅没登录还没这个号
		{
			System.out.println("没有");
			mv.addObject("result", 0);
			mv.addObject("message","没有此用户");
			mv.setViewName("/WEB-INF/pages/result.jsp");
		}
		else//密码看看
		{
			User u = dao.getUserByUID(uid);
			if(password.equals(u.getPassword())){//密码对了
				System.out.println("right");
				DateFormater df = new DateFormater();
		        String s = dao.LastLogin(uid);
		        Cookie cookie = new Cookie("uid",uid);//创建新cookie
		        cookie.setMaxAge(15 * 60);// 设置存在时间为5分钟
		        cookie.setPath("/");//设置作用域
		        response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户
		        cookie = new Cookie("lastlogin",s);//创建新cookie
		        cookie.setMaxAge(15 * 60);// 设置存在时间为5分钟
		        cookie.setPath("/");//设置作用域
		        response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给
		        if(admin.equals("admin"))
		        	admin="1";
		        cookie = new Cookie("admin",admin);//创建新cookie
		        cookie.setMaxAge(15 * 60);// 设置存在时间为5分钟
		        cookie.setPath("/");//设置作用域
		        response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给
		        
		        System.out.println("lastlog"+s);
		        mv.addObject("message","欢迎");
		        mv.addObject("uname", u.getName());
		        mv.addObject("lastlogin", s);
		        mv.setViewName("/WEB-INF/pages/home.jsp");
		        UserLoginData uld=new UserLoginData();
		        uld.setUid(uid);
		        
		        
		        uld.setDate(new Date().toString());
				dao.UserLogin(uld);
			}
			else
			{
				System.out.println("错了");
				mv.addObject("result", 0);
				mv.addObject("message","密码错误！");
				mv.setViewName("/WEB-INF/pages/result.jsp");
			}

		    
			
		}
		return mv;
		
		
		
	}
	
	
	
	
}
