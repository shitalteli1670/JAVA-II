class ThreadName_Priority extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Thread Priority: " + getPriority());
    }

    public static void main(String[] args) {
        ThreadName_Priority t1 = new ThreadName_Priority();
        ThreadName_Priority t2 = new ThreadName_Priority();
        t1.setName("FirstThread");
        t2.setName("SecondThread");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        
        t1.start();
        try {
            t1.join();  // Handle InterruptedException
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        t2.start();
    }
}
