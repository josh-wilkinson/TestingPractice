package cm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RateTest
{
    /**
     * Constructor 'Rate(...)' tests
     */
    @DisplayName("Test 0 <= reducedRate <= normalRate, expected Rate instance")
    @Test
    void reducedRateIsGreaterThanOrEqualToZeroAndLessThanOrEqualToNormalRate(){
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertInstanceOf(Rate.class, rate);
    }
    @DisplayName("Test No overlap in normalPeriods, expected Rate instance")
    @Test
    void noOverlapInNormalPeriods(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        boolean overlapFlag = false;

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertInstanceOf(Rate.class, rate);
    }
    @DisplayName("Test No overlap in reducedPeriods, expected Rate instance")
    @Test
    void noOverlapInReducedPeriods(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        boolean overlapFlag = false;

        normalPeriods.add(new Period(15, 17));
        normalPeriods.add(new Period(13, 15));
        reducedPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(7, 10));

        Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertInstanceOf(Rate.class, rate);
    }
    @DisplayName("Test No overlap between reduced and normal periods, expected Rate instance")
    @Test
    void noOverlapBetweenNormalAndReducedPeriods(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(6);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        boolean overlapFlag = false;

        normalPeriods.add(new Period(6, 12));
        normalPeriods.add(new Period(0, 5));
        reducedPeriods.add(new Period(16, 17));
        reducedPeriods.add(new Period(12, 15));

        Rate rate = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertInstanceOf(Rate.class, rate);
    }
    // Invalid Inputs
    @DisplayName("Test reducedRate > normalRate, expected IllegalArgumentException")
    @Test
    void reducedRateIsGreaterThanNormalRate(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(6);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(15, 17));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test normalRate < 0, expected IllegalArgumentException")
    @Test
    void normalRateIsLessThanZero(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(5);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(0, 10));
        reducedPeriods.add(new Period(10, 20));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test reducedRate < 0, expected IllegalArgumentException")
    @Test
    void reducedRateIsLessThanZero(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(-1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test overlap in reducedPeriods, expected IllegalArgumentException")
    @Test
    void overlapInReducedPeriods(){
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(15, 17));
        normalPeriods.add(new Period(13, 15));
        reducedPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(8, 12));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test overlap in normalPeriods, expected IllegalArgumentException")
    @Test
    void overlapInNormalPeriods(){
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(7, 10));
        normalPeriods.add(new Period(7, 10));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(13, 15));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test overlap between normal and reduced periods, expected IllegalArgumentException")
    @Test
    void overlapBetweenNormalAndReducedPeriods(){
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(100);
        BigDecimal reducedRate = new BigDecimal(50);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        boolean overlapFlag = false;

        normalPeriods.add(new Period(15, 17));
        normalPeriods.add(new Period(13, 15));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test normalPeriods = null, expected IllegalArgumentException")
    @Test
    void normalPeriodsEqualsNull(){
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = null;
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test reducedPeriods = null, expected IllegalArgumentException")
    @Test
    void reducedPeriodsEqualsNull(){
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = null;

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test invalid normalPeriods, expected IllegalArgumentException")
    @Test
    void invalidNormalPeriods(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(0, 10));
        normalPeriods.add(new Period(9, 13));

        reducedPeriods.add(new Period(13, 14));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }

    /**
     * Method 'calculate(Period periodStay)' tests
     */
    // Invalid Input
    @DisplayName("Test periodStay = NULL, expected IllegalArgumentException")
    @Test
    void periodStayEqualsNull(){
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = null;

        assertThrows(IllegalArgumentException.class, () -> {
            r.calculate(periodStay);
        });
    }
    // Valid Outputs
    @DisplayName("Test unspecified period, expected 0")
    @Test
    void unspecifiedPeriod(){
        // the going rate should be FREE (0) if the range is unspecified
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(11);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(0, 6);
        assertEquals(0, r.calculate(periodStay).intValue());
    }
    @DisplayName("Test periodStay.overlaps(this.normalPeriods), expected 8")
    @Test
    void periodStayOverlapsNormalPeriods(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(10, 12);
        assertEquals(7.18, r.calculate(periodStay).doubleValue());
    }
    @DisplayName("Test periodStay.overlaps(this.reducedPeriods), expected 4")
    @Test
    void periodStayOverlapsReducedPeriods(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(13, 15);
        assertEquals(4, r.calculate(periodStay).intValue());
    }
    @DisplayName("Test periodStay.overlaps(this.normalPeriods) AND periodStay.overlaps(this.reducedPeriods), expected 8.52")
    @Test
    void periodStayOverlapsNormalAndReducedPeriods(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(10, 14);
        assertEquals(8.52, r.calculate(periodStay).doubleValue());
    }
    // Extra tests added after task 1
    // Invalid inputs
    @DisplayName("Test normalRate = Null, expected IllegalArgumentException")
    @Test
    void normalRateIsNull(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Period periodStay = new Period(10, 12);

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    @DisplayName("Test reducedRate = Null, expected IllegalArgumentException")
    @Test
    void reducedRateIsNull(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = null;
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        assertThrows(IllegalArgumentException.class, () -> {
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        });
    }
    // Valid output
    @DisplayName("Test kind = VISITOR, expected Rate instance")
    @Test
    void kindEqualsVisitor(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(13, 14);
        assertEquals(0, r.calculate(periodStay).intValue());
    }
}