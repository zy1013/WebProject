package Utils;

public class UserOption {
	public static boolean allowRecommend(String option)
	{//允许被推荐
		boolean flag = true;
		char[] array = option.toCharArray();
		if( array[0]=='0')
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		return flag;
	}
	
	public static boolean allowInfo(String option)
	{//允许查看个人信息
		boolean flag = true;
		char[] array = option.toCharArray();
		if( array[1]=='0')
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		return flag;
	}
	public static boolean allowAdd(String option)
	{//允许添加好友
		boolean flag = true;
		char[] array = option.toCharArray();
		if( array[2]=='0')
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		return flag;
	}
	public static void main(String[] args)	{
		String s = "1010";
		System.out.println(allowRecommend(s));
	}
}
