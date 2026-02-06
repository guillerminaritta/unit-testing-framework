package com.epam.tat.module4.tests;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class DivDoubleTest {

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

    @DataProvider(name = "divDoubleData")
    public Object[][] data() {
        return new Object[][]{
                {10.0, 2.0, 5.0},
                {-9.0, 3.0, -3.0}
        };
    }

    @Test(groups = {"regression"}, dataProvider = "divDoubleData")
    public void shouldDivDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }
}

