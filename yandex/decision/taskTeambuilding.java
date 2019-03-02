
package yandex;

import java.io.*;
import java.util.*;


public class taskTeambuilding {

  private static class Vertex {
    
    private int vert;
    private ArrayList<Integer> adj;
    private int team;
    
    public void setTeam(int T){
      team = T;
    }
    
    public boolean isAdjacent(int v){
      if(adj.contains(Integer.valueOf(v)))
      return true;
      return false;
    }
    
    public Vertex(int V){
      vert = V;
      adj = new ArrayList<Integer>();
      team = 0;
    }
    
    public void addAdj(int adjVert){
      adj.add(Integer.valueOf(adjVert));
    }
    
    @Override
    public String toString(){
      return "v:"+vert+ " t:"+team + " adj:"+ adj;
    }
    
    
    
  }
  
  private static int[][] edges;
  private static ArrayList<Integer> team1 = new ArrayList<Integer>();
  
  private static ArrayList<Integer> team2 = new ArrayList<Integer>();
  private static ArrayList<Integer> teamTemp = new ArrayList<Integer>();
  
  private static int tempSize = -1;
  
  private static ArrayList<Vertex> graf = new ArrayList<Vertex>();

  public static void main(String[] args) {

  int nVert = -1;
  int nEdge = -1;
 // int[][] edges;
  
    try {
      String path = "/storage/8765-4321/_Avalon/4Term/yandex/input/task4_1.txt";

      FileReader fr = new FileReader(path);
      Scanner sc = new Scanner(fr);
      
      nVert = sc.nextInt();
      nEdge = sc.nextInt();
      edges = new int[nEdge][2];
      
      System.out.println("input:");
      System.out.println(nVert + " " + nEdge);
      
      for(int i=0;i < nEdge;i++){
        edges[i][0] = sc.nextInt();
        edges[i][1] = sc.nextInt();
      }
      
      sc.close();
      
      for(int i=0;i < nEdge;i++){
        System.out.println(edges[i][0] + " " + edges[i][1]);
        }
      
      
      fr.close();


    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    
    

  // decision
  System.out.println("\noutput:");
  
  
  for(int i=0; i < nVert; i++){
    graf.add(new Vertex(i+1));
  }
  
  for(int i=0; i < nEdge; i++){
    int v1 = edges[i][0];
    int v2 = edges[i][1];
    
    graf.get(v1-1).addAdj(v2);
    graf.get(v2-1).addAdj(v1);
  }
  
  System.out.println(graf);
  System.out.println(makeTeams());
  System.out.println(graf + "\n");
  System.out.println("team1: " + team1);
  System.out.println("team2: " + team2);
  
  }
  
  private static boolean makeTeams(){
    
    graf.get(0).setTeam(1);
    team1.add(Integer.valueOf(1));
    
    for(int i=1; i < graf.size(); i++){
      
      boolean tRes1 = isTeamer(team1, i+1);
      boolean tRes2 = isTeamer(team2, i+1);
      if(tRes1 && tRes2){
        teamTemp.add(Integer.valueOf(i+1));
      }
      else if(tRes1){
        graf.get(i).setTeam(1);
        team1.add(Integer.valueOf(i+1));
      }
      else if(tRes2){
        graf.get(i).setTeam(2);
        team2.add(Integer.valueOf(i+1));
      }
      else return false;
    }
    
    while(true){
      boolean recur = pushTemp();
      if(!recur) return false;
      if(tempSize == 0) break;
    }
    
    
    return true;
  }
  
  private static boolean pushTemp(){
    ArrayList<Integer> thisTeamTemp = (ArrayList<Integer>)teamTemp.clone();
    
    teamTemp = new ArrayList<Integer>();
    
    boolean pushAll = false;
    if(tempSize > 0 && tempSize == thisTeamTemp.size()){
      pushAll = true;
    }
    
    for(Integer v : thisTeamTemp){
      
      boolean tRes1 = isTeamer(team1, v);
      boolean tRes2 = isTeamer(team2, v);
      if(tRes1 && tRes2 && !pushAll){
        teamTemp.add(Integer.valueOf(v));
      }
      else if(tRes1){
        graf.get(v-1).setTeam(1);
        team1.add(Integer.valueOf(v));
      }
      else if(tRes2){
        graf.get(v-1).setTeam(2);
        team2.add(Integer.valueOf(v));
      }
      else return false;
    }
    
    tempSize = teamTemp.size();
    return true;
  }
  
  private static boolean isTeamer(ArrayList<Integer> team, int teamer){
    for(Integer v : team){
      boolean res = graf.get(v-1).isAdjacent(teamer);
      if(res == false) return false;
    }
    return true;
  }
  
  
}
