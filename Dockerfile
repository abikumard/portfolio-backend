# Step 1: Java 21 environment ah set panrom (Eclipse Temurin Alpine image)
FROM eclipse-temurin:21-jdk-alpine

# Step 2: Un target folder la create aagura jar file ah ready pannu
ARG JAR_FILE=target/*.jar

# Step 3: Antha jar file ah Docker box kulla 'app.jar' nu copy pannu
COPY ${JAR_FILE} app.jar

# Step 4: Server start aagும்போது intha command-ah run panni app-ah on pannu
ENTRYPOINT ["java","-jar","/app.jar"]