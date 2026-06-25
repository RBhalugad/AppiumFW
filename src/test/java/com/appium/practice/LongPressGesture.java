package com.appium.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class LongPressGesture extends BaseTest {

    @Test
    public void longPressGesture() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable  List']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(ele);

        // Assert the popup appeared
        boolean isDisplayed = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']"))
                .isDisplayed();
        Assertions.assertTrue(isDisplayed);
    }
}