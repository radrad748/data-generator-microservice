FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/*.jar appl.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "appl.jar"]