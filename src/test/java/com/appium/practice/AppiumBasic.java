package com.appium.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class AppiumBasic extends BaseTest {

    @Test
    public void AppiumTest() {
        // Xpath,id,accessibilityId,ClassName,androidUIAutomator

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assertions.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Rahul Wifi");

        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}
