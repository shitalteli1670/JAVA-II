import java.util.Random;
class Slip7_1 extends Thread 
{
	public void run() 
	{
		Random random = new Random();
		for (int i = 0; i < 10; i++) 
		{
			int rnum = random.nextInt(100);
			System.out.println("Random Integer generated : " + rnum);
			if((rnum%2) == 0) 
            {
	SquareThread sThread = new SquareThread(rnum);
				sThread.start();
			}
			else 
			{
			CubeThread cThread = new CubeThread(rnum);
				cThread.start();
			}
			try 
            {
				Thread.sleep(1000);
			} 
			catch (InterruptedException ex) 
            {
				System.out.println(ex);
			}
		}
	}
	public static void main(String args[]) 
	{
	Slip7_1 rnThread = new Slip7_1();
		rnThread.start();
	}
}
class SquareThread extends Thread 
{
	int n;
	SquareThread(int rn) 
	{
		n = rn;
	}
	public void run() 
	{
	    System.out.println("Square of " + n + " = " + (n * n));
	}
}
class CubeThread extends Thread 
{
	int n;
	CubeThread(int rn) 
	{
		n = rn;
	}
	public void run() 
	{
	    System.out.println("Cube of " + n + " = " + (n * n * n));
	}
}