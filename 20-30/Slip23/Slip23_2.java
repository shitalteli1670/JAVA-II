import java.util.*;

public class Slip23_2 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide student names as command-line arguments.");
            return;
        }

        List<String> studentNames = new ArrayList<>(Arrays.asList(args));

        // Adding student names to the list
        for (int i = 0; i < args.length; i++) {
            studentNames.add(args[i]);
        }

        // Display student names using Iterator
        System.out.println("\nDisplaying student names using Iterator:");
        Iterator<String> it = studentNames.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Student names using ListIterator (forward direction):");
        ListIterator<String> lt = studentNames.listIterator();
        while (lt.hasNext()) {
            System.out.println(lt.next());
        }

        System.out.println("\nStudent names using ListIterator (backward direction):");
        while (lt.hasPrevious()) {
            System.out.println(lt.previous());
        }
    }
}
