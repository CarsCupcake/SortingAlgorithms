package me.carscupcake.algorithms;

import me.carscupcake.SortingAlgorithem;

import java.util.List;

public class Selectionsort implements SortingAlgorithem {
    @Override
    public void sort(List<Integer> l) {
        int smolest = 0;
        int s = l.get(0);
        int firstItem = 0;
        while (firstItem + 2 != l.size()){
            for (int i = firstItem; i < l.size(); i++){
                int item = l.get(i);
                if(item < s) {
                    smolest = i;
                    s = item;
                }
            }
            l.remove(smolest);
            l.add(firstItem, s);
            smolest = firstItem + 1;
            s = l.get(firstItem + 1);
            firstItem++;
        }
    }
}
