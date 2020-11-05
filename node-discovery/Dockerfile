FROM openjdk:8-jdk-alpine
WORKDIR /disc
COPY target/node-discovery-1.0.0.jar xyz.jar
EXPOSE 5555
ENV JAVA_PARAMETRELERI="-Xmx256m -Xmn256m"
ENTRYPOINT [ "sh","-c","java -jar ${JAVA_PARAMETRELERI} xyz.jar"]

