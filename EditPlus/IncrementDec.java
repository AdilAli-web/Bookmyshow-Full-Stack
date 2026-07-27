class IncrementDec 
{
	public static void main(String[] args) 
	{
		int a=5;
		int b=10;

		a++;
		b--;
		System.out.println(a);
		System.out.println(b);

		System.out.println("--------------------------------");
		int c=5;
		int d=++c; //c=6 d=6
		int res=c++; //res=6, c=7;
		System.out.println(d);
		System.out.println(res);
		System.out.println(c);

		int k=5;
		int r=++k + ++k - k-- + k++ + k--;
		System.out.println(r);
		System.out.println(k);
	}
}
