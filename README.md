Sogeti Hackathon Intelligent Speed Sign Project

Stack:
Azure
Java 8
Spring Boot

## Compile Jar
From the root directory: `mvn clean package`
The jar will be located in `target/APP-NAME-SNAPSHOT-1.0.jar`

## Upload Jar
From the root of the project
`scp target/PATH-TO-YOUR.jar azure@13.82.228.133:/home/azure/app.jar`

Then ssh into the box
`ssh azure@13.82.228.133`
Enter your password
from the /home/azure directory run `nohup java -jar app.jar &`

