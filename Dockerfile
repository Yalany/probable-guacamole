FROM openjdk:17
COPY target/regions-test-0.0.1-SNAPSHOT.jar regions-test-0.0.1-SNAPSHOT.jar
CMD java -jar regions-test-0.0.1-SNAPSHOT.jar
