//1. Write a java program for the implementation of synchronization. [15 M] 
class Nsynchro
{
    synchronized void disp()
    {
        try
        {
            System.out.println("Come on");
            System.out.println("Students");
            System.out.println("enjoy");
            Thread.sleep(1000);
        }
        catch(InterruptedException e){System.out.println("Error"+e);}
        System.out.println("book");
        System.out.println("Reading");
    }
}
class Test implements Runnable
{
    Thread d;
    Nsynchro ob1;
    public Test(Nsynchro o1)
    {
        ob1=o1;
        d=new Thread(this);
        d.start();
    }
    public void run()
    {
        ob1.disp();
    }
}
class Testmain
{
    public static void main(String []arg)
    {
        Nsynchro ob2=new Nsynchro();
        Test ob3=new Test(ob2);
        Test ob4=new Test(ob2);
    }
}