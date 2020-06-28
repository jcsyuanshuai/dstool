FROM maven:3.5-jdk-8 as builder
COPY ./src /app/src
COPY ./pom.xml /app
RUN mvn -f /app/pom.xml clean package


FROM openjdk:8-jdk-alpine
COPY --from=builder /app/target/cdss-extractor-*.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 6060