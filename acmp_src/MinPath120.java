// package acmp;

import java.util.*;

public class MinPath120 {

  public static void main(String[] args) {
   
   int N, M;
  // int[][] W;
   Scanner sc = new Scanner(System.in);
   N = sc.nextInt(); M = sc.nextInt();
   
  // N = 3; M = 4;
   
   int[][] W = new int[N][];
   
   /*
   W[0] = new int[]{ 1, 1, 1, 1 };
   W[1] = new int[]{ 5, 2, 2, 100 };
   W[2] = new int[]{ 9, 4, 2, 1 };
   */
   
   for(int i=0; i<N; i++){
   W[i] = new int[M];
     for(int j=0; j<M; j++){
       W[i][j] = sc.nextInt();
     }
   }
   
   //cout(W);
   
   for(int j=1; j<M; j++){
       W[0][j] += W[0][j-1];
     }
   
   for(int i=1; i<N; i++){
     
     W[i][0] += W[i-1][0];
     for(int j=1;j<M;j++){
       int up = W[i][j] + W[i-1][j];
       int left = W[i][j] + W[i][j-1];
       W[i][j] = up<left? up : left;
     } 
   }
    
    
   
  
  
    //System.out.println();
   // cout(W);
    System.out.println(W[N-1][M-1]);
   }
  
  
  private static void cout(int[][] ar){
    
    for(int[] row : ar){
      for(int e : row){
        System.out.printf("%-3d ", e);
      }
      System.out.println();
    }
  }
}
