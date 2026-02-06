package com.epam.tat.module4.tests;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class IsNegativeTest {

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

    @DataProvider(name = "negativeData")
    public Object[][] data() {
        return new Object[][]{
                {-1L, true},
                {0L, false},
                {5L, false}
        };
    }

    @Test(groups = {"smoke"}, dataProvider = "negativeData")
    public void shouldCheckIsNegative(long value, boolean expected) {
        Assert.assertEquals(calculator.isNegative(value), expected);
    }
}

