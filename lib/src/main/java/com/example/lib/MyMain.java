package com.example.lib;

import java.util.ArrayList;
import java.util.Random;

public class MyMain {
    public static void main(String[] args){
        Components NZXT = new Components("NZXT"); //New Components object called NZXT
        //RAM Corsair = new RAM("Corsair", 8, 3600, 16);
        NZXT.generateRams(5); //Randomly generating values for 5 "RAM" objects
        System.out.println(NZXT.toString()); //Print before sort
        NZXT.sortBySpeed(); //Sorting by speed
        System.out.println(NZXT.toString()); //Print after sort
        System.out.println("Size of RAM Array List: " + NZXT.size()); //Size of ramArrayList, using Sizable Interface
        System.out.println("Average speed of RAM: " + NZXT.getAverage()); //Print average speed of RAM
        System.out.println("Median speed of RAM: " + NZXT.getMedian()); //Print median speed of RAM

        Components originPC = new Components("OriginPC");
        try {
            RAM temp = originPC.getMaxSpeed(); //Demonstration of NoRamException
        }catch (NoRamException e){
            System.out.println("The ramArrayList is empty!");
        }
    }
}