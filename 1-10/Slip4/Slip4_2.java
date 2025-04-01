//2. Write a Java program to store city names and their STD codes using an appropriate collection and perform following operations: i. Add a new city and its code (No duplicates) ii. Remove a city from the collection iii. Search for a city name and display the code [15 M]

import java.io.*;
import java.util.*;

class Slip4_2 {
    public static void main(String args[]) throws IOException {
        Hashtable ht = new Hashtable();
        int std_code;

        String city_name = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("\n Enter no of Records : ");

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter City name :");

            city_name = sc.next();

            System.out.print("Enter STD code :");

            std_code = sc.nextInt();

            ht.put(city_name, std_code);

        }

        System.out.println("Hash table = " + ht);

        System.out.println("Enter city name tobe search : ");

        String search_nm = sc.next();

        if (ht.containsKey(search_nm)) {
            System.out.println("STD Code of City " + search_nm + " is" + ht.get(search_nm)); 
        }else {
            System.out.println("City not found");
        }

        System.out.println("Enter city name to be remove : ");

        String removeCity = sc.next();

        ht.remove(removeCity);

        System.out.println("After removing city " + removeCity + " data is " + ht);

    }
}
