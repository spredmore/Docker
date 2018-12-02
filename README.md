# Docker
Repository for utilizing Docker to run various deployment and testing tools.

Compile ChromeHeadlessTest.java: javac -cp ".:/usr/local/bin/selenium-server-standalone.jar:/usr/share/java/testng.jar" ChromeHeadlessTest.java

Execute ChromeHeadlessTest: java -cp ".:/usr/local/bin/selenium-server-standalone.jar:/usr/share/java/testng.jar" ChromeHeadlessTest

--------------------

Compile and execute TestA.java

javac -cp ".:/usr/local/bin/selenium-server-standalone.jar:/usr/share/java/testng.jar" /Selenium/src/com/test/TestA.java -d /Selenium/bin/

java -cp ".:/usr/local/bin/selenium-server-standalone.jar:/usr/share/java/testng.jar:/Selenium/bin/" org.testng.TestNG /Selenium/src/testng.xml