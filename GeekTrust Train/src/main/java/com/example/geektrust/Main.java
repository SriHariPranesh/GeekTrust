package com.example.geektrust;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        if (args.length == 0)
        {
            System.out.println("No input file provided.");
            return;
        }

        String filePath = args[0];
        TrainService trainService = new TrainService();

        FileInputStream fis = new FileInputStream(filePath);
        Scanner sc = new Scanner(fis);

        trainService.info();
        if (sc.hasNextLine())
        {
            String line1 = sc.nextLine();
            trainService.combine(line1);
            trainService.arrangeA(line1);
        }

        if (sc.hasNextLine())
        {
            String line2 = sc.nextLine();
            trainService.combine(line2);
            trainService.arrangeB(line2);
            trainService.arrangeAB();
        }
        sc.close();
    }
}
