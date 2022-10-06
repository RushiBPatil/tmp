
public class PatternAlphabetEg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A 
//		A B 
//		A B C 
//		A B C D 
//		A B C D E 
//		A B C D E F 
		
		
//		int alpha=65;
//		for(int i=0;i<=5;i++)
//		{
//			for(int j=0;j<=i;j++)
//			{
//				System.out.print((char)(alpha+j)+" ");
//			}
//			System.out.println();
//		}
		
//		A 
//		B B 
//		C C C 
//		D D D D 
//		E E E E E 
//		F F F F F F
		
		int alpha=65;
		for(int i=0;i<=5;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print((char)(alpha)+" ");
			}
			alpha++;
			System.out.println();
		}
	}

}
