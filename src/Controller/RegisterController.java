package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import DAO.UserDAO;
import PO.User;
import Utils.DateFormater;

@Controller
public class RegisterController {
	
	@RequestMapping(value="/register")
	public ModelAndView register()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/pages/register.jsp");
		return mv;
	}
	@RequestMapping(value="/createuser")
	public ModelAndView createUser()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/pages/register.jsp");
		return mv;
	}
	
	@RequestMapping(value="/checkregister")
	public @ResponseBody String iduidvalid(@RequestParam("uid") String uid)
	{
		String s;
			System.out.println(uid);
		UserDAO dao = new UserDAO();
		int i = dao.getUserNumberByUID(uid);
		System.out.println("chekcUsername");
		if(i==0)
			s="";
		else
			s="此用户已存在!";
		return s;
		
	}
	@RequestMapping(value="/checkemail",produces = "text/html; charset=utf-8")
	public @ResponseBody String emailvalid(@RequestParam("email") String email)
	{
		
		String s ;
		String s1= "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		boolean isMatch = Pattern.matches(s1, email);
		if(!isMatch)
		{
			s="邮箱格式不正确!";
			return s;
		}
		else
			return "";
	}
	@RequestMapping(value="/confirmregister")
	public ModelAndView checkuid(@RequestParam("uid") String uid,
			@RequestParam("password") String password,
			@RequestParam("uname") String uname,
			@RequestParam("intro") String intro,
			@RequestParam("email") String email)
	{
		ModelAndView mv = new ModelAndView();
		UserDAO dao = new UserDAO();
//		
		System.out.println("createuser!");
		User u= new User();
		u.setUid(uid);
		u.setName(uname);
		u.setEmail(email);
		u.setPassword(password);
		u.setIntro(intro);
		Date date = new Date();
		DateFormater df= new DateFormater();
		String dates=df.date2String(date);
		u.setCreateDate(dates);
		u.setOption("000");
		dao.insertUser(u);
		mv.setViewName("/WEB-INF/pages/login.jsp");
		mv.addObject("message", "创建成功");
		System.out.println("/WEB-INF/pages/login.jsp");
		return mv;
	}
	
	
	private void renderData(HttpServletResponse response, String data) {
//	    PrintWriter printWriter = null;
//	    try {
//	      printWriter = response.getWriter();
//	      printWriter.print(data);
//	    } catch (IOException ex) {
//	    	System.out.println(ex.getMessage());
//	    } finally {
//	      if (null != printWriter) {
//	        printWriter.flush();
//	        printWriter.close();
//	      }
//	    }
	}
}
