class TernoryOper 
{
	public static void main(String[] args) 
	{
		int age=20;
		String res=age>=18 ? "Adult" : "Minor";
		System.out.println(res);

		int a=6;
		int b=a++ + ++a - a-- + --a;
			
		System.out.println(b);

		System.out.println("----------------------------");
		int a1=2;
		int r1=++a1 + a1++ * --a1;
		
		System.out.println(a1);
		System.out.println(r1);
	}
}
