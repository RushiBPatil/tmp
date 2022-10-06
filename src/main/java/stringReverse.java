import java.util.Scanner;

public class stringReverse {

	public static void main(String[] args) {		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter String to Reverse: ");
		String tmp=sc.nextLine();
		System.out.println("original string is: " + tmp);
		System.out.println("reversed string logic1 is :" + reverse(tmp));
		System.out.println("reversed string logic2 is :" + reverse2(tmp));
		System.out.println("Reverse words : "+ ReverseWords(tmp));
	}

	public static String reverse(String S) {
		char ch;
		String tmp = "";

		for (int i = 0; i < S.length(); i++) {
			ch = S.charAt(i);			
//			System.out.println("current ch"+ ch);
			tmp = ch + tmp;
		}
		return tmp;

	}
	public static String ReverseWords(String s) {
		String tmp[]=s.split(" ");
		String tmp1="";
//		for(int i=0;i<tmp.length;i++)
//		{
//			tmp1= tmp[i]+ " " + tmp1;
//		}		
//		System.out.println("final reversed "+tmp1);
//		return tmp1;
		for(String rev:tmp)
		{
			StringBuffer sb= new StringBuffer(rev);
			sb.reverse();	
			tmp1=sb+tmp1;
		}
		return tmp1;
	}
	
	public static StringBuffer reverse2(String S) {
		StringBuffer sb=new StringBuffer(S);
		StringBuffer rev=sb.reverse();		
		return rev;
	}
}
