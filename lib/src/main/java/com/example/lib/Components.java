package com.example.lib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Components implements Sizable {
    private String systemIntegrator;
    private ArrayList<RAM> ramArrayList;

    public Components(String systemIntegrator) {
        this.systemIntegrator = systemIntegrator;
        ramArrayList = new ArrayList<>();
    }

    public void generateRams(int n){
        ArrayList<String> manufacturers = new ArrayList<>();
        manufacturers.add("Corsair");
        manufacturers.add("Kingston");
        manufacturers.add("TeamGroup");
        manufacturers.add("Crucial");
        manufacturers.add("G.Skill");
        manufacturers.add("Patriot");

        Random rand = new Random();
        for(int i = 0; i < n; i++){
            RAM tempRam = new RAM(manufacturers.get(rand.nextInt(6)), rand.nextInt((64 - 4) + 1) + 4, rand.nextInt((5200 - 2133) + 1) + 2133, rand.nextInt((22 - 12) + 1) + 12);
            ramArrayList.add(tempRam);
        }
    }

    public void addRam(RAM ram){
        ramArrayList.add(ram);
    }

    @Override
    public String toString(){
        return "Components{" +
                "systemIntegrator=" + systemIntegrator +
                ", ramArrayList=" + ramArrayList +
                "}";
    }

    public void sortBySpeed(){
        Collections.sort(ramArrayList, new Comparator<RAM>() {
            @Override
            public int compare(RAM ram, RAM t1) {
                if(ram.getSpeed() == t1.getSpeed()) return 0;
                if(ram.getSpeed() > t1.getSpeed()) return 1;
                return -1;
            }
        });
    }

    @Override
    public int size() {
        return ramArrayList.size();
    }

    public RAM getMaxSpeed() throws NoRamException {
        if (ramArrayList.size() == 0) throw new NoRamException(systemIntegrator);
        RAM temp = ramArrayList.get(0);
        for(int i = 1; i < ramArrayList.size(); i++){
            if(ramArrayList.get(i).getSpeed() > temp.getSpeed()) temp = ramArrayList.get(i);
        }
        return temp;
    }

    public RAM getMinSpeed() throws NoRamException {
        if (ramArrayList.size() == 0) throw new NoRamException(systemIntegrator);
        RAM temp = ramArrayList.get(0);
        for(int i = 1; i < ramArrayList.size(); i++){
            if(ramArrayList.get(i).getSpeed() < temp.getSpeed()) temp = ramArrayList.get(i);
        }
        return temp;
    }

    public int getAverage(){
        int average = 0;
        int it = 0;
        for(; it < ramArrayList.size(); it++){
            average += ramArrayList.get(it).getSpeed();
        }
        return average/it;
    }

    public int getMedian(){
        ArrayList<RAM> temp = ramArrayList;
        Collections.sort(temp, new Comparator<RAM>() {
            @Override
            public int compare(RAM ram, RAM t1) {
                if(ram.getSpeed() == t1.getSpeed()) return 0;
                if(ram.getSpeed() > t1.getSpeed()) return 1;
                return -1;
            }
        });

        if(temp.size() % 2 == 0){
            int sizeOfArray = temp.size() / 2;
            return (temp.get(sizeOfArray).getSpeed() + temp.get(sizeOfArray - 1).getSpeed()) / 2;
        }else{
            int sizeOfArray = (temp.size() - 1) / 2;
            return temp.get(sizeOfArray).getSpeed();
        }
    }
}
