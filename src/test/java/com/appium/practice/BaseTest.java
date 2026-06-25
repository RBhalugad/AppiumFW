package com.appium.practice;

import java.io.File;
import java.net.URI;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeEach
    public void configureAppium() throws Exception {

        service = new AppiumServiceBuilder()
                .withAppiumJS(
                        new File("C:\\Users\\randh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();

        UiAutomator2Options option = new UiAutomator2Options();
        option.setPlatformName("Android");
        option.setDeviceName("PVVKHQ8LC6KF7HKN");
        option.setAutomationName("UiAutomator2");
        option.setIgnoreHiddenApiPolicyError(true);
        // option.setNoReset(true);
        option.setApp(new File("src/test/java/com/appium/practice/resources/ApiDemos-debug.apk").getAbsolutePath());

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), option);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        service.stop();
    }

    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration", 2000));

    }

    public void scrollToEnd() {
        boolean canScrollMore;

        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of(
                            "left", 100,
                            "top", 100,
                            "width", 200,
                            "height", 200,
                            "direction", "down",
                            "percent", 3));
        } while (canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 3));
    }

    public void dragAndDrop(WebElement source, int x, int y) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", x,
                "endY", y));
    }
}
