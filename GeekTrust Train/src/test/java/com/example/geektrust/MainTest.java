package com.example.geektrust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private TrainService trainService;

    @BeforeEach
    public void setup() {
        trainService = new TrainService();
        trainService.info();  // Populating the lists
    }

    @Test
    public void testInfo() {
        // Verify that the lists are populated correctly
        assertTrue(TrainService.trainAB.contains("HYB"));
        assertTrue(TrainService.TrainA.contains("TRAIN_A"));
        assertTrue(TrainService.TrainB.contains("TRAIN_B"));
    }

    @Test
    public void testCombine() {
        String input = "TRAIN_A COMBINE A B C D E";
        trainService.combine(input);
        assertTrue(TrainService.combine.contains("A"));
        assertTrue(TrainService.combine.contains("B"));
        assertTrue(TrainService.combine.contains("C"));
        assertTrue(TrainService.combine.contains("D"));
        assertTrue(TrainService.combine.contains("E"));
    }

    @Test
    public void testArrangeA() {
        String input = "ARRIVE TRAIN_A HYB NGP ITJ BPL";
        trainService.arrangeA(input);
        assertTrue(TrainService.TrainA.contains("HYB"));
        assertTrue(TrainService.TrainA.contains("NGP"));
        assertTrue(TrainService.TrainA.contains("ITJ"));
    }

    @Test
    public void testArrangeB() {
        String input = "ARRIVE TRAIN_B HYB NGP AGA NDL";
        trainService.arrangeB(input);
        assertTrue(TrainService.TrainB.contains("HYB"));
        assertTrue(TrainService.TrainB.contains("NGP"));
        assertTrue(TrainService.TrainB.contains("AGA"));
    }

    @Test
    public void testArrangeAB() {
        String input = "TRAIN_AB COMBINE HYB NGP ITJ";
        trainService.combine(input);  // Combining the input
        trainService.arrangeAB();
        // Verify that the TrainAB list contains the combined bogies
        assertTrue(TrainService.TrainAB.contains("ITJ"));
        assertTrue(TrainService.TrainAB.contains("NGP"));
    }

    @Test
    public void testEdgeCaseForArrangeA() {
        String input = "ARRIVE TRAIN_A";
        trainService.arrangeA(input);  // Should not add anything as there are no bogies after "TRAIN_A"
        assertEquals(2, TrainService.TrainA.size());
    }
}
