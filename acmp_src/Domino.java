// package acmp;

import java.util.*;

public class Domino {

  public static void main(String[] args) {
   
   
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   
   // int n = 2;
   
   long res = 0;
   for(int i = 1;i <= n;i++){
     res += i*(n+2);
   }
   
   System.out.println(res);
  }
}
