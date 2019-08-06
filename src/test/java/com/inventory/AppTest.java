package com.inventory;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testAppHasAGreeting() {
        Inventory classUnderTest = new Inventory();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
