package com.juaracoding.appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import com.juaracoding.appium.pages.CalculatorPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculator {

    private static AndroidDriver<MobileElement> driver;
    private CalculatorPage calculator;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "21081111RG");
        capabilities.setCapability("uuid", "haiv9ds8wkvkjr55");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        calculator = new CalculatorPage(driver);
    }

    @Test(priority = 1)
    public void testTambah() {
        calculator.calcTambah();
        System.out.println("Hasil 1 + 2 = " + calculator.getTxtResult());
        assertEquals(calculator.getTxtResult(), "3");
    }

    @Test(priority = 2)
    public void testPerkalian() {
        delay(2);
        calculator.calcKali();
        System.out.println("Hasil 3 x 4 = " + calculator.getTxtResult());
        assertEquals(calculator.getTxtResult(), "12");
    }

    @AfterClass
    public void closeApp()
    {
        delay(1);
        driver.quit();
    }

    static void delay(long second) {
        System.out.println("Delay");
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
