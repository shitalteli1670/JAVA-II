public class Slip1_1 extends Thread
{
    char ch;
    public void run()
    {
        for(ch = 'A'; ch<='Z';ch++)
        {
            System.out.println(ch+" ");
            try
            {
                Thread.sleep(2000); 
            } 
            catch(Exception e)
            {
                System.out.print(e);
            }
        }
    }
    public static void main(String args[])
    {
        Slip1_1 t = new Slip1_1();
        t.start();
   }
}