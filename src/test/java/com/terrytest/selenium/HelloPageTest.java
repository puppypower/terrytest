package com.terrytest.selenium;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import junit.framework.TestCase;

/**
 * Created by terry on 4/10/15.
 */
public class HelloPageTest extends TestCase{
    private Selenium selenium;

    @Override
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8181");
        selenium.start();
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        selenium.stop();
        super.tearDown();
    }

    public void testHelloMessage() {
        selenium.open("http://localhost:8181");
        selenium.waitForPageToLoad("1000");
        assertEquals(selenium.getTitle(), "Hello");
    }
}
