#!/bin/bash

git pull
mvn clean package -Dmaven.test.skip=true

docker rm -f huarui_dish
docker rmi -f huarui_dish:test
docker build -t huarui_dish:test .
docker run -d -p 6821:6821 --name huarui_dish huarui_dish:test java -Dspring.profiles.active=test -jar /app/app.jar
