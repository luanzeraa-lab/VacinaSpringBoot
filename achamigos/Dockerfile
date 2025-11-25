FROM eclipse-temurin:23-jdk

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests


RUN cp target/*.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]
