# 2022
Note this project was abandoned and replaced by many other projects most notibly;

No Jdk 1.9 modules
- https://github.com/adligo/jse8-core.adligo.org

With Jdk 1.9 modules
- https://github.com/adligo/jse9-core.adligo.org

With Jdk 11 (and 1.9 modules)
- https://github.com/adligo/jse11-core.adligo.org

ON a default jre (jdk 17) (and 1.9 modules)
- https://github.com/adligo/jse-latest.adligo.org

This is a test to see if I can get gradle to work correctly at two levels like Adligo's Fabricate does.

## To use this project from a Mac, GitBash or Linux;
- git clone https://github.com/adligo/2022.git

Then you will need to upload a ssh key to github
Then download the other sub projects;
- cd 2022
- ./gitsub.sh

Finally build it with Java (I'm on 11) and Gradle (I'm on 7.3.3)
- gradle build --parallel
- ./moveTestXmlFiles.sh

For a single threaded build with specific versions
- ./build.sh

Additionally you can setup the Jenkins Build;

## Jenkins on Mac OS
- Mac / Linux Os; 
- https://github.com/adligo/2022.adligo.org/tree/main/jenkins/mac

## Jenkins on Windows
- https://github.com/adligo/2022.adligo.org/tree/main/jenkins/windows
