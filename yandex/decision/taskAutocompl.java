
package yandex;

import java.io.*;
import java.util.*;


public class taskAutocompl {


  public static void main(String[] args) {

  int n = -1;
  ArrayList<String> inStr = new ArrayList<String>();
  
    try {
      String path = "/storage/8765-4321/_Avalon/4Term/yandex/input/task3.txt";

      FileReader fr = new FileReader(path);
      Scanner sc = new Scanner(fr);
      
      n = Integer.valueOf(sc.nextLine());
      System.out.println("input:");
      System.out.println(n);
      
      for(int i=0;i<n;i++){
   
      inStr.add(sc.next());
      }
      
      sc.close();
      for(int i=0;i<inStr.size();i++){
        System.out.print(inStr.get(i) + " ");
        }
      
      
      fr.close();


    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    
    

  // decision
  System.out.println("\n\noutput:");
  
  TreeSet<String> words = new TreeSet<String>();
  
  int taps = inStr.get(0).length();
  words.add(inStr.get(0));
  
  TreeSet<String> test = new TreeSet<String>(inStr);
  
  //System.out.println(words.toString()+ taps);
  
  // System.out.println(test);
  TreeSet<String> tAlike = getTreeAlike(test, "ha");
  
  // System.out.println(tAlike + "\n");
  
  for(int i=1; i<n; i++){
    String word = inStr.get(i);
    TreeSet<String> wordTreeAlike = new TreeSet<String>();
    for(int c=1; c <= word.length(); c++){
      String begWord = word.substring(0, c);
      System.out.println(begWord);
      wordTreeAlike = getTreeAlike(words, begWord);
      
      if(wordTreeAlike.size() == 0 || wordTreeAlike.size() == 1 && !wordTreeAlike.first().equals(word) ){
        taps += word.length() - begWord.length() + 1;
        words.add(word);
        break;
      }
      
      if(wordTreeAlike.size() == 1 && wordTreeAlike.first().equals(word)){
        taps++;
        words.add(word);
        break;
      }
      
      taps++;
      
    }
    //System.out.println();
    System.out.println("taps = " + taps + "\n");
  }
  
  } //main
  
  private static TreeSet<String> getTreeAlike(TreeSet<String> tree, String mask){
    
  String beg = mask;
  String end = beg + "{";
  TreeSet tAlike = (TreeSet<String>)tree.subSet(beg, end);
  
  return tAlike;
  }
}
