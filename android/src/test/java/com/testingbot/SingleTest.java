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

        WebElement inputA = wait.until(
            ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("inputA")));
        inputA.sendKeys("10");

        WebElement inputB = wait.until(
            ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("inputB")));
        inputB.sendKeys("5");

        WebElement sum = wait.until(
            ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("sum")));
        wait.until(ExpectedConditions.textToBePresentInElement(sum, "15"));
        Assert.assertEquals(sum.getText(), "15");
    }
}
