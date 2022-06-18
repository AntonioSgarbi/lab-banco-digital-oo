FROM openjdk:18-jdk-oraclelinux7

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

ENV PROFILE prod
ENV SERVER_PORT 8080

ENV DB_USER postgres
ENV DB_PASS postgres
ENV DB_IP localhost
ENV DB_ALIAS banco_digital
ENV DB_PORT 5432

ENV JWT_SECRET aa713c1f-8025-4ce4-bfe8-0a8ea6110eea
ENV JWT_EXPIRATION_MS 4320000
ENV REFRESH_EXPIRATION_MS 2592000000
ENV GENERATE_PASSWORD senha123
ENV CAIXA_ELETRONICO_TOKEN tok3n

ENTRYPOINT ["java", "-jar", "application.jar",\
    "--server.port=${SERVER_PORT}",\
    "--spring.profiles.active=${PROFILE}",\
    "--spring.datasource.username=${DB_USER}",\
    "--spring.datasource.password=${DB_PASS}",\
    "--spring.datasource.url=jdbc:postgresql://${DB_IP}:${DB_PORT}/${DB_ALIAS}",\
    "--personal.security.jwtSecret=${JWT_SECRET}",\
    "--personal.security.jwtExpirationMs=${JWT_EXPIRATION_MS}",\
    "--personal.security.jwtRefreshExpirationMs=${JWT_EXPIRATION_MS}",\
    "--personal.security.nova-senha=${GENERATE_PASSWORD}",\
    "--personal.mock.token=${CAIXA_ELETRONICO_TOKEN}" ]

EXPOSE $SERVER_PORT