package com.appium.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasic extends BaseTest {

    @Test
    public void AppiumTest() {

        // Actual Automation

        // Xpath,id,accessibilityId,ClassName,androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("preference")).click();
        // set wifi nam
        // tagName[@attribute='value']
        // tagName[@attribute='value' and @attribute2='value2']
        // tagName[@attribute='value' or @attribute2='value2']
        // tagName[contains(@attribute, 'value')]

        driver.findElement(AppiumBy.xpath("android.widget.TextView[@content-desc='3. Preference dependencies']"))
                .click();

        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        driver.findElement(AppiumBy.xpath("android.widget.TextView[@text='WiFi settings']")).click();

        String wifiName = driver.findElement(AppiumBy.xpath("android.widget.TextView[@text='WiFi settings']"))
                .getText();

        Assertions.assertEquals("WiFi settings", wifiName);

        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Text@123");

        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
}
