//1. Write a Java program using Runnable interface to blink Text on the frame. [15 M] 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Slip4_1 extends JFrame implements Runnable
{
    Thread t;
    JLabel l1;
    int flag;
    Slip4_1()
    {
        t=new Thread(this);
        t.start();
        setLayout(null);
        l1=new JLabel("This is Multithreading");
        l1.setBounds(100,100,150,40);
        add(l1);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flag=0;
    }
    public void run()
    {
        try
        {
            if(flag==0)
            {
                t.sleep(20);
                l1.setText("");
                flag=1;
            }
            if(flag==1)
            {
                t.sleep(20);
                l1.setText("This is Multithreading");
                flag=0;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  run();
    }
    public static void main(String a[])
    {
        new Slip4_1();
    }
}
