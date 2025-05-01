FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/moments.jar moments.jar
ENTRYPOINT ["java","-jar","/moments.jar"]