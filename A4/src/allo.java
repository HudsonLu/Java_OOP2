
public class allo {
	
	public interface Greetings 
	{
		public String sayHello();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		
		Greetings english = new  Greetings ()
		{
		@Override
		public String sayHello() {return "Hello";}
		};
		
		
		System.out.println(english.sayHello());
		
	

}
}