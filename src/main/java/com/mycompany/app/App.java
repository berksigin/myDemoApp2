
package com.mycompany.app;


import static spark.Spark.get;

import static spark.Spark.port;

import static spark.Spark.post;
import java.util.*;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;


import spark.ModelAndView;

import spark.template.mustache.MustacheTemplateEngine;


/**
 * Hello world!
 *
 */
public class App
{
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
    
public static void main(String[] args) {

    port(getHerokuAssignedPort());


    get("/", (req, res) -> "Hello, World");


    post("/compute", (req, res) -> {

      //System.out.println(req.queryParams("input1"));

      //System.out.println(req.queryParams("input2"));


      String input1 = req.queryParams("input1");

      java.util.Scanner sc1 = new java.util.Scanner(input1);

      sc1.useDelimiter("[;\r\n]+");

      java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();

      while (sc1.hasNext())

      {

        int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));

        inputList.add(value);

      }

      System.out.println(inputList);

      String input2 = req.queryParams("input2");
      java.util.Scanner sc2 = new java.util.Scanner(input2);
      sc2.useDelimiter("[;\r\n]+");
      java.lang.Integer [] inputList2= new java.lang.Integer[4];
      int i=0;
      while (sc2.hasNext())
      {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2[i]= value;
      }
      System.out.println(inputList2);


      String input3 = req.queryParams("input3").replaceAll("\\s","");

      int input3AsInt = Integer.parseInt(input3);

      String input4 = req.queryParams("input4").replaceAll("\\s","");

      int input4AsInt = Integer.parseInt(input4);


      boolean result = App.search2(inputList2, inputList,  input3AsInt, input4AsInt);


     Map map = new HashMap();

      map.put("result", result);

      return new ModelAndView(map, "compute.mustache");

    }, new MustacheTemplateEngine());



    get("/compute",

        (rq, rs) -> {

          Map map = new HashMap();

          map.put("result", "not computed yet!");

          return new ModelAndView(map, "compute.mustache");

        },

        new MustacheTemplateEngine());

}


static int getHerokuAssignedPort() {

    ProcessBuilder processBuilder = new ProcessBuilder();

    if (processBuilder.environment().get("PORT") != null) {

        return Integer.parseInt(processBuilder.environment().get("PORT"));

    }


    return 4567; //return default port if heroku-port isn't set (i.e. on localhost)

}

}
