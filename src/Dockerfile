FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/ProductRatingApp-1.2.1.jar
ADD ProductRatingApp-1.2.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]