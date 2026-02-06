package com.epam.tat.module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class IsPositiveTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("SETUP " + this + " thread=" + Thread.currentThread().getId());
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

    @DataProvider(name = "positiveData")
    public Object[][] positiveData() {
        return new Object[][]{
                {5L, true},
                {1L, true},
                {0L, false},
                {-3L, false}
        };
    }

    @Test(groups = {"smoke"}, dataProvider = "positiveData")
    public void shouldCheckIfValueIsPositive(long value, boolean expected) {
        Assert.assertEquals(calculator.isPositive(value), expected);
    }
}
