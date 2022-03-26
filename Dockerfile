FROM openjdk:17

ENV TZ Asia/Tokyo

COPY build/libs/batchdemo-0.0.1-SNAPSHOT.jar /usr/local/bin/batchdemo.jar
ENTRYPOINT ["java","-jar","/usr/local/bin/batchdemo.jar"]