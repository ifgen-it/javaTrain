// package acmp;

import java.util.*;

public class BiologyDNK278 {

  public static void main(String[] args) {
 //   String s = "GTA";
  //  String t = "AGTCA";
   
   Scanner sc = new Scanner(System.in);
   String s = sc.next();
   String t = sc.next();
   
   char[] S = s.toCharArray();
   char[] T = t.toCharArray();
   
   if(isContains(S, T)){
     System.out.println("YES");
   }
   else{
     System.out.println("NO");
   }
  
  }
  
  private static boolean isContains(char[] S, char[] T){
    int ptr = 0;
    for(int i=0; i<S.length; i++){
      char sym = S[i];
      boolean found = false;
      for(int j=ptr; j<T.length; j++){
        if(T[j] == sym){
          ptr = j+1;
          found = true;
          break;
        }
      }
      if(!found) return false;
    }
    
    return true;
  }
}
