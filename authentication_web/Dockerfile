FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM tomcat:10-jdk17
RUN rm -rf /usr/local/tomcat/webapps/ROOT

ADD https://repo1.maven.org/maven2/org/redisson/redisson-all/3.40.2/redisson-all-3.40.2.jar /usr/local/tomcat/lib/
ADD https://repo1.maven.org/maven2/org/redisson/redisson-tomcat-10/3.40.2/redisson-tomcat-10-3.40.2.jar /usr/local/tomcat/lib/
COPY redisson.yaml /usr/local/tomcat/conf/redisson.yaml
COPY --from=build /app/target/hello-servlet.war /usr/local/tomcat/webapps/ROOT.war