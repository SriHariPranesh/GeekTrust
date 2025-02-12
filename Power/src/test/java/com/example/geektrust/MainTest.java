package com.example.geektrust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest
{
    private POWER_G_MAN Power_G_Man;

    @BeforeEach
    public void setup()
    {
        Power_G_Man = new POWER_G_MAN();
    }

    @Test
    public void TestAssignDirectionAndLocation()
    {
        String INPUT= "SOURCE 3 4 N";
        Power_G_Man.AssignDirectionAndLocation(INPUT);

        assertEquals(3, Power_G_Man.X_COORDINATE_CURRENT);
        assertEquals(4, Power_G_Man.Y_COORDINATE_CURRENT);
        assertEquals("N", Power_G_Man.DIRECTION);
    }

    @Test
    public void TestAssignDestination()
    {
        String INPUT= "DESTINATION 3 4";
        Power_G_Man.AssignDestination(INPUT);

        assertEquals(3, Power_G_Man.X_COORDINATE_DESTINATION);
        assertEquals(4, Power_G_Man.Y_COORDINATE_DESTINATION);
    }

    @Test
    public void TestChangeDirection1()
    {
        String SOURCE= "SOURCE 1 0 S";
        String DESTINATION= "DESTINATION 3 4";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(2, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection2()
    {
        String SOURCE= "SOURCE 1 0 N";
        String DESTINATION= "DESTINATION 3 4";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(1, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection3()
    {
        String SOURCE= "SOURCE 2 2 W";
        String DESTINATION= "DESTINATION 4 0";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(2, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection4()
    {
        String SOURCE= "SOURCE 2 2 S";
        String DESTINATION= "DESTINATION 4 0";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(1, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection5()
    {
        String SOURCE= "SOURCE 2 2 W";
        String DESTINATION= "DESTINATION 0 1";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(1, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection6()
    {
        String SOURCE= "SOURCE 2 2 N";
        String DESTINATION= "DESTINATION 0 1";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(2, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection7()
    {
        String SOURCE= "SOURCE 2 2 W";
        String DESTINATION= "DESTINATION 0 4";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(1, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection8()
    {
        String SOURCE= "SOURCE 2 2 S";
        String DESTINATION= "DESTINATION 0 4";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(2, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection9()
    {
        String SOURCE= "SOURCE 2 2 S";
        String DESTINATION= "DESTINATION 2 4";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(2, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection10()
    {
        String SOURCE= "SOURCE 2 2 W";
        String DESTINATION= "DESTINATION 5 2";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(2, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection11()
    {
        String SOURCE= "SOURCE 2 2 S";
        String DESTINATION= "DESTINATION 0 2";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(1, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestChangeDirection12()
    {
        String SOURCE= "SOURCE 2 2 W";
        String DESTINATION= "DESTINATION 2 0";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.ChangeDirection();

        assertEquals(1, Power_G_Man.TURNS_MADE);
    }

    @Test
    public void TestCalculateSteps()
    {
        String SOURCE= "SOURCE 2 2 W";
        String DESTINATION= "DESTINATION 4 6";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.CalculateSteps();

        assertEquals(6, Power_G_Man.STEPS_TAKEN);
    }

    @Test
    public void TestCalculateRemainingPower()
    {
        String SOURCE= "SOURCE 2 2 W";
        String DESTINATION= "DESTINATION 4 6";
        Power_G_Man.AssignDirectionAndLocation(SOURCE);
        Power_G_Man.AssignDestination(DESTINATION);
        Power_G_Man.CalculateSteps();
        Power_G_Man.ChangeDirection();
        Power_G_Man.CalculateRemainingPower();

        assertEquals(130, Power_G_Man.POWER_REMAINING);
    }
}