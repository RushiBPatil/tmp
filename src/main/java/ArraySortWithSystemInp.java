import java.util.Scanner;

public class ArraySortWithSystemInp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		// String tmp=sc.nextLine();

		System.out.println("Enter numbers");
		int a[] = new int[5];

		for (int i = 0; i < 5; i++) {
			a[i] = sc.nextInt();
		}
		for (int j = 0; j < 5; j++) {
			System.out.print("" + a[j]);
		}

//		//int a[] =sc.next();
		// int a[]= new int[]{3,5,10,15,4,8};
		int tmp = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		System.out.println("");
		System.out.println("Max " + a[a.length - 1]);
		System.out.println("Min " + a[0]);

	}

}
