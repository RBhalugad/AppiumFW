package com.appium.practice;

import org.junit.jupiter.api.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

    @Test
    public void scrollUsingJavaScript() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollToEnd();
    }

    @Test
    public void scrollToTextByClass() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
                + ".scrollIntoView(new UiSelector().description(\"WebView\"));"));
    }

}
