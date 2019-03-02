package train;

public class Combinations {

  private static int ptr;
  private static int n;
  private static int ptrMax;
  private static int k;
  public static void main(String[] args) {
   
   n = 6;
   k = 4;
   ptr = k-1;
   ptrMax = n;
   
   int[] w = new int[n];
   for(int i=0;i<n;i++){
     w[i]=i+1;
   }
   cout(0, w);
   System.out.println();
   
   int[] c = new int[k];
   for(int i=0;i<k;i++){
     c[i]=w[i];
   }
   int cnt = 1;
   cout(cnt, c);
   
   while(next(c)){
     cout(++cnt, c);
   }
   
   
  }
  
  
  private static boolean next(int[] c){
    
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
  
  private static void cout(int cnt, int[] c){
    System.out.printf("%2d : ", cnt);
    for(int e : c){
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
