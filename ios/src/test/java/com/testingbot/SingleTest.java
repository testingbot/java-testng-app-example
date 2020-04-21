package com.testingbot;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;


public class SingleTest extends TestingBotTestNGTest {

  @Test
  public void test() throws Exception {
    IOSElement inputA = (IOSElement) new WebDriverWait(driver, 30).until(
      ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("inputA")));
    inputA.sendKeys("10");
    IOSElement inputB = (IOSElement) new WebDriverWait(driver, 30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("inputB")));
    inputB.sendKeys("5");
  }
}
