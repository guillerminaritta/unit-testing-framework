package com.epam.tat.module4.tests;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SqrtTest {

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

    @DataProvider(name = "sqrtData")
    public Object[][] data() {
        return new Object[][]{
                {9.0, 3.0},
                {-9.0, 3.0}
        };
    }

    @Test(groups = {"regression"}, dataProvider = "sqrtData")
    public void shouldSqrt(double a, double expected) {
        Assert.assertEquals(calculator.sqrt(a), expected);
    }
}

