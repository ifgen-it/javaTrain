

package yandex;

import java.io.*;
import java.util.*;


public class taskLibrary {

  
  private static int k = -1;
  private static int m = -1;
  private static int d = -1;
  

  public static void main(String[] args) {
  
    try {
      String path = "/storage/8765-4321/_Avalon/4Term/yandex/input/task5_2.txt";

      FileReader fr = new FileReader(path);
      Scanner sc = new Scanner(fr);
      
      k = sc.nextInt();
      m = sc.nextInt();
      d = sc.nextInt();
      
      System.out.println("input:");
      System.out.println(k + " " + m + " " + d);
      
      
      sc.close();
      
      fr.close();


    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    
    

  // decision
  System.out.println("\noutput:");
  
  int readDay = getMaxDaySeq();
  System.out.println(readDay);
  
  }
  
  private static int getMaxDaySeq(){
    int day = d;
    int homeBooks = m;
    int libBooks = k;
    
    int normBooks = 1;
    int readBooks = 0;
    int fundBooks = homeBooks;
    boolean libWorks = false;
    int readDay = 0;
    
    while(true){
      if(day==6 || day==7) libWorks = false;
      else libWorks = true;
      
      if(libWorks) fundBooks += libBooks;
      
      if(fundBooks >= normBooks){
        readBooks += normBooks;
        fundBooks -= normBooks;
        normBooks++;
        readDay++;
        if(++day == 8) day = 1;
        
      }
      else break;
    }
    return readDay;
  }
  
}
