package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFound2()
    {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
        Integer[] arr={2,3,4,5};
        assertFalse(new App().search2(arr, array, 3, 3));
    }
    
 public void testFound() {

    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    Integer[] arr={2,3,4,5};

    assertTrue(new App().search2(arr, array, 3, 3));

  }


  public void testNotFound() {

    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    Integer[] arr={2,3,4,5};

    assertFalse(new App().search2(arr, array, 5, 5));

  }


  public void testEmptyArray() {

    ArrayList<Integer> array = new ArrayList<>();
    Integer[] arr=new Integer[4];

    assertFalse(new App().search2(arr, array, 1, 1));

  }


  public void testNull() {

    assertFalse(new App().search2(null, null, 1, 1));

  }


}
