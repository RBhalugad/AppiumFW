package com.appium.practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest {

    @Test
    public void swipeDemo() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();

        driver.findElement(By.xpath("//android.widget.TextViews[@text='1. Photos']")).click();

        WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));

        System.out.println(firstImage.getAttribute("focusable"));
        // Swipe Left
        swipeAction(firstImage, "left");
        System.out.println(firstImage.getAttribute("focusable"));

    }
}
