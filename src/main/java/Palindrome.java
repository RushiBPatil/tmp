import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		String tmp="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string to check Palindrome");
		String inp=sc.nextLine();		
		char ch;
		
		for(int i=0;i<inp.length();i++) {
			ch=inp.charAt(i);			
			tmp=ch+tmp;
		}
		System.out.println("Reversed string is: "+tmp);
		if(tmp.equals(inp)) {
			System.out.println("String is Palindrome");
		}
		else {
			System.out.println("String is not Palindrome");
		}
	}
	
}
