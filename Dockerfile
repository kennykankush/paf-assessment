FROM maven:3.9.9-eclipse-temurin-23 AS builder

WORKDIR /app

COPY movies/. .

RUN mvn package -Dmaven.test.skip=true

FROM maven:3.9.9-eclipse-temurin-23

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar
COPY --from=builder /app/movies_post_2010.zip movies_post_2010.zip

ENV PORT=8080

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar /app/app.jar -Dserver.port=${PORT}