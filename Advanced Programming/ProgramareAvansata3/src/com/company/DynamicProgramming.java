package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

public class DynamicProgramming implements Algorithm {

    private Knapsack knapsack;
    private List<Item> availableItems;
    private double[][] dp;

    public DynamicProgramming(Knapsack knapsack, List<Item> availableItems) {
        this.knapsack = knapsack;
        this.availableItems = availableItems;
    }

    @Override
    public void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    @Override
    public void setAvailableItems(LinkedList<Item> items) {
        this.availableItems = items;
    }

    @Override
    public void computeSolution() {
        int noOfRows = availableItems.size();
        int noOfColumns = (int) Math.ceil(knapsack.getCapacity());
        dp = new double[noOfRows+1][noOfColumns+1];
        int i, j;
        //dp[i][j] = valoarea maxima ce se poate obtine avand la dispozitie primele i iteme, capacitatea maxima a rucsacului fiind j
        Iterator iterator = availableItems.listIterator();
        for (i = 1; i <= noOfRows; ++i) {
            Item item = (Item) iterator.next();
            for (j = 1; j <= noOfColumns; ++j) {
                if (j < item.getWeight()) {
                    dp[i][j] = dp[i - 1][j]; // daca nu am loc in rucsac sa adaug itemul curent, iau cea mai buna solutie fara itemul i pentru capacitatea j
                } else {
                    //am loc sa adaug itemul i
                    //aleg maximul dintre valoarea itemului curent + solutia fara itemul i si capacitate j - greutatea itemului curent
                    //sau solutia fara itemul i si capacitate j
                    dp[i][j] = Math.max(item.getValue() + dp[i - 1][j - (int) item.getWeight()], dp[i - 1][j]);
                }
            }
        }

        //fac retrace la solutie pentru a afla ce item uri am ales
        while(dp[noOfRows][noOfColumns] > 0) { //ma opresc cand nu mai sunt solutii precendente
            if(dp[noOfRows][noOfColumns] == dp [noOfRows-1][noOfColumns])
            {
                //daca solutia curenta pentru dp[i][j] este egala cu dp[i-1][j] atunci e clar ca nu am luat itemul i
                --noOfRows;//ma duc la locul de unde am luat solutia pentru dp[i][j]
            } else {
                //singura posibilitate ramasa e sa fi luat itemul i
                knapsack.addItem( availableItems.get(noOfRows-1) ); // il adaug
                //aflu solutia precedenta
                noOfColumns = noOfColumns - (int)availableItems.get(noOfRows-1).getWeight(); // solutia precedenta este pentru capacitatea: j - weight(i)
                --noOfRows;//solutia precendenta nu include itemul i
            }
        }


    }
}
