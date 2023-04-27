package me.carscupcake;

import me.carscupcake.algorithms.Insertionsort;
import me.carscupcake.algorithms.Selectionsort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<SortingAlgorithem> algorithems = new ArrayList<>(List.of(new Selectionsort(), new Insertionsort()));
    public static SortingAlgorithem loaded;
    public static List<Integer> loadedList;
    static int step = 0;
    public static void main(String[] args) {
            while (true){
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String option = reader.readLine();
                    if(option.equals("validate")){
                        boolean isRight = true;
                        int b = loadedList.get(0);
                        for (int i = 1; i < loadedList.size(); i++){
                            if(b > loadedList.get(i)){
                                isRight = false;
                                break;
                            }
                        }
                        if(isRight){
                            System.out.println("List is correct!");
                        }else {
                            System.out.println("List is wrong!");
                        }
                        continue;
                    }
                    switch (step) {
                        case 0 -> loaded = algorithems.get(Integer.parseInt(option));
                        case 1 -> {
                            if (option.equals("default")) {
                                loadedList = new ArrayList<>(List.of(25, 17, 32, 56, 19, 8, 66, 29, 6, 20, 29));
                            } else {
                                if(option.startsWith("random")){
                                    String s = option.substring(7);
                                    int amount = Integer.parseInt(s);
                                    loadedList = new ArrayList<>();
                                    for (int i = 0; i < amount; i++){
                                        loadedList.add(i);
                                    }
                                    Collections.shuffle(loadedList);
                                    System.out.println("Created a random list with " + amount + " numbers");
                                }else {
                                    File file = new File(option);
                                    if (!file.exists()) {
                                        System.out.println("File is not existing!");
                                        return;
                                    }
                                    BufferedReader r = new BufferedReader(new FileReader(file));
                                    loadedList = new ArrayList<>();
                                    r.lines().forEachOrdered(s -> loadedList.add(Integer.parseInt(s)));
                                    System.out.println("List loaded");
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println(loadedList);
                            long t = System.currentTimeMillis();
                            loaded.sort(loadedList);
                            System.out.println(loadedList);
                            System.out.println("Sorting took " + (System.currentTimeMillis() - t) + "ms");
                            step = -1;
                            Runtime.getRuntime().gc();
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + step);
                    }
                    step++;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}