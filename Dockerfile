
# Run Stage
FROM openjdk:17
COPY target/auth0demo-0.0.1-SNAPSHOT.jar auth0demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/auth0demo-0.0.1-SNAPSHOT.jar"]
