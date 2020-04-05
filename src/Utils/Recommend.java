package Utils;

public class Recommend {
	public static double getRelation(String s1,String s2)
	{
		double result =0;
		double same=0;
		String[] temp1 = s1.split("\\|");
		String[] temp2 = s2.split("\\|");
		result = Math.min(temp1.length,temp2.length);
		
		for(String s :temp1)
		{
			for(String t:temp2)
			{
				s=s.trim();
				t=t.trim();
				if(s.equals(t))
				{
					same++;
					break;
				}
					
				
			}
			
		}
		result = same/result;
		result = result *100;
		result = Math.sqrt(result);
		result = result *10;
		return result;
	}
	
	
	public static String getSameTag(String s1,String s2)
	{
		String result ="";
		double same=0;
		String[] temp1 = s1.split("\\|");
		String[] temp2 = s2.split("\\|");
		for(String s :temp1)
		{
			for(String t:temp2)
			{
				s=s.trim();
				t=t.trim();
				if(s.equals(t))
				{
					result=result+s+"|";
					break;
				}
					
				
			}
			
		}

		return result;
	}
}
