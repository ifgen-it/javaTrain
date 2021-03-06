// package acmp;

import java.util.*;

public class RightDown165 {

  public static void main(String[] args) {
   
   int N, M;
   
  
   Scanner sc = new Scanner(System.in);
   N = sc.nextInt(); M = sc.nextInt();
   
   
   // N = 4; M = 5;
   
   int[][] W = new int[N][];
   
   /*
   W[0] = new int[]{ 2,0,2,0,0 };
   W[1] = new int[]{ 0,0,0,0,0 };
   W[2] = new int[]{ 2,0,1,0,0 };
   W[3] = new int[]{ 0,0,2,0,0 };
   */
   
   for(int i=0; i<N; i++){
   W[i] = new int[M];
     for(int j=0; j<M; j++){
       W[i][j] = sc.nextInt();
     }
   }
   
   
   W[N-1][M-1] = 1;
   
   int[][] path = new int[N][];
   for(int i=0; i<N; i++){
   path[i] = new int[M];
     for(int j=0; j<M; j++){
       path[i][j] = 0;
     }
   }
   path[0][0] = 1;
   
    //  cout(W);
    //  System.out.println();
    //  cout(path);
   
   for(int i=0; i<N; i++){
   
     for(int j=0; j<M; j++ ){
       if(path[i][j]>0 && W[i][j]>0){
         int jJump = j + W[i][j];
         if(jJump < M){
           path[i][jJump] += path[i][j];
         }
       }
     } 
     
     for(int j=0; j<M; j++){
       if(path[i][j]>0 && W[i][j]>0){
         int iJump = i + W[i][j];
         if(iJump < N){
           path[iJump][j] += path[i][j];
         }
       }
     }
     
   }
  
     // System.out.println();
     // cout(path);
    System.out.println(path[N-1][M-1]);
    
   
   
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
                                                                                                                                                                                                                                                                                                                                                                                                    