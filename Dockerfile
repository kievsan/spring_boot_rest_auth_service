FROM openjdk:21

VOLUME /tmp
EXPOSE 8080
EXPOSE 8081

ADD /target/spring_boot_rest_auth_service-0.0.1-SNAPSHOT.jar rest_app.jar

ENTRYPOINT ["java","-jar","/rest_app.jar"]
