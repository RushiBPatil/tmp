
public class PringString1 {

	public static void main(String[] args) {

		String s = "aabbcddeecffgg";
		char[] ch = s.toCharArray();
		for (int i = 0; i < s.length(); i++)
		{ //used to traverse in string
			if (ch[i] == 'c')
			{
				for (int j = i+1; j < s.length(); j++) 
				{ //used to traverse after character c
					if (ch[j] != 'c')
					{
						System.out.print("" + ch[j]);
						
					}
				}
				break;
			}  
		}
	}
}
