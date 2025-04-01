import javax.swing.*;
import java.awt.*;

public class Slip24_1 extends JPanel implements Runnable {

    private String text = " Welcome to Java ";
    private int x = 0;

    public Slip24_1() {
        new Thread(this).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(text, x, 50);
    }

    public void run() {
        while (true) {
            x += 5;
            if (x > getWidth()) {
                x = -text.length() * 10;
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrolling Text");
        Slip24_1 obj = new Slip24_1();
        frame.add(obj);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
