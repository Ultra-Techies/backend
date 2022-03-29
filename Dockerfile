FROM openjdk:17
EXPOSE 8080
ADD build/libs/demo-v1.jar tushughuli-v1.jar
ENTRYPOINT ["java","-jar","/tushughuli-v1.jar"]
