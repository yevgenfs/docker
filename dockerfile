FROM maven as build

WORKDIR /

ADD . .
RUN mvn clean package
# RUN mvn dependency:copy-dependencies
#RUN mvn clean compile assembly:single

FROM openjdk:8


ARG JAR_FILE=target/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
