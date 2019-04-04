FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
ARG TARGET_BUILD=/tmp/microservice-demo-create-rdv
RUN mkdir -p $TARGET_BUILD
COPY pom.xml $TARGET_BUILD/..
COPY microservice-demo-create-rdv/pom.xml $TARGET_BUILD/
COPY microservice-demo-create-rdv/src $TARGET_BUILD/src/
WORKDIR $TARGET_BUILD
RUN mvn clean package

FROM frolvlad/alpine-java:jre8-slim
ARG TARGET_BUILD=/tmp/microservice-demo-create-rdv
EXPOSE 8080
COPY --from=MAVEN_TOOL_CHAIN $TARGET_BUILD/target/microservice-demo-create-rdv-0.0.1-SNAPSHOT.jar .
CMD /usr/bin/java -Xmx400m -Xms400m -jar microservice-demo-create-rdv-0.0.1-SNAPSHOT.jar
