## TestingBot - Java & TestNG

TestingBot provides a grid of browsers and mobile devices to run Automated tests.
This example demonstrates how to use Java with TestNG and Appium to run a test on a mobile device.

The repository contains two Maven projects:

* [`android`](android/README.md): runs the sample calculator app on an Android emulator
* [`ios`](ios/README.md): runs the sample calculator app on an iOS simulator

### Requirements

* Java 11 or newer
* [Maven](https://maven.apache.org/install.html)

### Environment Setup

1. Clone this repository
2. Add your TestingBot Key and Secret as environment variables. You can find these in the [TestingBot Dashboard](https://testingbot.com/members/).
    ```
    $ export TESTINGBOT_KEY=<your TestingBot Key>
    $ export TESTINGBOT_SECRET=<your TestingBot Secret>
    ```
3. Tell the test which app to use, either an app you uploaded to TestingBot Storage (`tb://...`) or a public URL.
   To try it out, use the sample app:
    ```
    # Android
    $ export TESTINGBOT_APP_ID=https://testingbot.com/appium/sample.apk
    # iOS simulator
    $ export TESTINGBOT_APP_ID=https://testingbot.com/appium/sample.zip
    ```

### Running Tests

```
$ cd android   # or: cd ios
$ mvn test -P single
```

To run on two devices in parallel, use `mvn test -P parallel`.

You will see the test result in the [TestingBot Dashboard](https://testingbot.com/members/).

### Resources
##### [TestingBot TestNG Documentation](https://testingbot.com/support/app-automate/appium/java/testng)

##### [Appium Documentation](https://appium.io/)
