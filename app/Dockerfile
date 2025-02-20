FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY . ./

COPY entrypoint.sh ./
RUN chmod +x ./entrypoint.sh

EXPOSE 8085
ENTRYPOINT ["./entrypoint.sh"]