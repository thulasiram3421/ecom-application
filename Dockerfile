FROM eclipse-temurin:23-jre

COPY target/ecom-application-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]