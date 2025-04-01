//1. Write a java program to create a TreeSet, add some colors (String) and print out the content of TreeSet in ascending order. [15 M] 

import java.util.*;
public class TreesetDemoSetA3
{
        public static void main(String[] args) 
        {
                TreeSet<String> ts=new TreeSet<String>();
                ts.add("blue");
                ts.add("red");
                ts.add("green");
                ts.add("blue");
                ts.add("yellow");
                ts.add("cyan");
                System.out.println("The contents of set are :"+ts);	
        }
}