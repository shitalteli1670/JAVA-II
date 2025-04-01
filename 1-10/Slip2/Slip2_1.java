import java.util.*;
public class Slip2_1 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> names = new HashSet<>();
        System.out.print("Enter the number of friends: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) 
        {
            System.out.print("Enter name: ");
            names.add(scanner.nextLine());
        }
        TreeSet<String> sortedNames = new TreeSet<>(names);
        for (String name : sortedNames) 
            System.out.println(name);       
        scanner.close();
    }
}

