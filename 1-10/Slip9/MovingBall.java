import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MovingBall extends JFrame 
{
    private int y = 0;
    private boolean moving = false;
    public MovingBall() 
    {
        setTitle("Moving Ball");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        final BallPanel ballPanel = new BallPanel(); 
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                BallThread thread = new BallThread(ballPanel);
                thread.start();
            }
        });
        add(ballPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
        setVisible(true);
    }
    class BallPanel extends JPanel 
    {
        @Override
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(180, y, 40, 40);
        }
    }
    class BallThread extends Thread 
    {
        private BallPanel panel;
        public BallThread(BallPanel panel) 
        {
            this.panel = panel;
        }
        @Override
        public void run() 
        {
            moving = true;
            while (moving) 
            {
                y += 5;
                if (y > panel.getHeight()) 
                {
                    y = 0;
                }
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        new MovingBall();
    }
}