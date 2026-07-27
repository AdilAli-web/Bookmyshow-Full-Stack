
class Student 
{
	int age;
	String name;
	String course;

	void study()
	{
		
		System.out.println("Student is studying");
	}
}



public class TestClass
{
	public static void main(String[] args) 
	{
		Student s= new Student(); //object creation
		//how to use class actions and fields = .
		System.out.println(s.age);
		System.out.println(s.name);

		s.age=20;
		s.name="Amit";
		System.out.println(s.age);
		System.out.println(s.name);


	}
}
