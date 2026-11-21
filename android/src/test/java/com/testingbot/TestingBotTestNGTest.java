package com.testingbot;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;

public class TestingBotTestNGTest {
    public AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"config", "environment"})
    @SuppressWarnings("unchecked")
    public void setUp(String configFile, String environment) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + configFile));
        JSONObject envs = (JSONObject) config.get("environments");

        MutableCapabilities capabilities = new MutableCapabilities();

        // Device specific capabilities (platformName, appium:deviceName, appium:platformVersion)
        Map<String, Object> envCapabilities = (Map<String, Object>) envs.get(environment);
        envCapabilities.forEach(capabilities::setCapability);

        // Capabilities shared by all devices (appium:app, tb:options)
        Map<String, Object> commonCapabilities = (Map<String, Object>) config.get("capabilities");
        commonCapabilities.forEach((name, value) -> {
            if (capabilities.getCapability(name) == null) {
                capabilities.setCapability(name, value);
            }
        });

        String key = System.getenv("TESTINGBOT_KEY");
        if (key == null) {
            key = (String) config.get("key");
        }

        String secret = System.getenv("TESTINGBOT_SECRET");
        if (secret == null) {
            secret = (String) config.get("secret");
        }

        Map<String, Object> tbOptions = new HashMap<>();
        Object configuredOptions = capabilities.getCapability("tb:options");
        if (configuredOptions instanceof Map) {
            tbOptions.putAll((Map<String, Object>) configuredOptions);
        }
        tbOptions.put("key", key);
        tbOptions.put("secret", secret);
        capabilities.setCapability("tb:options", tbOptions);

        String app = System.getenv("TESTINGBOT_APP_ID");
        if (app != null && !app.isEmpty()) {
            capabilities.setCapability("appium:app", app);
        }

        driver = new AndroidDriver(new URL("https://" + config.get("server") + "/wd/hub"), capabilities);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver == null) {
            return;
        }
        try {
            driver.executeScript("tb:test-result=" + (result.isSuccess() ? "passed" : "failed"));
        } finally {
            driver.quit();
        }
    }
}
