class Slip28_2 extends Thread 
{
    public void run() 
    {
        System.out.println("Currently executing thread: " + Thread.currentThread().getName());
    }
    public static void main(String[] args) 
    {
        Slip28_2 t1 = new Slip28_2();
        Slip28_2 t2 = new Slip28_2();
        t1.setName("FirstThread");
        t2.setName("SecondThread");
        t1.start();
        t2.start();
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}