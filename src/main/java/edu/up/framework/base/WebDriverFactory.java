package edu.up.framework.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class WebDriverFactory {
    private final static Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    private static int iPosX;
    private static int iPosY;

    static WebDriver createInstance(){
        WebDriver driver;
        DesiredCapabilities desiredCapabilities;
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-extensions");
        desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setBrowserName("chrome");
        driver = new ChromeDriver(options);

        Random rn = new Random();
        iPosX = rn.nextInt(600 - 50 + 1) + 50;
        iPosY = rn.nextInt(100 - 10 + 1) + 40;
        driver.manage().window().setPosition(new Point(iPosX, iPosY));
        driver.manage().window().setSize(new Dimension(1000, 800));
        logger.info("Thread id = " + Thread.currentThread().getId());
        logger.info("Hashcode failure Web Driver: " + driver.hashCode());
        logger.info("Browser selected: "+desiredCapabilities.getBrowserName());


        return  driver;
    }
}
