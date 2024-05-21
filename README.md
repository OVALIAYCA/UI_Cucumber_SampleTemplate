# UI_Cucumber_SampleTemplate

# SOME FEATURES IN FRAMEWORK
Run the parallel test case
mvn test -DsuiteXmlFile=testng.xml

Read PropManager from Properties file
Cucumber Report
Allure Report
Write Log.info to file
Take Screenshot failed test case
Read data test from Excel file (xlsx, csv, json,...)
Base function in the package: utilities
Use JavaFaker to generate data
ANSIColors
Two different Environments as stage and product

# Run single test from terminal
mvn clean test -Dtest=com.example.test.<TestName>
Example: mvn clean test -Dtest=com.example.tests.US01_ExampleTest
#change 

# Run single test suit
mvn clean test -DsuiteXmlFile=<name.xml>
Example:mvn clean test -DsuiteXmlFile=sanityTest.xml

### REPORTS
1. Cucumber Report

2. Allure Report

- Open Terminal: allure serve target/allure-results
 
  http://192.168.2.31:61215/index.html#graph

- Insert @Step("title/message") above @Test or any Method in the project
  
# Allure Reports
https://docs.qameta.io/allure/
[MAC OS]brew install allure
[Linux]sudo apt-add-repository ppa:qameta/allure
sudo apt-get update
sudo apt-get install allure
[Windows]scoop install allure
allure serve [PATH]/allure-results

# Produce Allure Report
mvn allure:report
mvn allure:serve


### OPENING A NEW BRANCH REQUIREMENTS
-Samples:
-feature/login-page
-feature/select-payment
-feature/register
-feature/order-history
-feature/open-application
-feature/men-category


### SYSTEM REQUIREMENTS
- * JDK 17 Amazon Coretto *
- IntelliJ is the best choice
