
public class CountCharFromSentense {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="Hi i'm 1234 rushi";
		count(test);
		
	}

	public static void count(String S) {
		char[] ch=S.toCharArray();
		int characters=0,integers=0,space=0;
		
		for(int i=0;i<S.length();i++) {			
			
			if(Character.isLetter(ch[i])) {
				characters++;
			}
			else if(Character.isDigit(ch[i])) {
				integers++;				
			}
			else if(Character.isWhitespace(ch[i])) {
				space++;
			}
		}
		System.out.println("character count is: "+characters);
		System.out.println("Digit count is: "+integers);
		System.out.println("White spaces are: "+space);
	}
}
