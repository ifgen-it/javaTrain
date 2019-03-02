package train;

public class primeNum {

  public static void main(String[] args) {
   
   int n = 100000;
   int[] primes = new int[n];
   
   primes[0]=2;
   int ind = 1;
   for(int i = 3;;i++){
     if(isPrime(i)){
       primes[ind] = i;
       ind++;
       if(ind == n) break;
     }
   }
   /*
   System.out.println(n +" first prime numbers:\n" );
   int counter = 0;
   for(int num : primes){
     System.out.print(num + " ");
     counter++;
     if(counter%8 == 0)
     System.out.println();
   }
   */
   System.out.println(n + " prime number: " + primes[n-1]);
  }
  
  private static boolean isPrime(int num){
    for(int i=2;i <= Math.pow(num,0.5)+1;i++){
      if(num%i == 0) return false;
    }
    return true;
  }
}
