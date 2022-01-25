# Setup Adligo's 2022 Jenkins build on your Mac;

Download and Install Tomcat;
- https://tomcat.apache.org/download-80.cgi
- https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.73/bin/apache-tomcat-8.5.73.tar.gz
 
Download and Install Jenkins the war file into your webapps folder;
- https://www.jenkins.io/download/

You should now be able to navigate to;
- http://localhost:8080/jenkins

Then add this code to a Execute Shell Step;
- mkdir $BUILD_NUMBER
- cd  $BUILD_NUMBER
- git clone git@github.com:adligo/2022.git
- cd  2022
- ./gitsub.sh -a
- gradle clean build --parallel
- ./moveTestXmlFiles.sh -j


Then install the following Jenkins plugins (if there not installed);
- JUnit (Note sometimes restarting tomcate multiple times is required)

Then create a Publish JUnit test result report at the bottom under Post-build Actions;
- Test report XMLs
- **/depot/tests/*.xml
