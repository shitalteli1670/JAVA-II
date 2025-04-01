class Print extends Thread
{
    String msg;
    int n;
    public Print(int n,String msg)
    {
        this.n=n;
        this.msg=msg;
    }
    public void run()
    {
	    for(int i=0;i<n;i++)
        System.out.println(msg);
    }
}
public class Slip8_1 
{
    public static void main(String[] arg)throws Exception
    {
	Print t1=new Print(10,"Covid19");
    	t1.start();
	Print t2=new Print(20,"Lockdown 2020");
    	t2.start();
	Print t3=new Print(30,"Vaccinated 2021");
    	t3.start();
    }
}