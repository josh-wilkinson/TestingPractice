package cm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
    Purpose: TDD tests for Rate class
    Author: Joshua Wilkinson
 */
public class RateTestTDD
{
    // VISITOR
    @DisplayName("Test VISITOR pays, expected 2.50")
    @Test
    void visitorPays(){
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        normalPeriods.add(new Period(7, 10));
        reducedPeriods.add(new Period(15, 17));
        reducedPeriods.add(new Period(13, 15));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(9, 13);
        assertEquals(2.50, r.calculate(periodStay).doubleValue());
    }

    // MANAGEMENT
    @DisplayName("Test MANAGEMENT pays five, expected 5.0")
    @Test
    void managementPaysFive(){
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(15, 17));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(9, 11);
        assertEquals(5.0, r.calculate(periodStay).doubleValue());
    }

    // STUDENT
    @DisplayName("Test STUDENT gets 33% discount, expected 5.90")
    @Test
    void studentGetsDiscount(){
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(9, 12));
        normalPeriods.add(new Period(14, 18));
        reducedPeriods.add(new Period(12, 14));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(0, 11);
        assertEquals(7.18, r.calculate(periodStay).doubleValue()); // the discount should apply after 5.50
    }

    // STAFF
    @DisplayName("Test STAFF pays max amount, expected 10")
    @Test
    void staffPaysMaxAmount(){
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();

        normalPeriods.add(new Period(10, 12));
        reducedPeriods.add(new Period(12, 14));

        Rate r = new Rate(kind, normalRate, reducedRate, normalPeriods, reducedPeriods);
        Period periodStay = new Period(10, 12);
        assertEquals(10, r.calculate(periodStay).doubleValue());
    }

}
