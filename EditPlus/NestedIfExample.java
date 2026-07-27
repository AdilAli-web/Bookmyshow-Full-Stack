class NestedIfExample 
{
	public static void main(String[] args) 
	{
		String username="genie";
		String password="1231";

		if(username=="genie")
		{
			if(password=="123")
			{
				System.out.println("Login");
			}
			else
			{
				System.out.println("Wrong password");
			}
		}
		else
			{
			System.out.println("Wrong username");
			}
	}
}
