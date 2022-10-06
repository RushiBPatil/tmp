
public class OddEvenNumberCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num=12345;
		int even=0,odd=0;
		
		while(num>0) {
			int rem=num%10;
			if(rem%2==0) {				
				even++;				
			}
			else {
				odd++;				
			}
			num=num/10;
		}
		System.out.printf("even count is %d and odd count is %d",even,odd);
	}

}
