package org.example.main;

import java.util.ArrayList;
import java.util.List;

public class ChangeModule {

    private List<Integer> coinSets = new ArrayList<>();

    public void add(int i) {
        this.coinSets.add(i);
    }

    @Override
    public boolean equals(Object coinSet) {
        if (!(coinSet instanceof ChangeModule)){
            return false;
        }
        return this.toString().equals(coinSet.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer coin: this.coinSets){
            builder.append(coin);
        }
        return builder.toString();
    }
}
