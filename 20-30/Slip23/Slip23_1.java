import java.util.Scanner;

public class Slip23_1 extends Thread
{
    String S1;

    public Slip23_1(String str)
    {
        S1 = str;
        start();
    }

    public void run()
    {
        for (int i = 0; i < S1.length(); i++)
        {
            char ch = S1.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                System.out.println(ch);

                try
                { 
                    Thread.sleep(3000);
                }
                catch (Exception e)
                {
                    System.out.println("Exception : " + e);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string:   ");
        String str2 = scanner.nextLine();

        Slip23_1 obj = new Slip23_1(str2);
    }
}
