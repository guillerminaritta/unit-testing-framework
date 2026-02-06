package com.epam.tat.module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumDoubleTest {

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

    @DataProvider(name = "sumDoubleData")
    public Object[][] data() {
        return new Object[][]{
                {2.5, 2.5, 5.0},
                {-1.2, 1.2, 0.0},
                {0.0, 0.0, 0.0}
        };
    }

    @Test(groups = {"smoke","regression"}, dataProvider = "sumDoubleData")
    public void shouldSumDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.sum(a, b), expected);
    }
}
