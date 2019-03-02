package yandex;

import java.io.*;
import java.util.Scanner;
import java.util.*;


public class taskAppoint {

  public static class Time implements Comparable<Time>{
    
    private int hours;
    private int mins;
    
    public int getFullMins(){
      return hours*60+mins;
    }
    
    public Time(){
      hours = 0;
      mins = 0;
    }
    
    @Override
    public int compareTo(Time other){
      
      int res = 0;
      if(hours<other.hours){
      res = -1; }
      else if(hours>other.hours){
      res = 1; }
      else{
        if(mins == other.mins) res = 0;
        else if(mins<other.mins) res = -1;
        else res = 1;
      }
      return res;
    }
    
    public Time(String time){
      String[] strTime = time.split(":");
      hours = Integer.valueOf(strTime[0]);
      mins = Integer.valueOf(strTime[1]);
    }
    
    @Override
    public String toString(){
      String res = "";
      if(hours < 10) res += "0";
      res += hours + ":";
      if(mins<10) res += "0";
      res += mins;
      return res;
      
    }
  }
  
  public static class Appoint implements Comparable<Appoint> {
    
    private int day;
    private Time time;
    private int duration;
    private int k;
    private ArrayList<String> names;
    
    public int getDay(){
      return day;
    }
    
    public Appoint(int Day, Time T, int Dur, int K, ArrayList<String> N){
      day = Day;
      time = T;
      duration = Dur;
      k = K;
      names = N;
    }
    
    @Override
    public int compareTo(Appoint other){
      return time.compareTo(other.time);
    }
    
    public boolean equalDay(Appoint other){
      if(other.day == day) return true;
      else return false;
    }
    
    public boolean intersectTime(Appoint other){
    
    int t1 = time.getFullMins();
    int t2 = t1 + duration;
    int to1 = other.time.getFullMins();
    int to2 = to1 + other.duration;
    
    if(t1 >= to1 && t1 < to2) return true;
    if(t2 > to1 && t2 <= to2) return true;
    if(to1 >= t1 && to1 < t2) return true;
    
      
      return false;
    }
    
    @Override
    public String toString(){
      String res = day + " " + time + " " +  duration + " " + k;
    for(String n : names){
      res += " " + n;
    }
    return res;
    }
    
     public String info(){
      String res = time + " " +  duration;
    for(String n : names){
      res += " " + n;
    }
    return res;
    }
    
    public ArrayList<String> getListNames(){
      return names;
    }
    
    public String getNames(){
      String res = "";
      for(String n : names){
      res += n + " ";
    }
    return res;
    }
  }
  
  private static ArrayList<Appoint> apps = new ArrayList<Appoint>();

  public static void main(String[] args) {

  int n = -1;
  ArrayList<String> inStr = new ArrayList<String>();
  
    try {
      String path = "/storage/8765-4321/_Avalon/4Term/yandex/input/task2.txt";

      FileReader fr = new FileReader(path);
      Scanner sc = new Scanner(fr);
      
      n = Integer.valueOf(sc.nextLine());
      System.out.println("input:");
      System.out.println(n);
      
      for(int i=0;i<n;i++){
   
      inStr.add(sc.nextLine());
      }
      
      sc.close();
      for(int i=0;i<inStr.size();i++){
        System.out.println(inStr.get(i));
        }
      
      
      fr.close();


    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    
    

  // decision
  System.out.println("\noutput:");
  
 // String str = inStr.get(0);
 for(String str : inStr){
 String[] strAr = str.split(" ");
 
 
   String res = "";
   
   if(strAr[0].equals("APPOINT")){
     //res = appoint("1");
     int day = Integer.valueOf(strAr[1]);
     Time time = new Time(strAr[2]);
     int duration = Integer.parseInt(strAr[3]);
     int k = Integer.valueOf(strAr[4]);
     ArrayList<String> names = new ArrayList<String>();
     for(int i = 0;i<k;i++){
       names.add(strAr[5+i]);
     }
     
     Appoint app = new Appoint(day, time, duration, k, names);
     res = appoint(app);
     
   }
   else{
     res = print(Integer.parseInt(strAr[1]), strAr[2]);
   }
 
 System.out.print(res);
 }
 
    
   
  }
  
  private static String appoint(Appoint app)     
  {
    
    for(Appoint a : apps){
      if(app.equalDay(a) && app.intersectTime(a)){
        String res = "FAIL\n";
        res += app.getNames().trim() + "\n";
        return res;
      }
    }
    
    apps.add(app);
    return "OK\n";
    
  }
  
  private static String print(int day, String name){
    
    
    ArrayList<Appoint> partApps = new ArrayList<Appoint>();
    
    for(Appoint a : apps){
      if(a.getDay() == day && a.getListNames().contains(name)){
        partApps.add(a);
      }
    }
    
    Collections.sort(partApps);
    
    String res = "";
    for(Appoint a : partApps){
      res += a.info() + "\n";
    }
    
    return res;
  }
  
}
