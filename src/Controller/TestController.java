package Controller;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	private static final Log logger = LogFactory.getLog(TestController.class);
	static{
		Date d =new Date();
		System.out.println(d.toString());
	}

//	public ModelAndView helloworld(@RequestParam("uid") String uid,@RequestParam("password") String password)
//	{
//		logger.info("user info");
//		System.out.println(uid+"|"+password);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message","helloworld"+uid+password);
	@RequestMapping(value="/hello")
	public ModelAndView helloworld()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/index.html");
		return mv;
	}


	@RequestMapping(value="/login")
	public ModelAndView login()
	{
		System.out.println("login");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/pages/login.jsp");
		return mv;
	}
}
