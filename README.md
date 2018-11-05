# lendico-assignment
Repayment Plan Generator

Created Web service for Repayment Plan Generator using Spring boot framework.

Pre - requisites - Install JRE and JDK 7 or higher above in your system.

Steps to follow to run the program.

1. Clone this project and import this project into workspace.
2. Do maven build either by command line or from eclipse setting goal as clean install which install all the packages defined in pom.xml
3. Right click on project -> Run as -> Java application, to start the server.

Using the link in the google dev tool or postman to check the API functionality
          http://localhost:8080/generate-plan
Before run, make sure right POST body request structure - JSON format is defined.
        Ideal body structure
        {
          "loanAmount": "2500",
          "nominalRate": 5.0,
          "duration": 24,
          "startDate": "2018-05-25T00:00:01Z"
        }
        And also, add make header as below
              Content-Type:application/json

Since, I have limited time, I did not created custom exceptions on my own like, handling invalid POST body structure.
I think, I covered at least Framework exceptions that can be triggered for any exceptions.
