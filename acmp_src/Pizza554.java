// package acmp;

import java.util.*;

public class Pizza554 {

  public static void main(String[] args) {
   
   //int n = 2;
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   
   int[] res = new int[n];
   res[0] = 2;
   int inc = 2;
   for(int i = 1; i<n; i++){
     res[i] = res[i-1] + inc++;
   }
   System.out.println(res[n-1]);
  }
}

