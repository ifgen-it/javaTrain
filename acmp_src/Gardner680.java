// package acmp;

import java.util.*;

public class Gardner680 {

  public static void main(String[] args) {
   
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   
   long[] res = new long[n];
   res[0] = 3;
   for(int i = 1; i<n; i++){
     res[i] = res[i-1]*2;
   }
   System.out.println(res[n-1]);
   
  }
}
