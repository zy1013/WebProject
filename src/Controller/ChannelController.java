package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import DAO.ChannelDAO;
import DAO.MovieDAO;
import DAO.UserDAO;
import PO.Action;
import PO.Channel;
import PO.Movie;
import PO.RecommendMovie;
import PO.User;
import Utils.Recommend;
import net.sf.json.JSONArray;

@Controller
public class ChannelController {
	
	@RequestMapping(value="/checklogin11")
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
			mv.setViewName("/WEB-INF/view/afterlogin.jsp");
		}
		else
		{
			mv.addObject("result", 1);
			mv.addObject("message","此用户已存在");
			mv.setViewName("/WEB-INF/view/afterlogin.jsp");
		}
		return mv;
	}
	
	@RequestMapping(value="/sendMessage")
	public ModelAndView sendMessage(@CookieValue(name="uid",defaultValue="") String uid,
			@RequestParam("password") String password)
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
			mv.setViewName("/WEB-INF/view/afterlogin.jsp");
		}
		else
		{
			mv.addObject("result", 1);
			mv.addObject("message","此用户已存在");
			mv.setViewName("/WEB-INF/view/afterlogin.jsp");
		}
		return mv;
	}
	
	@RequestMapping(value="/createchannel")
	public ModelAndView createChannel(@RequestParam("cid") String cid,@RequestParam("cname") String cname
			,@RequestParam("cintro") String cintro
			,@RequestParam("public") String option
			)
	{
		
		ChannelDAO dao = new ChannelDAO();
		Channel c = new Channel();
		c.setCid(cid);
		c.setName(cname);
		c.setIntro(cintro);
		c.setOption(option);
		c.setCreateDate(new Date().toString());
		System.out.println(new Date().toString());
		dao.insertChannel(c);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/view/mainPage.jsp");
//		mv.addObject("uid", uid);
//		if(i==0)
//		{
//			mv.addObject("result", 0);
//			mv.addObject("message","没有此用户");
//			mv.setViewName("/WEB-INF/view/afterlogin.jsp");
//		}
//		else
//		{
//			mv.addObject("result", 1);
//			mv.addObject("message","此用户已存在");
//			mv.setViewName("/WEB-INF/view/afterlogin.jsp");
//		}
		return mv;
	}
}
