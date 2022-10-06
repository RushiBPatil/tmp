import java.util.Arrays;

public class SecondLargestNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {3,10,5,90,12,15,80};
		int tmp=0;
		
		Arrays.sort(arr);		
		for(int i=arr.length -2;i>=0;i--) {
		if(arr[i]!=arr[i-1]) {
			System.out.println("2nd last"+arr[i]);
		}
		}
//		for(int i=0;i<arr.length;i++) {
//			
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[i]>=arr[j]) {
//					arr[j]=arr[i];
//					tmp=arr[i];	
//					System.out.println("temp printing"+tmp);
//				}
//				else if(arr[j]<arr[i]) {
//					tmp=arr[j];
//				}
//			}			
//		}			
//		System.out.println("2nd largest number "+tmp);
	}

}
