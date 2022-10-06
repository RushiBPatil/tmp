
public class swapFirstNLastChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S="Goodbye Aurus";
		System.out.println("Before swap: "+S);
		swapchar(S);

	}
	
	public static void swapchar(String S) {
		char ch[]=S.toCharArray();
		
		char tmp=ch[0];
		ch[0]=ch[ch.length-1];
		ch[ch.length-1]=tmp;
		System.out.println("After swap string is: "+String.valueOf(ch));
	}

}
