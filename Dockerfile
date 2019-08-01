FROM java:latest

ADD target/huarui_dishes-1.0-SNAPSHOT.jar /app/app.jar
CMD ["java","-jar","-Dspring.profiles.active=test","/app/app.jar"]
