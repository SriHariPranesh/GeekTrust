package com.example.geektrust;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    POWER_G_MAN Power_G_man = new POWER_G_MAN();
    private static final int COMMAND_INDEX = 0; // Index for the command type in input
    private static final String SOURCE_COMMAND = "SOURCE";
    private static final String DESTINATION_COMMAND = "DESTINATION";

    public static void main(String[] args) throws FileNotFoundException
    {
        Main main = new Main();
        main.run(args[0]);
    }

    public void run(String path) throws FileNotFoundException
    {
        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);
        while (sc.hasNextLine())
        {
            String s = sc.nextLine();
            String[] split = s.split("\\s+");
            if(split[COMMAND_INDEX].equals(SOURCE_COMMAND))
            {
                Power_G_man.AssignDirectionAndLocation(s);
            }
            else if(split[COMMAND_INDEX].equals(DESTINATION_COMMAND))
            {
                Power_G_man.AssignDestination(s);
            }
        }
        ReadInput();
        sc.close();
    }

    private void ReadInput()
    {
        Power_G_man.ChangeDirection();
        Power_G_man.CalculateSteps();
        Power_G_man.CalculateRemainingPower();
        Power_G_man.Display();
    }
}
