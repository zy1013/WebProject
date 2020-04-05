package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PO.UUMessage;

public class MainApp {
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		UUMessage m = (UUMessage) context.getBean("test");
		System.out.println(m.getChecked());
		System.out.println(context.getType("test"));
		
	}
}
