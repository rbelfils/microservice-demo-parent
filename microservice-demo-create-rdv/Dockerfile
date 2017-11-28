FROM frolvlad/alpine-oraclejdk8:latest
COPY target/microservice-demo-create-rdv-0.0.1-SNAPSHOT.jar .
CMD /usr/bin/java -Xmx400m -Xms400m -jar microservice-demo-create-rdv-0.0.1-SNAPSHOT.jar
EXPOSE 8080