

import java.util.*;

public class summa398 {

  public static void main(String[] args) {
   
   // int x = 400;
   
  Scanner sc = new Scanner(System.in);
  int x = sc.nextInt();
   
   int a, b, c, d;
   int res = 0;
   for(a=1;a <= x ;a++){
     for(b=a;b <= x ;b++){
       for(c=b;c <= x;c++){
         d = x - a-b-c;
         if(c>d) break;
         int sum = a+b+c+d;
         if(sum == x) res++;
         
       }
     }
   }
   System.out.println(res);
  }
}
                                                                                                                                            