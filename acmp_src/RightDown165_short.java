import java.util.*;

public class RightDown165 {

  public static void main(String[] args) {

   int N, M;
   Scanner sc = new Scanner(System.in);
   N = sc.nextInt(); M = sc.nextInt();
  
   int[][] W = new int[N][];
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
    System.out.println(path[N-1][M-1]);
   }
}
                                                                                                                                                                                                                                                                                                                                                                                                    