
public class PrintTill100RecursiveFunc {

	public static void main(String[] args) {

		//printNumbers(1);
		printNumbersRange(1, 101);
	}
	
	public static void printNumbers(int num)
	{
		if(num<=100)
		{
			System.out.println(""+num);
			num++;
			printNumbers(num);
		}
	}
	
	public static void printNumbersRange(int startNo,int endNo)
	{
		if(startNo<=endNo)
		{
			System.out.println(""+startNo);
			startNo++;
			printNumbers(startNo);
		}
	}
}
