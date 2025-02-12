package com.example.geektrust;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        if (args.length == Constants.NULL)
        {
            System.out.println("No input file provided.");
            return;
        }

        String filePath = args[Constants.NULL];

        FileInputStream fis = new FileInputStream(filePath);
        Scanner sc = new Scanner(fis);

        ReadInput read_Input= new ReadInput();

        while (sc.hasNextLine())
        {
            String s = sc.nextLine();
            String[] split = s.split("\\s+");
            switch (split[Constants.NULL])
            {
                case "ADD_PROGRAMME":
                    read_Input.AddTotal(s);
                    break;
                case "APPLY_COUPON":
                    read_Input.SELECTED_DISCOUNT_COUPON.add(split[Constants.ONE]);
                    break;
                case "ADD_PRO_MEMBERSHIP":
                    read_Input.MEMBERSHIP = true;
                    break;
            }
        }

        read_Input.readInput();
        read_Input.DisplayOutput();
        sc.close();
    }
}
