import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {

		String s1="hello";
		String s2="oelhh";
		wordAnagram(s1,s2);
		String s3="I am rUshi";
		String s4="am I Shiru";
		sentenceAnagram(s3,s4);
	}
	public static void wordAnagram(String s1, String s2)
	{
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		char a[]=s1.toCharArray();
		char b[]=s2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		if(Arrays.equals(a,b))
		{
			System.out.println("String is anagram");
		}
		else
		{
			System.out.println("Not Anagram");
		}
		
	}
	
	public static void sentenceAnagram(String s1, String s2)
	{
		s1=s1.replace(" ", "");
		s2=s2.replace(" ","");
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();		
		char[] a= s1.toCharArray();
		char[] b= s2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		if(Arrays.equals(a,b))
		{
			System.out.println("Sentence is anagram");
		}
		else
		{
			System.out.println("Sentence is not anagram");
		}
	}

}
