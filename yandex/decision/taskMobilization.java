
package yandex;

import java.io.*;
import java.util.*;


public class taskMobilization {

  
  private static int n = -1;
  private static int[] dev;
  private static int[] man;
  private static int[][] sert;
  
  private static int[] diff;
  private static int[] newDev;
  private static int[] newMan;
  

  public static void main(String[] args) {
  
    try {
      String path = "/storage/8765-4321/_Avalon/4Term/yandex/input/task6_1.txt";

      FileReader fr = new FileReader(path);
      Scanner sc = new Scanner(fr);
      
      n = sc.nextInt();
      dev = new int[n];
      man = new int[n];
      
      for(int i=0; i<n; i++){
        dev[i] = sc.nextInt();
      }
      for(int i=0; i<n; i++){
        man[i] = sc.nextInt();
      }
      
      int m = sc.nextInt();
      sert = new int[m][];
      for(int i=0; i<m; i++){
        sert[i] = new int[3];
        sert[i][0] = sc.nextInt();
        sert[i][1] = sc.nextInt();
        sert[i][2] = sc.nextInt();
      }
      
      System.out.println("input:");
      System.out.println(n);
      
      //skills
      for(int e : dev){
        System.out.print(e+ " ");
      }
      System.out.println();
      for(int e : man){
        System.out.print(e+ " ");
      }
      System.out.println();
      
      //sertificates
      System.out.println(m);
      for(int[] row : sert){
        for(int e : row){
          System.out.print(e+" ");
        }
        System.out.println();
      }
      
      sc.close();
      
      fr.close();


    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    
    

  // decision
  System.out.println("\noutput:");
  
  
for(int iter = 0; iter < sert.length; iter++){
  int sumSkills = 0;
  System.out.println("iter : " + iter);
  int num = sert[iter][0] - 1;
  int addSkill = sert[iter][2];
  int type = sert[iter][1];
  if(type == 1){
    dev[num] += addSkill;
  }
  else{
    man[num] += addSkill;
  }
  
  cout(dev); cout(man);
  System.out.println();
  
  diff = new int[n];
  for(int i=0; i<n; i++){
    diff[i] = dev[i] - man[i];
  }
  newDev = dev.clone();
  newMan = man.clone();
  
  sortDiffDevMan();
  cout(diff);
  cout(newDev);
  cout(newMan);
  
  for(int i=0; i< n/2; i++){
    sumSkills += newDev[i];
    sumSkills += newMan[n-1-i];
  }
  System.out.println(sumSkills + "\n");
  
}
  
  
  
  
  }
  
  private static void cout(int[] ar){
    for(int e : ar){
      System.out.print(e+ " ");
    }
    System.out.println();
  }
  
  private static void swap(int[] ar, int i1, int i2){
    int temp = ar[i1];
    ar[i1] = ar[i2];
    ar[i2] = temp;
  }
  
  private static void sortDiffDevMan(){
    
    for(int i=0; i<n; i++){
      int max = diff[i];
      int maxInd = i;
      for(int j=i+1; j<n; j++){
        if(diff[j] > max){
          max = diff[j];
          maxInd = j;
        }
      }
      if(maxInd != i){
        swap(diff, i, maxInd);
        swap(newDev, i, maxInd);
        swap(newMan, i, maxInd);
      }
    }
  }
  
}
