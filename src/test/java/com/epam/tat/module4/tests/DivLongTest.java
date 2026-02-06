package com.epam.tat.module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class DivLongTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
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

    @Test(groups = {"regression"})
    public void shouldDivideLongValues() {
        long result = calculator.div(10L, 2L);
        Assert.assertEquals(result, 5L);
    }

    @Test(groups = {"regression"})
    public void shouldThrowExceptionWhenDivideByZero() {
        Assert.assertThrows(
                NumberFormatException.class,
                () -> calculator.div(10L, 0L)
        );
    }
}
