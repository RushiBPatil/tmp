import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class CountStringFromSentense {

	public static void main(String[] args) {

		String str = "I am am am hero hero";
		String[] s= str.split(" ");
		Map<String, Integer> map= new HashedMap<String, Integer>();
		
		for(String tmp:s) {
			if(map.containsKey(tmp)) {
				map.put(tmp,map.get(tmp)+1);				
			}
			else {
				map.put(tmp,1);
			}			
		}
		System.out.println(" "+map);
		Iterator<String> itr=map.keySet().iterator();
		while(itr.hasNext())
		{
			String t=itr.next();
			if(map.get(t)>1)
			{
				System.out.println("Word "+t+" repeated "+map.get(t)+" times");
			}
		}

//	String s="aabccssddh";
//	char[] chararray=s.toCharArray();
//	Map<Character, Integer> map= new HashedMap<Character,Integer>();
//	for(char ch:chararray) {
//		if(map.containsKey(ch)) {
//			map.put(ch,map.get(ch)+1);
//		}
//		else {
//			map.put(ch,1);
//		}
//	}
//	System.out.println(""+map);
//	
//	}
	}
}
