# Run following commands before you run docker build.
# ./mvnw clean package
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/skypay-gateway.jar app.jar
ENTRYPOINT ["java","-noverify","-XX:TieredStopAtLevel=1","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-Dspring.backgroundpreinitializer.ignore=true","-Dspring.jmx.enabled=false","-jar","/app.jar"]
