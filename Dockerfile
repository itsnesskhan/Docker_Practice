FROM openjdk:8
LABEL "maintainer" = "Nasser Khan"
LABEL "maintainer.email" = "itsnesskhan@gmail.com"
EXPOSE 8085
ADD target/docker-demo.jar docker-demo.jar
ENTRYPOINT ["java", "-jar", "docker-demo.jar"]