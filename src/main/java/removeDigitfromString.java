
public class removeDigitfromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Rushi12#$%345 patil QA";
		System.out.println("Before String "+s);
		digitrem(s);

	}
	
	public static void digitrem(String s) {
		char ch[]=s.toCharArray();
		String tmp="";
		
		for(int i=0;i<s.length();i++) {
//			if(!Character.isDigit(ch[i])) {
//				tmp=tmp+ch[i];
//			}
//			if(Character.isLetter(ch[i]) || Character.isDigit(ch[i])) {
//				tmp=tmp+ch[i];
//			}
			if(!Character.isWhitespace(ch[i])) {
				tmp=tmp+ch[i];
			}
		}
		System.out.println("final string is:"+tmp);
	}
}
