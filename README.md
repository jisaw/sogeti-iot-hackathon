Sogeti Hackathon Intelligent Speed Sign Project

Stack:
Azure
Java 8
Spring Boot

## Build Jar
From the root directory: `mvn clean package`

The jar will be located in `target/APP-NAME-SNAPSHOT-1.0.jar`

## Upload Jar
From the root of the project

`scp target/PATH-TO-YOUR.jar azure@13.82.228.133:/home/azure/app.jar`

Then ssh into the box

`ssh azure@13.82.228.133`

Enter your password

from the /home/azure directory run `nohup java -jar app.jar -Dserver.port=8080 &`

## Deploying a new version
SSH into the server

Find the current running process using `ps -aux | grep java`

This will give you a PID. Use that to kill the process using `kill -9 PID`

Then to re-run the app rrun `nohup java -jar app.jar -Dserver.port=8080 &`
