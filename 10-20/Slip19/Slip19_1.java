//1. Write a java program to accept ‘N’ Integers from a user store them into 
// LinkedList Collection and display only negative integers. [15 M] 

import java.util.*;
public class Slip19_1
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> numbers = new LinkedList<>();
        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
            numbers.add(scanner.nextInt());
        System.out.println("Negative numbers:");
        for (int num : numbers) 
          if (num < 0) 
                System.out.println(num + " ");         
          scanner.close();
    }
}