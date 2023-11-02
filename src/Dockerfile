# Use a lightweight Linux distribution
FROM adoptopenjdk:11-jre-hotspot-bionic

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/ProductRatingApp-1.2.1.jar app.jar

# Expose the port your Spring Boot app is running on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
