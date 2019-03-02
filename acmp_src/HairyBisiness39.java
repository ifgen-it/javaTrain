// package acmp;

import java.util.*;

public class HairyBisiness39 {

  public static void main(String[] args) {
   
  // int N = 10;
   
   Scanner sc = new Scanner(System.in);
   int N = sc.nextInt();
   int[] C = new int[N];
   for(int i=0; i<N; i++){
     C[i] = sc.nextInt();
   }
   
  // int[] C = new int[]{10,9,8,7,6,5,4,3,2,1};
   
   int profit = 0;
   int startInd = 0;
   
   while(true){
     int maxInd = getMaxInd(C, startInd);
     profit += C[maxInd]*(maxInd-startInd+1);
     startInd = maxInd+1;
     if(startInd == C.length) break;
   }
   System.out.println(profit);
   
  }
  
  private static int getMaxInd(int[] ar, int beg){
    int max = ar[beg];
    int maxInd = beg;
    for(int i=beg+1; i<ar.length; i++){
      if(ar[i] > max){
        max = ar[i];
        maxInd = i;
      }
    }
    return maxInd;
  }
}
