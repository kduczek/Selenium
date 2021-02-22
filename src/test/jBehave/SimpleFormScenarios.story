Scenario:  The scope of this test is to open given page, insert String and compare it.
Given a basic-first-form-demo.html of "https://www.seleniumeasy.com/test/"
When modal is displayed
Then modal is going to be closed
When I pass String My name is Krystian and click Show Message button
Then My name is Krystian is displayed

Scenario:  The scope of this test is to add two numbers and check if result matches.
Given a basic-first-form-demo.html of "https://www.seleniumeasy.com/test/"
When I pass 5 and 8 and click Get Total button
Then 13 is displayed in result text area

Scenario:  The scope of this test is to add number and special character and check if result is NaN.
Given a basic-first-form-demo.html of "https://www.seleniumeasy.com/test/"
When I pass 17 and !@#$%^&* and click Get Total button
Then NaN is displayed in result text area

Scenario:  The scope of this test is to input two strings and check if result is NaN.
Given a basic-first-form-demo.html of "https://www.seleniumeasy.com/test/"
When I pass Selenium and Test and click Get Total button
Then NaN is displayed in result text area

Scenario:  The scope of this test is to click Get Total button with two empty input fields and check if result is Nan.
Given a basic-first-form-demo.html of "https://www.seleniumeasy.com/test/"
When I click Get Total button with two empty input fields
Then NaN is displayed in result text area