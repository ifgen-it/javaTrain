package yandex;

import java.io.*;
import java.util.Scanner;
import java.util.*;


public class taskError {

  public static void main(String[] args) {

  int n = -1;
    try {
      String path = "/storage/8765-4321/_Avalon/4Term/yandex/input/task1.txt";

      FileReader fr = new FileReader(path);
      Scanner sc = new Scanner(fr);
      
      n = sc.nextInt();
      System.out.println("input:");
      System.out.println(n);
      ArrayList<Integer> a = new ArrayList<Integer> ();
      ArrayList<Integer> b = new ArrayList<Integer>();
      for(int i=0;i<n;i++){
      Integer x = new Integer(sc.nextInt());
      a.add(x);
      b.add(new Integer(sc.nextInt()));
      }
      
      sc.close();
      for(int i=0;i<a.size();i++){
        System.out.print(a.get(i)+" ");
        System.out.println(b.get(i));
        }
      
      
      fr.close();


  // decision
    ArrayList<Double> pp = new ArrayList<Double>();
    
    double sum = 0;
    for(int i=0;i<a.size();i++){
      sum += (double)a.get(i)*b.get(i);
    }
    
    for(int i=0;i<a.size();i++){
      double p = (double)a.get(i)*b.get(i) / sum;
      pp.add(new Double(p));
      System.out.printf("%.12f\n", pp.get(i));
    }
    
    
    

    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    
  
    
  }
}
