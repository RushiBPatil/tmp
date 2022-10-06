
public class duplicateCharacterFromStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Hey hi you hello";
		
		dupliStr(s);		

	}
	public static void dupliStr(String S) {
		char ch[]=S.toCharArray();
		for(int i=0;i<S.length();i++) {
			int cnt=0;
			for(int j=i+1;j<S.length();j++) {
				if(ch[i]==ch[j]) {
				cnt++;
				ch[j]=0;
				}
			}
			if(cnt>0 && ch[i]!=0) {
				System.out.println("Duplicate char is: "+ch[i]);
			}
	}
}
}
