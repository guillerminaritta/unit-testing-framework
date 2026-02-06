package com.epam.tat.module4.tests;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class CtgTest {

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

    @Test(groups = {"regression"})
    public void shouldCtgActuallyReturnTanh() {
        Assert.assertEquals(calculator.ctg(1), Math.tanh(1));
    }
}

