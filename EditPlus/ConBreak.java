class ConBreak
{
	public static void main(String[] args) 
	{
		
		for(int i=1;i<=10;i++)
		{
			if(i==5) break;
			System.out.println(i);
		}

		System.out.println("hello...");

		for(int i=1;i<=10;i++)
		{
			if(i%2!=0) continue;
			System.out.println(i);
		}

		//2,4,6,8,10

	}
}
