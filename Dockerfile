FROM maven:3.8-openjdk-11-slim AS builder

LABEL maintainer="ppovis@uoc.edu"

WORKDIR /code:
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:11
WORKDIR /app
COPY --from=builder /code/target/paracasa.jar ./target/paracasa.jar
ENTRYPOINT ["java","-jar","target/paracasa.jar"]