package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RateTest
{
    /**
     * Constructor 'Rate(...)' tests
     */
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

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        assertTrue(0 <= reducedRate.intValue() && reducedRate.intValue() <= normalRate.intValue());
    }

    @Test
    void noOverlapInNormalPeriods(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        int n = 0;

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        if (normalPeriods.size() > 1) // since there might be only one Period in the list
            assertFalse(normalPeriods.get(n).overlaps(normalPeriods.get(n+1)));
    }

    @Test
    void noOverlapInReducedPeriods(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        int n = 0;

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        if (reducedPeriods.size() > 1) // since there might be only one Period in the list
            assertFalse(reducedPeriods.get(n).overlaps(reducedPeriods.get(n+1)));
    }

    @Test
    void noOverlapBetweenNormalAndReducedPeriods(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        int n = 0;
        boolean overlapFlag = false;

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        for (int i = 0; i < normalPeriods.size(); i++){
            for (int j = 0; j < reducedPeriods.size(); j++){
                if (reducedPeriods.get(i).overlaps(normalPeriods.get(j)))
                    overlapFlag = true;
            }
        }
        assertFalse(overlapFlag);
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
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        assertTrue(reducedRate.intValue() > normalRate.intValue());
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
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        assertTrue(normalRate.intValue() < 0);
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
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        assertTrue(reducedRate.intValue() < 0);
    }

    @Test
    void overlapInNormalPeriods(){
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        int n = 0;

        normalPeriods.add(new Period(15, 17));
        normalPeriods.add(new Period(13, 15));
        reducedPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(8, 12));
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        if (normalPeriods.size() > 1) // since there might be only one Period in the list
            assertTrue(normalPeriods.get(n).overlaps(normalPeriods.get(n+1)));
    }

    @Test
    void overlapInReducedPeriods(){
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        int n = 0;

        normalPeriods.add(new Period(15, 17));
        normalPeriods.add(new Period(13, 15));
        reducedPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(8, 12));
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        if (reducedPeriods.size() > 1) // since there might be only one Period in the list
            assertTrue(reducedPeriods.get(n).overlaps(reducedPeriods.get(n+1)));
    }

    @Test
    void overlapBetweenNormalAndReducedPeriods(){
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        int n = 0;
        boolean overlapFlag = false;

        normalPeriods.add(new Period(15, 17));
        normalPeriods.add(new Period(13, 15));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        for (int i = 0; i < normalPeriods.size(); i++){
            for (int j = 0; j < reducedPeriods.size(); j++){
                if (reducedPeriods.get(i).overlaps(normalPeriods.get(j)))
                    overlapFlag = true;
            }
        }
        assertTrue(overlapFlag);
    }

    @Test
    void normalPeriodsEqualsNull(){
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = null;
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        int n = 0;
        boolean overlapFlag = false;

        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        //assertThrows(IllegalArgumentException);
    }

    @Test
    void reducedPeriodsEqualsNull(){
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = null;
        int n = 0;
        boolean overlapFlag = false;

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        //assertThrows(IllegalArgumentException);
    }

    /**
     * Method 'calculate(Period periodStay)' tests
     */
    // Invalid Input
    @Test
    void periodStayEqualsNull(){
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = null;
    }

    // Valid Outputs
    @Test
    void unspecifiedPeriod(){

    }

    @Test
    void periodStayOverlapsNormalPeriods(){

    }

    @Test
    void periodStayOverlapsReducedPeriods(){

    }

    @Test
    void periodStayOverlapsNormalAndReducedPeriods(){

    }

}