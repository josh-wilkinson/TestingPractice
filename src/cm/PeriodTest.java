package cm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodTest
{
    /**
     * Constructor 'Period(int start, int end)' tests
     */
    // Valid Inputs
    @DisplayName("Test Period constructor method")
    @Test
    void startBetweenZeroAndTwentyFour(){
        int start = 10;
        int end = 12;
        try{
            Period P = new Period(start, end);
        }
        catch(IllegalArgumentException e){
            fail(e.getMessage());
        }
    }
    @Test
    void endBetweenZeroAndTwentyFour(){
        int start = 10;
        int end = 12;
        try{
            Period P = new Period(start, end);
        }
        catch(IllegalArgumentException e){
            fail(e.getMessage());
        }
    }
    @Test
    void startIsLessThanEnd(){
        int start = 10;
        int end = 12;
        try{
            Period P = new Period(start, end);
        }
        catch(IllegalArgumentException e){
            fail(e.getMessage());
        }
    }
    // Invalid Inputs
    @Test
    void startIsLessThanZero(){
        int start = -1;
        int end = 12;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @Test
    void startIsGreaterThanTwentyFour(){
        int start = 25;
        int end = 26;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @Test
    void endIsLessThanZero(){
        // This test won't trigger the correct branch!!
        int start = -2;
        int end = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @Test
    void startIsGreaterThanOrEqualToEnd(){
        int start = 11;
        int end = 11;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @Test
    void endIsGreaterThanTwentyFour(){
        int start = 10;
        int end = 25;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    // Valid Output
    @Test   // this may need to be changed
    void startAndEndAreValid(){
        int start = 10;
        int end = 12;
        try{
            Period p = new Period(start, end);
        }
        catch (IllegalArgumentException e){
            fail(e.getMessage());
        }
    }

    /**
     * Method 'duration()' tests
     */
    /*
     Valid outputs
     Testing the boundaries between hours 0 and 24.
     The shortest possible duration should be 1 hour, and the longest should be 24 hours.
    */
    @DisplayName("duration returns 1")
    @Test
    void durationReturnsOne(){
        Period p = new Period(0, 1);
        assertEquals(1, p.duration());
    }
    @DisplayName("duration returns 24")
    @Test
    void durationReturnsTwentyFour(){
        Period p = new Period(0, 24);
        assertEquals(24, p.duration());
    }

    /**
     * Method 'overlaps(Period)' tests
     */
    /*
     Valid Outputs
     Here are all the different ways the method 'overlaps' can return TRUE or FALSE
    */
    @DisplayName("overlaps returns TRUE 1")
    @Test
    void overlapsReturnsTrue1(){
        Period oldPeriod = new Period(4, 8);
        Period period = new Period(6, 10);
        assertTrue(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps returns TRUE 2")
    @Test
    void overlapsReturnsTrue2(){
        Period oldPeriod = new Period(8, 10);
        Period period = new Period(6, 9);
        assertTrue(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps returns TRUE 3")
    @Test
    void overlapsReturnsTrue3(){
        Period oldPeriod = new Period(12, 16);
        Period period = new Period(10, 18);
        assertTrue(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps returns TRUE 4")
    @Test
    void overlapsReturnsTrue4(){
        Period oldPeriod = new Period(15, 18);
        Period period = new Period(16, 17);
        assertTrue(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps returns FALSE 1")
    @Test
    void overlapsReturnsFalse1(){
        Period oldPeriod = new Period(9, 10);
        Period period = new Period(11, 12);
        assertFalse(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps returns FALSE 1")
    @Test
    void overlapsReturnsFalse2(){
        Period oldPeriod = new Period(14, 15);
        Period period = new Period(10, 12);
        assertFalse(oldPeriod.overlaps(period));
    }
}