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
    @DisplayName("Period Test 0 <= start <= 24, expected Period instance")
    @Test
    void startBetweenZeroAndTwentyFour(){
        // This test is to check if the start value is between 0 and 24
        int start = 10;
        int end = 12;
        Period period = new Period(start, end);
        assertNotNull(period);
        assertInstanceOf(Period.class, period);
    }
    @DisplayName("Period Test 0 <= end <= 24, expected Period instance")
    @Test
    void endBetweenZeroAndTwentyFour(){
        // This test is to check if the end value is between 0 and 24
        // I changed the values around to avoid testing previous start and end values
        int start = 0;
        int end = 10;
        Period period = new Period(start, end);
        assertNotNull(period);
        assertInstanceOf(Period.class, period);
    }
    @DisplayName("Period Test start < end, expected Period instance")
    @Test
    void startIsLessThanEnd(){
        // This test is to check if the start value is less than the end value it will result in a Period object
        // I changed the values around to avoid testing previous start and end values
        int start = 4;
        int end = 8;
        Period period = new Period(start, end);
        assertNotNull(period);
        assertInstanceOf(Period.class, period);
    }
    // Invalid Inputs
    @DisplayName("Period Test start < 0, expected IllegalArgumentException")
    @Test
    void startIsLessThanZero(){
        int start = -1;
        int end = 12;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @DisplayName("Period Test start > 24, expected IllegalArgumentException")
    @Test
    void startIsGreaterThanTwentyFour(){
        int start = 25;
        int end = 26;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @DisplayName("Test end < 0, expected IllegalArgumentException")
    @Test
    void endIsLessThanZero(){
        // This test won't trigger the correct branch in the constructor!!
        int start = -2;
        int end = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @DisplayName("Test start >= end, expected IllegalArgumentException")
    @Test
    void startIsGreaterThanOrEqualToEnd(){
        int start = 11;
        int end = 11;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @DisplayName("Period Test end > 24, expected IllegalArgumentException")
    @Test
    void endIsGreaterThanTwentyFour(){
        int start = 10;
        int end = 25;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    // Valid Output
    @DisplayName("Period Test for valid output, expected Period instance")
    @Test   // this may need to be changed
    void startAndEndAreValid(){
        int start = 0;
        int end = 24;
        Period period = new Period(start, end);
        assertNotNull(period);
        assertInstanceOf(Period.class, period);
    }

    /**
     * Method 'duration()' tests
     */
    /*
     Valid outputs
     Testing the boundaries between hours 0 and 24.
     The shortest possible duration should be 1 hour, and the longest should be 24 hours.
    */
    @DisplayName("duration Test, expected 1")
    @Test
    void durationReturnsOne(){
        Period p = new Period(0, 1);
        assertEquals(1, p.duration());
    }
    @DisplayName("duration Test, expected 24")
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
    @DisplayName("overlaps Test 1, expected TRUE")
    @Test
    void overlapsReturnsTrue1(){
        Period oldPeriod = new Period(4, 8);
        Period period = new Period(6, 10);
        assertTrue(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps Test 2, expected TRUE")
    @Test
    void overlapsReturnsTrue2(){
        Period oldPeriod = new Period(8, 10);
        Period period = new Period(6, 9);
        assertTrue(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps Test 3, expected TRUE")
    @Test
    void overlapsReturnsTrue3(){
        Period oldPeriod = new Period(12, 16);
        Period period = new Period(10, 18);
        assertTrue(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps Test 4, expected TRUE")
    @Test
    void overlapsReturnsTrue4(){
        Period oldPeriod = new Period(15, 18);
        Period period = new Period(16, 17);
        assertTrue(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps Test 5, expected FALSE")
    @Test
    void overlapsReturnsFalse1(){
        Period oldPeriod = new Period(9, 10);
        Period period = new Period(11, 12);
        assertFalse(oldPeriod.overlaps(period));
    }
    @DisplayName("overlaps Test 6, expected FALSE")
    @Test
    void overlapsReturnsFalse2(){
        Period oldPeriod = new Period(14, 15);
        Period period = new Period(10, 12);
        assertFalse(oldPeriod.overlaps(period));
    }
}