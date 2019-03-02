package train;

import java.util.*;

public class Permutations {

  public static int[] w;
  public static int cnt = 0;
  
  public static void main(String[] args) {
    
    w = new int[]{1,2,3,4,5,6,7,8,9,10};
    int n = w.length;
   
    perm(w,n-1);
    
    System.out.println(cnt);
    
  }
  
  public static void perm(int[] ar, int k){
  
  if(k == 1){
    //cout(ar);
    cnt++;
    int[] a = ar.clone();
    int ind1 = a.length -1;
    int ind2 = a.length -2;
    int temp = a[ind1];
    a[ind1] = a[ind2];
    a[ind2] = temp;
    //cout(a);
    cnt++;
  }
  
  else if(k > 1){
    
    perm(ar, k-1);
    int[] a = ar.clone();
    for(int i=0;i< k;i++){
      int my = a.length - k -1;
      int temp = a[my];
      for(int j=0;j< k;j++){
        a[my+j] = a[my+j+1];
      }
      int last = a.length -1;
      a[last] = temp;
      perm(a, k-1);
    }
  }
  
  }
  
  private static void cout(int[] ar){
    for(int e : ar){
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
