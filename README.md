# General
This short Java Selenium WebDriver based project implements simple UI test for Herolo page: https://automation.herolo.co.il/
Tests run by TestNG, the project managed with Maven.

# Instructions
This project in build and run on Windows based machine.
1) To run this project you first need to download this project files
2) Run the project with TestNG or Maven build
3) Find the run results and the screenshot in reports folder in location you load the project

#Tests
1) test that the relevant web site is opened by open the webSite and get the title and avoid popup
2) test that if user submit empty form, the errors are as expected at the footer form, and avoid the popup
3) test that if user fill the form correct and click submit, the user lands at the currect "Thank you page", and avoid the popup
5) if user click on WhatsApp link the user land at whatsApp page and procced to the chat, and avoid the popup
6) (these test combined with the WhatsApp link) if user click on WhatsApp link the user land at whatsApp page and procced to the chat and the correct mobile number as expected, and avoid the popup
7) check that the projects number at the carousel that user see is as expected, and avoid the popup
8) test that if user submit empty form at the footer, the errors number are as expected, and avoid the popup
9) test that the correct link to facebook is working and the user land at the right page of Herolo, and avoid the popup
10) if user submit full correct form at the footer the user lands at "Thank you page", and avoid the popup
