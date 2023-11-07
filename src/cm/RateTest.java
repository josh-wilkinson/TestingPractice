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
        boolean overlapFlag = false;

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        for (int i = 0; i < normalPeriods.size()-1; i++){
            for (int j = i+1; j < normalPeriods.size(); j++){
                if (normalPeriods.get(i).overlaps(normalPeriods.get(j)))
                    overlapFlag = true;
            }
        }
        assertFalse(overlapFlag);
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

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);

        for (int i = 0; i < reducedPeriods.size()-1; i++){
            for (int j = i+1; j < reducedPeriods.size(); j++){
                if (reducedPeriods.get(i).overlaps(reducedPeriods.get(j)))
                    overlapFlag = true;
            }
        }
        assertFalse(overlapFlag);
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

            for (int i = 0; i < reducedPeriods.size()-1; i++){
                for (int j = i+1; j < reducedPeriods.size(); j++){
                    reducedPeriods.get(i).overlaps(reducedPeriods.get(j));
                }
            }
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

            for (int i = 0; i < normalPeriods.size()-1; i++){
                for (int j = i+1; j < normalPeriods.size(); j++){
                    normalPeriods.get(i).overlaps(normalPeriods.get(j));
                }
            }
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

            for (int i = 0; i < normalPeriods.size(); i++){
                for (int j = 0; j < reducedPeriods.size(); j++){
                    reducedPeriods.get(i).overlaps(normalPeriods.get(j));
                }
            }
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
        assertEquals(r.calculate(periodStay).intValue(), 0);
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
        assertEquals(r.calculate(periodStay).intValue(), 8);
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
        assertEquals(r.calculate(periodStay).intValue(), 4);
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
        assertEquals(r.calculate(periodStay).intValue(), 12);
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

}