package com.example.geektrust;

import java.util.*;

public class TrainService
{
    static List<String> trainAB= new ArrayList<>();
    static List<String> combine= new ArrayList<>();
    static List<String> TrainA= new ArrayList<>();
    static List<String> TrainB= new ArrayList<>();
    static List<String> TrainAB= new ArrayList<>();


    public void info()
    {
        trainAB.add("HYB");
        trainAB.add("NGP");
        trainAB.add("ITJ");
        trainAB.add("BPL");
        trainAB.add("AGA");
        trainAB.add("NDL");
        trainAB.add("PTA");
        trainAB.add("NJP");
        trainAB.add("GHY");
        TrainA.add("TRAIN_A");
        TrainA.add("ENGINE");
        TrainB.add("TRAIN_B");
        TrainB.add("ENGINE");
        TrainAB.add("TRAIN_AB");
        TrainAB.add("ENGINE");
        TrainAB.add("ENGINE");
    }

    public void combine(String s)
    {
        String[] word = s.split("\\s+");
        combine.addAll(Arrays.asList(word).subList(2, word.length));
    }

    public void arrangeA(String s)  //This method takes the BOGIE's after Hyderabad from the TRAIN_A and adds it to the TrainA list
    {
        String[] train_a = s.split(" ");
        for(int i=2; i<train_a.length; i++)
        {
            if(trainAB.contains(train_a[i]))
            {
                TrainA.add(train_a[i]);
            }
        }
        displayA();
    }

    private void displayA()  //This method is to display the BOGIE's of Train_A
    {
        System.out.print("ARRIVAL");
        for (String bogie : TrainA)
        {
            System.out.print("\t" + bogie);
        }
        System.out.println();
    }

    public void arrangeB(String s)  //This method takes the BOGIE's after Hyderabad from the TRAIN_B and adds it to the TrainB list
    {
        String[] train_b = s.split(" ");
        for(int i=2; i<train_b.length; i++)
        {
            if(trainAB.contains(train_b[i]))
            {
                TrainB.add(train_b[i]);
            }
        }
        displayB();
    }

    private void displayB()   //This method is to display the BOGIE's of Train_B
    {
        System.out.print("ARRIVAL");
        for (String bogie : TrainB)
        {
            System.out.print("\t" + bogie);
        }
        System.out.println();
    }

    public void arrangeAB()  //This method takes the BOGIE's after Hyderabad from both the trains and adds it to the TrainAB list
    {
        for(int i=trainAB.size()-1; i>=0; i--)
        {
            for (String bogie : combine)
            {
                if (bogie.equals(trainAB.get(i)) && !bogie.equals("HYB"))
                {
                    TrainAB.add(bogie);
                }
            }
        }
        displayAB();
    }

    private void displayAB()  //This method is to display the combined BOGIE's of both the trains
    {
        System.out.print("DEPARTURE");
        for(String bogie: TrainAB)
        {
            System.out.print("\t" + bogie);
        }
        System.out.println();
    }
}
