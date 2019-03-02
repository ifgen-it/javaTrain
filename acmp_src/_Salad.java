// package acmp;

import java.util.*;

public class Salad {

  public static void main(String[] args) {
   
   //  int N = 20;
  
  
   Scanner sc = new Scanner(System.in);
   int N = sc.nextInt();
   
   
   long n = N - 1;
   long k = 2;
   
   long res = 0;
   long nomin = N;
   long denomin = 1;
   
   
   for(int i=0; i < N-1; i++){
     nomin = nomin * n;
     denomin = denomin * k;
     res += nomin / denomin;
     n--; k++;
   }
   
   
   /*
   for(int i=0; i < N-1; i++){
     
     res += fact(N) /( fact(k) * fact(N-k));
     k++;
   }
   */
   
  System.out.println(res);
   
  }
  
  private static long fact(int x){
    long res = 1;
    for(int i = 2; i <= x; i++){
      res = res*i;
    }
    return res;
  }
}
