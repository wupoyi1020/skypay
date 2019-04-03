# Run following commands before you run docker build.
# ./mvnw clean package
# mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-noverify","-XX:TieredStopAtLevel=1","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-Dspring.backgroundpreinitializer.ignore=true","-Dspring.jmx.enabled=false","-cp","app:app/lib/*","com.example.skypay.Application"]
