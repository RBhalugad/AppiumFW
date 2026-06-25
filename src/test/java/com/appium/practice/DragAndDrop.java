package com.appium.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class DragAndDrop extends BaseTest {

    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement source = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));

        dragAndDrop(source, 619, 948);

        Thread.sleep(3000);

        String resultText = driver.findElement(By.id("android:id/content")).getText();
        Assertions.assertTrue(resultText.contains("Dropped!"));

    }
}
