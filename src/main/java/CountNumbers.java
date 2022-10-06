
public class CountNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=23231,cnt=0;
		
		while(num>0) {
			cnt++;
			num=num/10;			
		}

		System.out.println("count is "+cnt);
	}

}
