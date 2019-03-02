
import java.io.*;
import java.util.*;

public class dedMoroz {

  public static void main(String[] args) {
   
   Scanner sc = new Scanner(System.in);
   
   
   int iris = sc.nextInt();       
   int mandarin = sc.nextInt();   
   int pryanik = sc.nextInt();   
   int batch = sc.nextInt(); 
   
   /*
   int iris = 10;
   int mandarin = 25;
   int pryanik = 15;
   int batch = 40;
   */

   sc.close();
   int limIris = (int)((double)batch/iris);
   
   int res = 0;
   
   for(int i=0;i<=limIris;i++){
     int limMandarin = (int)((double)(batch - i*iris)/mandarin);
     for(int m=0;m<=limMandarin;m++){
       int limPryanik = (int)((double)(batch - i*iris - m*mandarin)/pryanik);
       for(int p=0;p<=limPryanik;p++){
         int sum = i*iris + m*mandarin + p*pryanik;
         if(sum == batch) res++;
       }
     }
   }
   
   System.out.println(res);
   
  }
}
