package me.carscupcake.algorithms;

import me.carscupcake.SortingAlgorithem;

import java.util.List;

public class Insertionsort implements SortingAlgorithem {
    @Override
    public void sort(List<Integer> l) {

        for (int i = 0; i < l.size(); i++){
            int obj = l.get(i);
            for (int j = 0; j < i; j++){
                if(obj < l.get(j)) {
                    l.remove(i);
                    l.add(j, obj);
                    break;
                }
            }
        }
    }
}
