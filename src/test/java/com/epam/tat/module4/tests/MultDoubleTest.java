package com.epam.tat.module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class MultDoubleTest {

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

    @DataProvider(name = "multDoubleData")
    public Object[][] multDoubleData() {
        return new Object[][]{
                {2.5, 2.0, 5.0},
                {2.2, 2.0, 4.0} // floor(4.4) = 4.0
        };
    }

    @Test(groups = {"regression"}, dataProvider = "multDoubleData")
    public void shouldMultiplyDoubleValues(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expected);
    }
}
