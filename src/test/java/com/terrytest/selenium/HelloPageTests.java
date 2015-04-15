package com.terrytest.selenium;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by terry on 4/10/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class HelloPageTests {
    private Selenium selenium;
    private String seleniumHubHost = "localhost"; // IP or Hostname of Selenium Server
    private Integer seleniumHubPort = 4444; // Port of Selenium Server
    private String browserType = "*firefox"; // browser types
    private String appURL = "http://localhost:8181"; // application url to be tested

    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium(seleniumHubHost, seleniumHubPort, browserType, appURL);
        selenium.start();
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }

    @Test
    public void testHelloMessage() {
        /**
         *  Put your testing script in each unit test method
         */
        selenium.open(appURL);
        selenium.waitForPageToLoad("1000");
        Assert.assertEquals(selenium.getTitle(), "Hello");
    }
}
