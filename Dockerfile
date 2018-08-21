RUN echo exit 0 > /usr/sbin/policy-rc.d

# Install dependencies
RUN apt-get update && apt-get install --assume-yes apt-utils
RUN apt-get update -y

# Install Java
RUN apt-get -y install default-jre

# Install JDK
RUN apt-get -y install default-jdk

# Install sudo
RUN apt-get -y install sudo

# Install wget
RUN apt-get -y install wget

# Install gnupg
RUN apt-get -y install gnupg

# Install vim
RUN apt-get -y install vim

# Install ant
RUN apt-get -y install ant

# Install unzip
RUN apt-get -y install unzip

# Install TestNG
RUN apt-get -y install testng

# Install xvfb
# May not be needed, since I should be able to run Chrome with --headless
#RUN apt-get -y install xvfb

# Install Jenkins
RUN wget -q -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add -
RUN sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
RUN sudo apt-get -y update
RUN sudo apt-get -y install jenkins

# Install Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
RUN sudo sh -c 'echo deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main > /etc/apt/sources.list.d/google-chrome.list'
RUN sudo apt-get -y update
RUN sudo apt-get -y install google-chrome-stable

# Install Chromedriver
RUN wget -q https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip
RUN unzip -o chromedriver_linux64.zip
RUN rm chromedriver_linux64.zip
RUN sudo mv -f /chromedriver usr/local/bin/chromedriver
RUN sudo chmod 0755 /usr/local/bin/chromedriver

# Install Selenium
RUN wget -q https://selenium-release.storage.googleapis.com/3.13/selenium-server-standalone-3.13.0.jar
RUN sudo mv -f selenium-server-standalone-3.13.0.jar /usr/local/bin/selenium-server-standalone.jar
RUN sudo chmod 0755 /usr/local/bin/selenium-server-standalone.jar

# Copy setup.sh from the EC2 instance into the Docker Container
COPY ./setup.sh /

# TEMPORARY TEST: Copy ChromeHeadlessTest.java from the EC2 instance into the Docker container
COPY ./ChromeHeadlessTest.java /

EXPOSE 8080

CMD ["/setup.sh"]
