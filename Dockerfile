FROM openjdk:8-jre-slim
WORKDIR /Engenharia-software-2-prj
COPY target/*.jar /facens_learn/facens_learn-0.0.1-SNAPSHOT.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar facens_learn-0.0.1-SNAPSHOT.jar