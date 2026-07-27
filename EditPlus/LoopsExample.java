class WhileLoopExample 
{
	public static void main(String[] args) 
	{
		
		//initialization
		int i=1; 

		//condition
		while(i<=10)
		{
			System.out.println("Hello World!");
			i++; //i=i+1;
		}


		//example: find sum of 1 to 5 = 
		int j=1;
		int sum=0;
		while(j<=5)
		{
			sum=sum+j;
			j++;
		}
		System.out.println("sum of 1 to 5 = "+sum);

		//check even odd from 1 to 10
		//multiplication using while
		//5 * 1 = 5
		//5 * 2 = 10

	System.out.println("-----------------------------");
		int num=5;
		int k=1;
		while(k<=10)
		{
			System.out.println(num + " X " + k + " = "+ (num*k));
			k++;

		}

	}
}
