import javax.swing.*;
import java.awt.*;
public class Slip6_2 extends JFrame implements Runnable 
{
    private int time, cnt;
    private Thread t;
    public Slip6_2() 
    {
        setTitle("Traffic Signal Timer");
        setSize(200, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        time = 10;
        cnt = 0;
        t = new Thread(this);
        t.start();
    }
    public void run() 
    {
        try 
        {
            while (true) 
            {
                while (time >= 0) 
                {
                    repaint();
                    Thread.sleep(50);
                    time--;
                }
                cnt = (cnt + 1) % 3;
                time = (cnt == 1) ? 5 : 10;
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void paint(Graphics g) 
    {
        super.paint(g);
        g.setColor(Color.black);
        g.drawOval(70, 50, 50, 50);
        g.drawOval(70, 110, 50, 50);
        g.drawOval(70, 170, 50, 50);
        g.setColor(Color.black);
        g.drawString("Time : " + time, 85, 230);
        if (cnt == 0) 
        {
            g.setColor(Color.green);
            g.fillOval(70, 170, 50, 50);
        } else if (cnt == 1) 
        {
            g.setColor(Color.orange);
            g.fillOval(70, 110, 50, 50);
        } else 
        {
            g.setColor(Color.red);
            g.fillOval(70, 50, 50, 50);
        }
    }
    public static void main(String[] args) 
    {
        new Slip6_2();
    }
}
