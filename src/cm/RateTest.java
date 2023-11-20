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
    @DisplayName("Test Rate constructor method")
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

        try{
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        }
        catch(IllegalArgumentException e){
            fail(e.getMessage());
        }
    }

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

        try{
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        }
        catch(IllegalArgumentException e){
            fail(e.getMessage());
        }
    }

    @Test
    void noOverlapInReducedPeriods(){
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

        try{
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        }
        catch(IllegalArgumentException e){
            fail(e.getMessage());
        }
    }

    @Test
    void noOverlapBetweenNormalAndReducedPeriods(){
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

        try{
            Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        }
        catch(IllegalArgumentException e){
            fail(e.getMessage());
        }
    }

    // Invalid Inputs
    @Test
    void reducedRateIsGreaterThanNormalRate(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(6);
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

    @Test
    void normalRateIsLessThanZero(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(5);
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

    @Test
    void overlapInNormalPeriods(){
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

    @Test
    void overlapBetweenNormalAndReducedPeriods(){
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
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

    /**
     * Method 'calculate(Period periodStay)' tests
     */
    // Invalid Input
    @DisplayName("Test calculate method")
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
    @Test
    void unspecifiedPeriod(){
        // the going rate should be FREE (0) if the range is unspecified
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
        Period periodStay = new Period(0, 6);
        assertEquals(0, r.calculate(periodStay).intValue());
    }

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
        assertEquals(8, r.calculate(periodStay).intValue());
    }

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
        assertEquals(10, r.calculate(periodStay).intValue());
    }

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