## Setup

* Clone this repo
* Requires Java 11 or newer and Maven
* Export your [TestingBot credentials](https://testingbot.com/members/user/edit):

  ```
  export TESTINGBOT_KEY=<testingbot-key>
  export TESTINGBOT_SECRET=<testingbot-secret>
  ```

  (Alternatively, put them in the `key` and `secret` fields of the `*.conf.json` files in `src/test/resources/conf`.)

## Running your tests

- Upload your app to TestingBot using the Upload API. iOS simulators need a zipped `.app` simulator build; physical devices need an `.ipa`.

  ```
  curl -u "$TESTINGBOT_KEY:$TESTINGBOT_SECRET" -X POST "https://api.testingbot.com/v1/storage" -F "file=@/path/to/app/file/Application.zip"
  ```

- Set the `tb://...` app id returned by that call, or a public URL, as `TESTINGBOT_APP_ID`
  (or as `appium:app` in the `*.conf.json` files). If you don't have an app and simply want to try the service, use our sample simulator app:

  ```
  export TESTINGBOT_APP_ID=https://testingbot.com/appium/sample.zip
  ```

  (The physical-device build of the same app is https://testingbot.com/appium/sample.ipa. Use it with a real device configuration.)
- To run a single test, run `mvn test -P single`
- To run parallel tests, run `mvn test -P parallel`

## More
* You can view your test results on the [TestingBot dashboard](https://testingbot.com/members)
* Devices are configured in `src/test/resources/conf/*.conf.json` using W3C capabilities (`platformName`, `appium:deviceName`, `appium:platformVersion`).

## Additional Documentation
* [TestNG example](https://testingbot.com/support/app-automate/appium/java/testng)
