package com.epam.tat.module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumLongTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println("SETUP " + this + " thread=" + Thread.currentThread().getId());
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            if (calculator != null) {
                calculator = null;
            }
        } catch (Exception e) {
            // Ignorar: la sesión puede ya estar cerrada/crasheada
        } finally {
            calculator = null;
        }
    }

    @DataProvider(name = "sumLongData")
    public Object[][] sumLongData() {
        return new Object[][]{
                {2L, 3L, 5L},
                {-5L, 10L, 5L},
                {0L, 0L, 0L}
        };
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "sumLongData")
    public void shouldSumLongValues(long a, long b, long expected) {
        System.out.println("TEST " + this + " thread=" + Thread.currentThread().getId() + " calc=" + calculator);
        long result = calculator.sum(a, b);
        Assert.assertEquals(result, expected);
    }
}
