import java.util.*;
public class Slip29_2 
{
    public static void main(String[] args) 
    {
        // Create a LinkedList of Integer objects
        LinkedList<Integer> numbers = new LinkedList<>();

        // Adding some initial elements to the LinkedList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        // i. Add element at the first position
        numbers.addFirst(5);
        System.out.println("After adding element at first position: " + numbers);

        // ii. Delete the last element
        numbers.removeLast();
        System.out.println("After deleting the last element: " + numbers);

        // iii. Display the size of the LinkedList
        int size = numbers.size();
        System.out.println("Size of the LinkedList: " + size);
    }
}
