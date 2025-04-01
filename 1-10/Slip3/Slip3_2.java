import java.util.LinkedList;
import java.util.ListIterator;
public class Slip3_2 
{
    public static void main(String[] args) 
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("Original List : "+list);
        list.addLast("Date");
        System.out.println("After Adding element at last : "+list);
        list.removeFirst();
        System.out.println("After removing first element : "+list);
        System.out.println("List elements in reverse order ");
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) 
        {
            System.out.println(iterator.previous());
        }
    }
}