package com.mycompany.app;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
    }

    public static boolean search2(Integer[] arr2, ArrayList<Integer> array,int a, int e) {
        System.out.println("inside search");
        if (arr2 == null || array == null) return false;
  
        if(arr2.length == 0 || array.size() == 0) return false;

        if(a>=arr2.length || e>=array.size()) return false;

        if(arr2[a] > array.get(e) ) return true;

        return false;
    }

}
