FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/app-franquicias-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

CMD ["sh", "-c", "java -jar -DDB_NAME=${DB_NAME:-franquicias} -DDB_HOST=${DB_HOST:-localhost} -DDB_PORT=${DB_PORT:-3306} -DDB_USER=${DB_USER:-root} -DDB_PASSWORD=${DB_PASSWORD} app.jar"]