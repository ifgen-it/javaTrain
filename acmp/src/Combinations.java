/*
https://acmp.ru/index.asp?main=task&id_task=71

Две кучки камней
(Время: 1 сек. Память: 16 Мб Сложность: 43%)
У Вас есть N камней с массами W1, W2 , … WN. Требуется разложить камни на 2 кучки так, чтобы разница масс этих кучек была минимальной.

Входные данные
В первой строке входного файла INPUT.TXT записано число N – количество камней (1 ≤ N ≤ 18). Во второй строке через пробел перечислены массы камней W1, W2 , … WN (1 ≤ Wi ≤ 105).

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно неотрицательное целое число – минимально возможную разницу между массами двух кучек.

Пример
№   INPUT.TXT       OUTPUT.TXT
1   5
    5 8 13 27 14    3

*/

// package train;

import java.util.*;

public class Combinations {

  private static int ptr;
  private static int n;
  private static int ptrMax;
  private static int sumW;
  private static int[] w;
  private static int min;
  
  public static void main(String[] args) {
  
   
//   Scanner sc = new Scanner(System.in);
//   n = sc.nextInt();
//   w = new int[n];
//   for(int i = 0; i<n; i++){
//     w[i] = sc.nextInt();
//   }
   
  
      w = new int[]{5,8,13,27,14};
      n = 5;
   
   sumW = sumAr(w);
   min = sumW;
   
  // cout(0, w);
   //System.out.println();
   //System.out.println(sumW);
   
   for(int k=1;k<=n/2 + 1; k++){
    // min = 100;
     combine(k);
    // System.out.println("k="+k+" min="+ min);
     }
     System.out.println(min);
  }
  
  private static void combine(int k){
    
    ptr = k-1;
    ptrMax = n;
   
    int[] c = new int[k];
   for(int i=0;i<k;i++){
     c[i] = i+1;
   }
   int cnt = 1;
    // cout(cnt, c);
    coutW(cnt, c);
   
   while(next(c, k)){
     cnt++;
      // cout(cnt, c);
     coutW(cnt, c);
    
   }
  }
  
  private static boolean next(int[] c, int k){
    
    while(true){
     
      if(c[ptr] < ptrMax){
        c[ptr]++;
        return true;
      }
      if(c[ptr] == ptrMax){
        if(ptr == 0) return false;
        
        if(c[ptr]-c[ptr-1] == 1){
          ptr--; ptrMax--; continue;
        }
        
        c[ptr-1]++;
        for(int i=ptr; i<k; i++){
          c[i] = c[i-1]+1;
        }
        ptr = k-1;
        ptrMax = n;
        return true;
      }
    }
     
  }
  
  private static int sumAr(int[] ar){
    int sum=0;
    for(int e : ar){
      sum += e;
    }
    return sum;
  }
  
  private static void cout(int cnt, int[] c){
    System.out.printf("%2d : ", cnt);
    for(int e : c){
      System.out.print(e + " ");
    }
    System.out.println();
  }
  
  private static void coutW(int cnt, int[] c){
    int sum1 = 0;
    // System.out.printf("%2d : ", cnt);
    for(int e : c){
     // System.out.print(w[e-1] + " ");
      sum1 += w[e-1];
    }
    int sum2 = sumW - sum1;
    int d = Math.abs(sum1-sum2);
    // System.out.println(" : "+ d);
    if(d<min) min = d;
  }
}
