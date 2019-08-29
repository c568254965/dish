#!/bin/bash

git pull
mvn clean package -Dmaven.test.skip=true

docker rm -f huarui_dish
docker rmi -f c568254965/huarui_dish:v1.0
docker build -t c568254965/huarui_dish:v1.0 .
docker run -d -p 6822:6822 --name huarui_dish c568254965/huarui_dish:v1.0 java -Dspring.profiles.active=test -jar /app/app.jar
