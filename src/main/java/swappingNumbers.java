
public class swappingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 25, b = 35;
//		b = b + a; // 35+25=60
//		a = b - a; // 60-25=35
//		b = b - a; // 60-35=25
		System.out.printf("after swap no a is %d and b is %d", a, b);
		
		//Logic2
		b=a+b-(a=b);
		//a=35		
		System.out.printf("after swap no a is %d and b is %d", a, b);
	}
}
