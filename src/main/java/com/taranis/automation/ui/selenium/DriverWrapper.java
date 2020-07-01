package com.taranis.automation.ui.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.awaitility.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;


public class DriverWrapper implements WebDriver {
    private static WebDriver driver;
    private DriverWrapper(WebDriver driver) {
        DriverWrapper.driver = driver;
    }

    public static DriverWrapper open() {
        return createChromeInst();
    }

    //I would add here code to handle different browsers support (edge, firefox, IE)

    public File getScreenshotAsFile() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    private static DriverWrapper createChromeInst() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setHeadless(false); //true to launch headless (to use it from CI/CD tool for example)
//
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.SEVERE);
        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        ChromeDriverService service = ChromeDriverService.createDefaultService();
        driver = new ChromeDriver(service, options);
        return new DriverWrapper(driver);
    }

    public boolean isVisible(By by, Duration duration) {
        try {
            waitForElmVisibility(duration, by);
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    @Override
    public void get(String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    public WebElement waitForElmClickable(Duration duration, By by) {
        WebDriverWait wait = new WebDriverWait(driver, duration.getTimeUnit().toSeconds(duration.getValue()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElmVisibility(By by) {
        return waitForElmVisibility(Duration.TEN_SECONDS, by);
    }

    public boolean waitForWebElementVisibility(WebElement elem){
        return elem.isDisplayed();
    }

    public WebElement waitForElmVisibility(Duration duration, By by) {
        WebDriverWait wait = new WebDriverWait(driver, duration.getTimeUnit().toSeconds(duration.getValue()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
