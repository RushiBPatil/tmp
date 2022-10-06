import java.util.Arrays;

public class SumOfMaxDigitsArray {

	public static void main(String[] args) {

		 int a[] = new int[]{ 6,7,8,9,10,1,2,3,4,5 }; 
		 int sum=0;
		 //Arrays.sort(intArray);
		 for(int i=0;i<a.length;i++) {
			 for(int j=i+1;j<a.length;j++)
			 {
				 int tmp=0;
				 if(a[i]>a[j])
				 {
					 tmp=a[i];
					 a[i]=a[j];
					 a[j]=tmp;
				 }				 
			 }
			 System.out.print(""+a[i]);
		 }
		 int total=a.length-1;
		 sum=a[total] + a[total-1];
		 System.out.println("total is: "+sum);
		 
//		 for(int i=0;i<intArray.length;i++)
//		 {
//			 System.out.println(" "+intArray[i]);
//		 }
//		 sum=intArray[8] + intArray[9];
//		 System.out.println(""+sum);
	}}
