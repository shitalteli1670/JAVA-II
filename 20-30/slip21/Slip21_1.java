//1. Write a java program to accept ‘N’ Subject Names from a user store them into LinkedList Collection 
// and Display them by using Iterator interface. [15 M] 

import java.util.*;
class Slip21_1 
{
    public static void main(String args[]) 
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter how many subject names you want to enter: ");
        int n = s.nextInt();
        LinkedList<String> ll = new LinkedList<>();
        for (int i = 0; i < n; i++) 
        {
            System.out.print("Enter subject name: ");
            ll.add(s.next());
        }
        System.out.println("\nSubjects entered:");
        Iterator<String> itr = ll.iterator();
        while (itr.hasNext()) 
        {
            System.out.println(itr.next());
        }
        s.close();
    }
}


