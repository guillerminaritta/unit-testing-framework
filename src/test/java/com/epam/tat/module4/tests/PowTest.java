package com.epam.tat.module4.tests;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class PowTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() { calculator = new Calculator(); }

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

    @DataProvider(name = "powData")
    public Object[][] data() {
        return new Object[][]{
                {2.0, 3.0, 8.0},
                {4.0, 2.7, 16.0} // floor(2.7)
        };
    }

    @Test(groups = {"regression"}, dataProvider = "powData")
    public void shouldPow(double a, double b, double expected) {
        Assert.assertEquals(calculator.pow(a, b), expected);
    }
}

