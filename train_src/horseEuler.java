package train;

public class horseEuler {

  public static void main(String[] args) {
   
   int cost = 1770;
   int horsePrice = 31;
   int bullPrice = 21;
   
   System.out.println("cost="+cost+" horsePrice="+horsePrice +" bullPrice="+ bullPrice + "\n");
   
   int limitHorse = (int)((double)cost/horsePrice);
   int limitBull = (int)((double)cost/bullPrice);
   //System.out.println(limitHorse + " " + limitBull);
   
   for(int h=0;h<=limitHorse;h++){
     for(int b=0;b<limitBull;b++){
       int sum = h*horsePrice + b*bullPrice;
       if(sum == cost)
       System.out.println("horses=" + h + " bulls=" + b);
     }
   }
  }
}
