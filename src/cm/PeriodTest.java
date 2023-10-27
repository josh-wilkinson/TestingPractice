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
    void zeroLessThanOrEqualToStartLessThanOrEqualToTwentyFour(){
        int start = 10;
        int end = 12;
        assertTrue(start >= 0 && start <= 24);
        Period P = new Period(start, end);
    }
    @Test
    void zeroLessThanOrEqualToEndLessThanOrEqualToTwentyFour(){
        int start = 10;
        int end = 12;
        assertTrue(end >= 0 && end <= 24);
        Period P = new Period(start, end);
    }
    // Invalid inputs
    @Test
    void startIsLessThanEnd(){
        int start = 10;
        int end = 12;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });

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
        int end = 12;
        assertThrows(IllegalArgumentException.class, () -> {
            Period P = new Period(start, end);
        });
    }
    @Test
    void endIsLessThanZero(){
        int start = 10;
        int end = -1;
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
    @Test
    void startAndEndAreValid(){
        int start = 10;
        int end = 12;
        Period p = new Period(start, end);
    }

    /**
     * Method 'duration()' tests
     */
    // Valid outputs
    @DisplayName("Test duration method")
    @Test
    void durationReturnsOne(){
        Period p = new Period(0, 1);
        assertEquals(p.duration(), 1);
    }
    @Test
    void durationReturnsTwentyFour(){
        Period p = new Period(0, 24);
        assertEquals(p.duration(), 24);
    }

    /**
      * Method 'overlaps(Period)' tests
     */
    // Valid Outputs
    @DisplayName("Test overlaps method")
    @Test
    void overlapsReturnsTrue1(){
        Period oldPeriod = new Period(4, 8);
        Period period = new Period(6, 10);
        assertTrue(oldPeriod.overlaps(period));
    }
    @Test
    void overlapsReturnsTrue2(){
        Period oldPeriod = new Period(8, 10);
        Period period = new Period(6, 9);
        assertTrue(oldPeriod.overlaps(period));
    }
    @Test
    void overlapsReturnsTrue3(){
        Period oldPeriod = new Period(12, 16);
        Period period = new Period(10, 18);
        assertTrue(oldPeriod.overlaps(period));
    }
    @Test
    void overlapsReturnsTrue4(){
        Period oldPeriod = new Period(15, 18);
        Period period = new Period(16, 17);
        assertTrue(oldPeriod.overlaps(period));
    }
    @Test
    void overlapsReturnsFalse1(){
        Period oldPeriod = new Period(9, 10);
        Period period = new Period(11, 12);
        assertFalse(oldPeriod.overlaps(period));
    }
    @Test
    void overlapsReturnsFalse2(){
        Period oldPeriod = new Period(14, 15);
        Period period = new Period(10, 12);
        assertFalse(oldPeriod.overlaps(period));
    }
}