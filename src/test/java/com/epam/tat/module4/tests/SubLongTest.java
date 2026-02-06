package com.epam.tat.module4.tests;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SubLongTest {

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

    @DataProvider(name = "subLongData")
    public Object[][] data() {
        return new Object[][]{
                {5L, 3L, 2L},
                {3L, 5L, -2L},
                {0L, 0L, 0L}
        };
    }

    @Test(groups = {"regression"}, dataProvider = "subLongData")
    public void shouldSubLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.sub(a, b), expected);
    }
}

