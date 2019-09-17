FROM openjdk:11
ADD ./target/financial-adapter-0.0.1-SNAPSHOT.jar /usr/src/financial-adapter-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
EXPOSE 8081
ENTRYPOINT ["java","-jar","financial-adapter-0.0.1-SNAPSHOT.jar"]