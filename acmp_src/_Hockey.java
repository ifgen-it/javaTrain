// package acmp;

import java.util.*;

public class Hockey {

  public static void main(String[] args) {
   
  // int n = 20;
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   
   int gold = n;
   int silver = n-1 < 1? 1 : n-1;
   int bronze = n-2 < 1? 1 : n-2;
   
   
   long res = gold*silver*bronze;
   System.out.println(res);
  }
}
