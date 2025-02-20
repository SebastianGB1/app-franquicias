FROM openjdk:17-jdk-slim

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
COPY entrypoint.sh ./
RUN chmod +x ./entrypoint.sh

EXPOSE 8085
ENTRYPOINT ["./entrypoint.sh"]