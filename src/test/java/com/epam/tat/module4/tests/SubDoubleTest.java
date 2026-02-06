package com.epam.tat.module4.tests;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SubDoubleTest {

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

    @DataProvider(name = "subDoubleData")
    public Object[][] data() {
        return new Object[][]{
                {5.5, 2.5, 3.0},
                {2.0, 5.0, -3.0}
        };
    }

    @Test(groups = {"regression"}, dataProvider = "subDoubleData")
    public void shouldSubDouble(double a, double b, double expected) {
        Assert.assertEquals(calculator.sub(a, b), expected);
    }
}

