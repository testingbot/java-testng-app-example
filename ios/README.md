## Setup

* Clone this repo
* Install all dependencies `mvn compile`
* Update the `*.conf.json` files inside the `src/test/resources/conf` directory with your [TestingBot Credentials](https://testingbot.com/members/user/edit)

## Running your tests

- Upload your IPA file to TestingBot using the Upload API:

  ```
  curl -u "key:secret" -X POST "https://api.testingbot.com/v1/storage" -F "file=@/path/to/app/file/Application-debug.ipa"
  ```

- If you don't have an IPA and simply want to test our service, we have a sample IPA: https://testingbot.com/appium/sample.ipa
- Update the desired capability "app" with the App URL returned from the above API call
- To run a single test, run `mvn test -P single`
- To run parallel tests, run `mvn test -P parallel`

## More
* You can view your test results on the [TestingBot dashboard](https://testingbot.com/members)
* You can export the environment variables for the Key and Secret of your TestingBot account.

  ```
  export TESTINGBOT_KEY=<testingbot-key> &&
  export TESTINGBOT_SECRET=<testingbot-secret>
  ```

## Additional Documentation
* [TestNG example](https://testingbot.com/support/mobile/testng.html)
