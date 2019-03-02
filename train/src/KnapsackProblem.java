import java.util.*;

public class KnapsackProblem {

    public static void main(String[] args) {

//        int n = 3;
//        int W = 6;
//        int[] w = new int[]{ 5, 3, 2 };
//        int[] p = new int[]{ 10, 9, 6 };
        int n = 6;
        int W = 100;
        int[] w = new int[]{ 80,50,50,50,50,100 };
        int[] p = new int[]{ 1000,550,550,550,550,1100 };

        System.out.println("input:");
        System.out.println(n + " " + W);
        for (int i = 0; i < w.length; i++){
            System.out.println(w[i] + " " + p[i]);
        }

        //decision
        System.out.println("output:");

        int[][] profit = new int[n][];
        int[][] need = new int[n][];
        for (int i = 0; i < n; i++){
            profit[i] = new int[W];
            need[i] = new int[W];
            for (int j = 0; j < W; j++){
                profit[i][j] = 0; need[i][j] = 0;
            }
        }
        // for k = 0..n-1
        int item = 0;
        // for y = 0..W
        for (int capacity = 1; capacity <= W; capacity++){
            if (w[item] <= capacity){

                profit[item][capacity-1] = p[item];
                need[item][capacity-1] = 1;
            }
            else {
                profit[item][capacity-1] = 0;
                need[item][capacity-1] = 0;
            }
        }



        for (item = 1; item < n; item++) {
            for (int capacity = 1; capacity <= W; capacity++) {
                if (w[item] <= capacity) {
                    if (capacity - w[item] - 1 >= 0) {
                        int preItemPrice = profit[item - 1][capacity - w[item] - 1];
                        int maybePreItemPrice = preItemPrice + p[item];
                        if (maybePreItemPrice > profit[item - 1][capacity - 1]) {
                            profit[item][capacity - 1] = maybePreItemPrice;
                            need[item][capacity - 1] = 1;
                        } else {
                            profit[item][capacity - 1] = p[item - 1];
                            need[item][capacity - 1] = 0;
                        }

                    } else {
                        profit[item][capacity - 1] = p[item];
                        need[item][capacity - 1] = 1;
                    }
                } else {
                    profit[item][capacity - 1] = 0;
                    need[item][capacity - 1] = 0;
                }
            }
        }

        //result
        System.out.println("result\n");
        System.out.println("profit:");
        cout(profit);
        System.out.println("need:");
        cout(need);

        // find max
        TreeSet<Integer> profitItems = new TreeSet<Integer>();
        int sumProfit = 0;

        int startCapacity = W-1;
        int startInd = n-1;

        while (true) {


            int maxProfitInd = startInd;
            for (; maxProfitInd >= 0; maxProfitInd--) {
                if (need[maxProfitInd][startCapacity] == 1) break;
            }
            int maxProfit = profit[maxProfitInd][startCapacity];

            for (int i = maxProfitInd - 1; i >= 0; i--) {
                if (profit[i][startCapacity] > maxProfit && need[i][startCapacity] == 1) {
                    maxProfit = profit[i][startCapacity];
                    maxProfitInd = i;
                }
            }
            if (startCapacity == W-1) sumProfit = maxProfit;

            System.out.println(maxProfit + " : [" + maxProfitInd + "][" + startCapacity + "]");

            startCapacity = startCapacity - w[maxProfitInd];
            startInd--;

            profitItems.add(maxProfitInd+1);

            if(startCapacity <= 0 || startInd <= 0) break;

        }


        System.out.println("Items for knapsack : " + profitItems);
        System.out.println("Max sum profit : " + sumProfit);

    }

    private static void cout(int[][] ar){
        for (int[] row : ar) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
