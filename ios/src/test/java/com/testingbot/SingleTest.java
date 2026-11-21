package com.testingbot;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SingleTest extends TestingBotTestNGTest {

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // On iOS the accessibility id also matches the label next to each field,
        // so select the text fields explicitly.
        WebElement inputA = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.iOSNsPredicateString("name == 'inputA' AND type == 'XCUIElementTypeTextField'")));
        inputA.clear(); // the field starts with "0"
        inputA.sendKeys("10");

        WebElement inputB = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.iOSNsPredicateString("name == 'inputB' AND type == 'XCUIElementTypeTextField'")));
        inputB.clear();
        inputB.sendKeys("5");

        WebElement sum = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.iOSNsPredicateString("name == 'sum' AND type == 'XCUIElementTypeTextField'")));
        Assert.assertEquals(sum.getText(), "15");
    }
}
