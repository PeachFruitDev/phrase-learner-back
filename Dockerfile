FROM bellsoft/liberica-openjdk-alpine:17 AS phrase-learner-back

WORKDIR /back

COPY gradle/ gradle
COPY gradlew settings.gradle build.gradle ./
COPY src/ src

RUN mkdir -p ~/.gradle
RUN touch ~/.gradle/gradle.properties
RUN echo "org.gradle.daemon=false" >> ~/.gradle/gradle.properties
RUN ./gradlew build

EXPOSE 8080
CMD ["java", "-jar", "build/libs/phrase-learner-back-0.0.1-SNAPSHOT.jar"]
