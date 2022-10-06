
public class ScannerEgTest {

	public static void main(String[] args) {
		int a=10,b=20,c=15,large;			
		large=c>(a>b?a:b)?c:(a>b?a:b);
		System.out.println("Largest number is: "+large);
	}
}
