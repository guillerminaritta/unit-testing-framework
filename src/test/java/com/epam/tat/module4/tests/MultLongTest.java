package com.epam.tat.module4.tests;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class MultLongTest {

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

    @DataProvider(name = "multLongData")
    public Object[][] data() {
        return new Object[][]{
                {2L, 3L, 6L},
                {-2L, 3L, -6L},
                {0L, 10L, 0L}
        };
    }

    @Test(groups = {"regression"}, dataProvider = "multLongData")
    public void shouldMultLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.mult(a, b), expected);
    }
}
