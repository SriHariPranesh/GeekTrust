package com.example.geektrust;

public class POWER_G_MAN
{
    String DIRECTION = "";
    int POWER_REMAINING = Constants.MAX_POWER;
    int POWER_USED = 0;
    int TURNS_MADE = 0;
    int STEPS_TAKEN = 0;
    int X_COORDINATE_CURRENT= 0;
    int Y_COORDINATE_CURRENT= 0;
    int X_COORDINATE_DESTINATION= 0;
    int Y_COORDINATE_DESTINATION= 0;

    public void AssignDirectionAndLocation(String INPUT)
    {
        String[] INPUT_ARRAY= INPUT.split("\\s+");
        int X_COORDINATE= Integer.parseInt(INPUT_ARRAY[Constants.X_COORDINATE_INDEX]);
        int Y_COORDINATE= Integer.parseInt(INPUT_ARRAY[Constants.Y_COORDINATE_INDEX]);
        DIRECTION= INPUT_ARRAY[Constants.DIRECTION_INDEX];

        X_COORDINATE_CURRENT= X_COORDINATE;
        Y_COORDINATE_CURRENT= Y_COORDINATE;
    }

    public void AssignDestination(String INPUT)
    {
        String[] INPUT_ARRAY= INPUT.split("\\s+");
        int X_COORDINATE= Integer.parseInt(INPUT_ARRAY[Constants.X_COORDINATE_INDEX]);
        int Y_COORDINATE= Integer.parseInt(INPUT_ARRAY[Constants.Y_COORDINATE_INDEX]);

        X_COORDINATE_DESTINATION= X_COORDINATE;
        Y_COORDINATE_DESTINATION= Y_COORDINATE;
    }

    private void NorthEast()
    {
        if(DIRECTION.equals(Constants.SOUTH) || DIRECTION.equals(Constants.WEST))
        {
            TURNS_MADE+= Constants.DOUBLE_TURN_COST;
        }
        else
        {
            TURNS_MADE+= Constants.SINGLE_TURN_COST;
        }
    }

    private void SouthEast()
    {
        if(DIRECTION.equals(Constants.NORTH) || DIRECTION.equals(Constants.WEST))
        {
            TURNS_MADE+= Constants.DOUBLE_TURN_COST;
        }
        else
        {
            TURNS_MADE+= Constants.SINGLE_TURN_COST;
        }
    }

    private void SouthWest()
    {
        if(DIRECTION.equals(Constants.SOUTH) || DIRECTION.equals(Constants.EAST))
        {
            TURNS_MADE+= Constants.DOUBLE_TURN_COST;
        }
        else
        {
            TURNS_MADE+= Constants.SINGLE_TURN_COST;
        }
    }

    private void NorthWest()
    {
        if(DIRECTION.equals(Constants.NORTH) || DIRECTION.equals(Constants.EAST))
        {
            TURNS_MADE+= Constants.DOUBLE_TURN_COST;
        }
        else
        {
            TURNS_MADE+= Constants.SINGLE_TURN_COST;
        }
    }

    private void North()
    {
        if(DIRECTION.equals(Constants.SOUTH))
        {
            TURNS_MADE+= Constants.DOUBLE_TURN_COST;
        }
        else
        {
            TURNS_MADE+= Constants.SINGLE_TURN_COST;
        }
    }

    private void South()
    {
        if(DIRECTION.equals(Constants.NORTH))
        {
            TURNS_MADE+= Constants.DOUBLE_TURN_COST;
        }
        else
        {
            TURNS_MADE+= Constants.SINGLE_TURN_COST;
        }
    }

    private void East()
    {
        if(DIRECTION.equals(Constants.WEST))
        {
            TURNS_MADE+= Constants.DOUBLE_TURN_COST;
        }
        else
        {
            TURNS_MADE+= Constants.SINGLE_TURN_COST;
        }
    }

    private void West()
    {
        if(DIRECTION.equals(Constants.EAST))
        {
            TURNS_MADE+= Constants.DOUBLE_TURN_COST;
        }
        else
        {
            TURNS_MADE+= Constants.SINGLE_TURN_COST;
        }
    }

    public void ChangeDirection()   //Each if statement indicate the target direction and then checks the number of turns required
    {
        if(X_COORDINATE_CURRENT < X_COORDINATE_DESTINATION &&
                Y_COORDINATE_CURRENT < Y_COORDINATE_DESTINATION)
        {
            NorthEast(); // If moving diagonally towards the North-East
        }

        else if(X_COORDINATE_CURRENT < X_COORDINATE_DESTINATION &&
                Y_COORDINATE_CURRENT > Y_COORDINATE_DESTINATION)
        {
            SouthEast();// If moving diagonally towards the South-East
        }

        else if(X_COORDINATE_CURRENT > X_COORDINATE_DESTINATION &&
                Y_COORDINATE_CURRENT < Y_COORDINATE_DESTINATION)
        {
            SouthWest(); // If moving diagonally towards the South-West
        }

        else if(X_COORDINATE_CURRENT > X_COORDINATE_DESTINATION &&
                Y_COORDINATE_CURRENT > Y_COORDINATE_DESTINATION)
        {
            NorthWest(); // If moving diagonally towards the North-West
        }

        else if((X_COORDINATE_CURRENT == X_COORDINATE_DESTINATION) &&
                Y_COORDINATE_CURRENT < Y_COORDINATE_DESTINATION)
        {
            North(); // If moving diagonally towards the North
        }

        else if((X_COORDINATE_CURRENT == X_COORDINATE_DESTINATION) &&
                Y_COORDINATE_CURRENT > Y_COORDINATE_DESTINATION)
        {
            South(); // If moving diagonally towards the south
        }

        else if(X_COORDINATE_CURRENT < X_COORDINATE_DESTINATION)
        {
            East(); // If moving diagonally towards the East
        }

        else if(X_COORDINATE_CURRENT > X_COORDINATE_DESTINATION)
        {
            West(); // If moving diagonally towards the West
        }
    }

    public void CalculateSteps()
    {
        STEPS_TAKEN+= Math.abs(X_COORDINATE_CURRENT - X_COORDINATE_DESTINATION);
        STEPS_TAKEN+= Math.abs(Y_COORDINATE_CURRENT - Y_COORDINATE_DESTINATION);
    }

    public void CalculateRemainingPower()
    {
        POWER_USED+= TURNS_MADE * Constants.TURN_POWER_USED;
        POWER_USED+= STEPS_TAKEN * Constants.STEPS_POWER_USED;

        POWER_REMAINING-= POWER_USED;
    }

    public void Display()
    {
        System.out.println("POWER " + POWER_REMAINING);
    }
}