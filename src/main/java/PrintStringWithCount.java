import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PrintStringWithCount {

	public static void main(String[] args) {

		String s = "aabbbcddddee";
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		char ch[] = s.toCharArray();

		for(char c:ch) {
			if(m.containsKey(c)) {
				m.put(c, m.get(c)+1);
			}
			else {
				m.put(c,1);
			}
		}
		for(Entry e: m.entrySet()) {
			System.out.println(""+e.getKey()+""+e.getValue());	
		}
		
		
	}
}
