//1. Write a java program to accept ‘N’ integers from a user. 
// Store and display integers in sorted order having proper collection class. 
// The collection should not accept duplicate elements. [15 M] 

import java.util.*;
import java.io.*;
public class SetB1collection
{
    public static void main(String[] args) throws IOException
    {
        int n;
        HashSet hs=new HashSet();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the no of elements");
        n=Integer.parseInt(br.readLine());
        System.out.println("Enter the nos");
        for(int i=0;i<n;i++)
        {
            int a=Integer.parseInt(br.readLine());
            hs.add(a);
        }
        System.out.println("The elements are"+hs);
        TreeSet t=new TreeSet(hs);
        Iterator it=t.iterator();
        System.out.println("The Sorted data");
        while(it.hasNext())
        System.out.println(it.next());
    }
}

