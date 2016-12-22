/**
 * Created by User on 06.11.2016.
 */
package com.company;

import java.io.*;
import java.util.*;

public class SETS {
    public static void main(String[] args) throws ArithmeticException, IOException, NullPointerException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // String[] s = reader.toString().split(" ");
        TreeMap<String,ArrayList> v = new TreeMap<>();
        boolean ex = true;
        long time = 0,endTime;
        while (ex){
            String[] s = reader.readLine().toString().split(" ");

            switch (s[0]){

                case "new":
                    if(s.length>=2){
                        v.put(s[1],new ArrayList());
                        System.out.println("Set created");
                }
                    else {
                        System.out.println("Enter name of the collection");
                    }

                    break;

                case "add":
                    if (s.length>=3 && v.containsKey(s[1])){
                        if (v.get(s[1]).contains(s[2])) System.out.println("Element already exists");
                        else{
                        v.get(s[1]).add(s[2]);
                        System.out.println("Element added");}
                }
                    else {
                        System.out.println("Set or element is not presented");
                    }
                    break;
                case "addAll":
                    if (s.length>=3 && v.containsKey(s[1])){
                        String[] p= s[2].split(":");
                        //int r= (Integer.parseInt(p[2]) - Integer.parseInt(p[0]))/Integer.parseInt(p[1]) +1;
                        //System.out.println("Please enter " + r + " elements");
                        for (int i = Integer.parseInt(p[0]); i < Integer.parseInt(p[2]); i+=Integer.parseInt(p[1]))
                        {
                            //String ch =reader.readLine();
                            if (v.get(s[1]).contains(i)) continue;
                            else v.get(s[1]).add(i);
                        }
                        System.out.println("Elements added");}
                    else {
                        System.out.println("Set or elements are not presented");
                    }
                    break;
                case "del": //от тут 2 варианта del
                    if (s.length>=2 && v.containsKey(s[1])){
                        if (s.length==3)
                        {v.get(s[1]).remove(s[2]);
                            System.out.println("Element deleted");}
                        else
                        {
                            v.remove(s[1]);
                            System.out.println("Set deleted");}
                    }
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }

                    break;
                case "union":
                  if(s.length>=3&& v.containsKey(s[1])&& v.containsKey(s[2])){
                   if  (s.length==4)
                       v.put(s[3],union(v.get(s[1]),v.get(s[2])));
                    else System.out.println(union(v.get(s[1]),v.get(s[2])));}
                  else {
                      System.out.println("One or more of elements is lost or not created");
                  }
                    break;
                case "intersec":

                    if (s.length>=3 && v.containsKey(s[1])&& v.containsKey(s[2])){
                        if  (s.length==4)
                            v.put(s[3],intersect(v.get(s[1]),v.get(s[2])));
                        else System.out.println(intersect(v.get(s[1]),v.get(s[2])));
                    }
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }

                    break;
                case "diff":
                    if (s.length>=3 && v.containsKey(s[1])&& v.containsKey(s[2])){
                        if  (s.length==4)
                            v.put(s[3],difference(v.get(s[1]),v.get(s[2])));
                        else System.out.println(difference(v.get(s[1]),v.get(s[2])));
                    }
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }

                    break;
                case "simmdiff":

                    if (s.length>=3 && v.containsKey(s[1])&& v.containsKey(s[2])){
                        if  (s.length==4)
                            v.put(s[3],simmDifference(v.get(s[1]),v.get(s[2])));
                        else System.out.println(simmDifference(v.get(s[1]),v.get(s[2])));
                    }
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }


                    break;
                case "show":
                    if(s.length>=2 && v.containsKey(s[1]))System.out.println(s[1] + " = " + v.get(s[1]));
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }
                    break;
                case "showall":

                    if(s.length>=1)
                        for (Map.Entry<String,ArrayList> e: v.entrySet())
                    {
                        System.out.println(e.getKey() + " = " + e.getValue());
                    }
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }
                    break;

                case "exit":

                    ex = false;
                    break;

                case "isin":
                    if(s.length>=3 && v.containsKey(s[1])){
                    if (v.get(s[1]).contains(s[2]))
                        System.out.println("Element exists");
                    else System.out.println("Element does not exists");}
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }
                    break;
                case "contains":

                    if (s.length>=3 && v.containsKey(s[1])&& v.containsKey(s[2])){
                        if(v.get(s[1]).containsAll(v.get(s[2])))
                            System.out.println("Set contains");
                        else System.out.println("Set does not contains");
                    }
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }

                    break;
                case "exist":
                    if (s.length>=2){
                        if(v.containsKey(s[1]))
                            System.out.println("Set exists");
                        else System.out.println("Set does not exists");
                    }
                    else {
                        System.out.println("One or more of elements is lost or not created");
                    }

                    break;
                case "tic":
                    time = System.currentTimeMillis();
                    System.out.println("Start counting time");
                    break;
                case "toc":
                    endTime = System.currentTimeMillis();
                    int t = (int)((endTime-time)/1000);
                    System.out.println(t + " seconds");
                    break;
                case "open":
                {
                    BufferedReader br = new BufferedReader(new FileReader(s[1]));
                        //StringBuilder sb = new StringBuilder();
                        //String line = br.readLine();
                    long time1 = 0,endTime1=0;
                    String[] s1;String s2;
                    while((s2 = br.readLine()) != null){
                        s1=s2.toString().split(" ");
                    switch (s1[0]){

                    case "new":
                        if(s1.length>=2){
                        v.put(s1[1],new ArrayList());
                        System.out.println("Set created");
                        }
                        else {
                            System.out.println("Enter name of the collection");
                        }
                        break;

                    case "add":

                        if (s1.length>=3 &&v.containsKey(s1[1])){
                            if (v.get(s1[1]).contains(s1[2])) System.out.println("Element already exists");
                            else{
                                v.get(s1[1]).add(s1[2]);
                                System.out.println("Element added");} }
                        else {
                            System.out.println("Set or element is not presented");
                        }

                        break;
                    case "addAll":
                        if (s1.length>=3 && v.containsKey(s1[1])){
                            String[] p= s1[2].split(":");
                           // int r= (Integer.parseInt(p[2]) - Integer.parseInt(p[0]))/Integer.parseInt(p[1])+1;
                          //  System.out.println("Please enter " + r + " elements");
                            for (int i = Integer.parseInt(p[0]); i < Integer.parseInt(p[2]); i+=Integer.parseInt(p[1]))
                            {
                                //String ch =reader.readLine();
                                if (v.get(s1[1]).contains(i)) continue;
                                else v.get(s1[1]).add(i);
                            }
                            System.out.println("Elements added");}
                        else {
                            System.out.println("Set or element is not presented");
                        }
                        break;
                    case "del": //от тут 2 варианта del
                        if (s1.length>=2 && v.containsKey(s1[1])){
                        if (s1.length==3)
                        {v.get(s1[1]).remove(s1[2]);
                            System.out.println("Element deleted");}
                        else
                        {
                            v.remove(s[1]);
                            System.out.println("Set deleted");}
                        }
                        else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "union":
                        if(s1.length>=3&& v.containsKey(s1[1])&& v.containsKey(s1[2])) {
                            if (s1.length == 4)
                                v.put(s[3], union(v.get(s1[1]), v.get(s1[2])));
                            else System.out.println(union(v.get(s1[1]), v.get(s1[2])));
                        }   else {
                                System.out.println("One or more of elements is lost or not created");
                            }
                        break;
                    case "intersec":
                        if (s1.length>=3 && v.containsKey(s1[1])&& v.containsKey(s1[2])){
                        if  (s1.length==4)
                            v.put(s[3],intersect(v.get(s1[1]),v.get(s1[2])));
                        else System.out.println(intersect(v.get(s1[1]),v.get(s1[2])));
                        }
                        else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "diff":
                        if (s1.length>=3 && v.containsKey(s1[1])&& v.containsKey(s1[2])){
                        if  (s1.length==4)
                            v.put(s[3],difference(v.get(s1[1]),v.get(s1[2])));
                        else System.out.println(difference(v.get(s1[1]),v.get(s1[2])));
                        }
                        else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "simmdiff":
                        if (s1.length>=3 && v.containsKey(s1[1])&& v.containsKey(s1[2])){
                        if  (s1.length==4)
                            v.put(s1[3],simmDifference(v.get(s1[1]),v.get(s1[2])));
                        else System.out.println(simmDifference(v.get(s1[1]),v.get(s1[2])));
                        }
                        else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "show":
                        if(s1.length>=2 && v.containsKey(s1[1])) System.out.println(s1[1] + " = " + v.get(s1[1]));
                        else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "showall":
                        if(s1.length>=1)
                            for (Map.Entry<String,ArrayList> e: v.entrySet())
                        {
                            System.out.println(e.getKey() + " = " + e.getValue());
                        }
                    else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "exit":

                        ex = false;
                        break;

                    case "isin":
                        if(s1.length>=3 && v.containsKey(s1[1])){
                        if (v.get(s1[1]).contains(s1[2]))
                            System.out.println("Element exists");
                        else System.out.println("Element does not exists");}
                        else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "contains":
                        if (s1.length>=3 && v.containsKey(s1[1])&& v.containsKey(s1[2])){
                        if(v.get(s1[1]).containsAll(v.get(s1[2])))
                            System.out.println("Set contains");
                        else System.out.println("Set does not contains");
                        }
                        else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "exist":
                        if (s1.length>=2){
                        if(v.containsKey(s1[1]))
                            System.out.println("Set exists");
                        else System.out.println("Set does not exists");
                        }
                        else {
                            System.out.println("One or more of elements is lost or not created");
                        }
                        break;
                    case "tic":
                        time1 = System.currentTimeMillis();

                        break;
                    case "toc":
                        endTime1 = System.currentTimeMillis();
                        System.out.println((endTime1-time1)/1000 + " seconds");
                        break;
                    default: System.out.println("Incorrect entry,please type in accordance with the task");
                }}}
                    break;

                default: System.out.println("Incorrect entry,please type in accordance with the task");
            }
        }

    }
    public static ArrayList<String> union(ArrayList<String> a,ArrayList<String> b){
        ArrayList<String> tmp = new ArrayList<String>(a);
        for (String t : b)
              {
                  if (tmp.contains(t)) continue;
                  else tmp.add(t);}
                  return tmp;
    }
    public static ArrayList<String> intersect(ArrayList<String> a,ArrayList<String> b){
        ArrayList<String> tmp = new ArrayList<String>();
        for (String  x : a)
            if (b.contains(x))
                tmp.add(x);
return tmp;
    }
    public static ArrayList<String> difference(ArrayList<String> a,ArrayList<String> b){
        ArrayList<String> tmp = new ArrayList<String>(a);
        tmp.removeAll(b);
return tmp;
    }
    public static ArrayList<String> simmDifference(ArrayList<String> a,ArrayList<String> b){
      ArrayList<String> tmpA = new ArrayList<String>();
        ArrayList<String> tmpB = new ArrayList<String>();
        tmpA = union(a,b);
        tmpB = intersect(a,b);
return difference(tmpA,tmpB);

    }
}
