FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/88hub/mock_postgre.git

FROM maven:3.8.7-eclipse-temurin-19-alpine as build
WORKDIR /app
COPY --from=clone /app/mock_postgre /app
RUN mvn package

FROM openjdk:19-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/mock_postgre-0.0.1-SNAPSHOT.jar /app
COPY --from=build /app/src/main/resources/jolokia-jvm-1.7.1.jar /app
EXPOSE 8080
EXPOSE 8778
ENTRYPOINT ["sh", "-c"]
CMD ["java -javaagent:jolokia-jvm-1.7.1.jar=port=8778,host=0.0.0.0 -jar mock_postgre-0.0.1-SNAPSHOT.jar"] 






