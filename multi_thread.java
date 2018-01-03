class A extends Thread
{
	public void run()
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			System.out.println("Hello") ;
		}
	}
}

class B extends Thread
{
	public void run()
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			System.out.println("Hi") ;
		}
	}
}

public class multi_thread
{
	public static void main(String[] args)
	{
		A obj1 = new A() ;
		B obj2 = new B() ;

		Thread t1 = new Thread(obj1) ;
		Thread t2 = new Thread(obj2) ;

		t1.start() ;
		t2.start() ;
	}
}