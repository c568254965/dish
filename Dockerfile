FROM codenvy/jdk8_maven3_tomcat8
ADD target/huarui_disher-1.0-SNAPSHOT.jar /app/app.jar
CMD ["java","-jar","/app/app.jar"]
