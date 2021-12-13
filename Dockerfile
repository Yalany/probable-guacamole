FROM openjdk:17
COPY target/classes/com/yalany/regionstest/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","RegionsTestApplication"]


