Running Tests
Run the tests with the script below
$ mvn clean install
If you want to run the specific test, use the cucumber tags like this
$ mvn clean install -Dcucumber.filter.tags="@REPLACE_WITH_ANY_TAGS_THAT_YOU_WANT"
mvn clean install -Dcucumber.filter.tags="@HomePageDeviceManagerApp"

Test Results
Test report automatically generated on target folder after finished the test execution
See test report from target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html
