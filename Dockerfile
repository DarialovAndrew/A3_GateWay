FROM openjdk:11
EXPOSE 8891
ADD target/GateWay-0.0.1-SNAPSHOT.jar GateWay-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","GateWay-0.0.1-SNAPSHOT.jar"]