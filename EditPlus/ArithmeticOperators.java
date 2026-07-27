class ArithmeticOperators 
{
	public static void main(String[] args) 
	{
		int a=10;
		int b=5;

		int res=a+b;
		System.out.println(res);

		//
		int math =90;
		int science=80;
		int eng=40;
		
		int total=math+science+eng;
		System.out.println("total = "+total);

		//sum
		int a1=50;
		int b1=40;
		System.out.println(a1-b1);

		//shopping
		int walletBal=1000;
		int shoppingAmt=500;

		int remBal=walletBal-shoppingAmt;
		System.out.println(remBal);

		//mul
		int c1=10;
		int c2=5;
		System.out.println(c1*c2);

		//electricity bill
		//per unit=8
		int unitPrice=8;
		int unitInMonth=300;

		int totalBillForMonth=unitPrice*unitInMonth;
		System.out.println("electricity bill "+totalBillForMonth);

		//divison
		int a2=10;
		int a3=5;
		int a4=3;
		System.out.println(a2/a3); //2
		System.out.println(a2%a4); //1

		//Concatenation 
		String firstName="rahul";
		String lastname="Sharma";
		int n=10;
		System.out.println(firstName+" "+lastname);
		System.out.println(firstName+" "+n); 

		System.out.println(10+20); //20
		System.out.println("10"+20);// 1020
		System.out.println(10+20+"java"); //30java
		System.out.println("java"+10+20); //java1020

	}
}
