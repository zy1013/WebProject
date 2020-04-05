package Controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import DAO.UserDAO;
import PO.UUMessage;
import PO.UURelation;
import PO.User;
import net.sf.json.JSONArray;

@Controller
public class FriendController {
	@RequestMapping(value="/friends")
	public ModelAndView getFriendList(@CookieValue(name="uid",defaultValue="") String uid)
	{
		UserDAO dao = new UserDAO();
		int i = dao.getUserNumberByUID(uid);
		ModelAndView mv = new ModelAndView();
		List<UURelation> list = dao.getUserRelation(uid);
		System.out.println("这个人有"+list.size());
		
		mv.addObject("uid", uid);
		mv.addObject("list", list);
		mv.setViewName("/WEB-INF/pages/friend.jsp");
		return mv;
	}
	
	@RequestMapping(value="/adminuser")
	public ModelAndView getadminList(@CookieValue(name="uid",defaultValue="") String uid)
	{
		UserDAO dao = new UserDAO();
		int i = dao.getUserNumberByUID(uid);
		ModelAndView mv = new ModelAndView();
		List<User> list = dao.selectAllUser();
		
		mv.addObject("uid", uid);
		mv.addObject("list", list);
		mv.setViewName("/WEB-INF/pages/adminuser.jsp");
		return mv;
	}
	
	@RequestMapping(value="/friend/{target}")
	public ModelAndView chat(@CookieValue(name="uid",defaultValue="") String uid,@PathVariable String target)
	{
		ModelAndView mv = new ModelAndView();

		mv.addObject("uid", uid);
		mv.addObject("targer",target);
		mv.setViewName("/WEB-INF/pages/userchat.jsp");
		return mv;
	}


	@RequestMapping(value="/friend/sendmessage")
	public void sendMessage(@CookieValue(name="uid",defaultValue="") String uid,
			@RequestParam(name="target",defaultValue="") String target,
			@RequestParam(name="content",defaultValue="") String message)
	{
		UserDAO dao = new UserDAO();
		UUMessage m = new UUMessage();
		m.setUid(target);
		m.setSource(uid);
		m.setDate(new Date().toString());
		m.setMessage(message);
		m.setType(1);
		m.setChecked(0);
		dao.insertMessage(m);
	}
	
	@RequestMapping(value="/friend/pullchat")
	public @ResponseBody String pullchatmessage(@CookieValue(name="uid",defaultValue="abc") String uid,
			@RequestParam(name="target",defaultValue="") String target) throws Exception
	{
		UserDAO udao =new UserDAO();
		UUMessage u=new UUMessage();
		u.setUid(uid);
		u.setSource(target);
		List<UUMessage> list = udao.getUserChatMessage(u);
		System.out.println("这个人有"+list.size()+"个聊天记录");
		JSONArray array= JSONArray.fromObject(list);
		return array.toString();
	}

	
}
