FROM gradle:6.6.1-jdk11 as compile

WORKDIR /home/gradle/project

# Only copy dependency-related files
# COPY build.gradle settings.gradle /home/gradle/project/

# Only download dependencies
# Eat the expected build failure since no source code has been copied yet
# RUN gradle clean build --no-daemon > /dev/null 2>&1 || true
COPY . /home/gradle/project
RUN mkdir /home/gradle/mount

RUN gradle clean bootJar

ENTRYPOINT ["java","-jar","/home/gradle/project/build/libs/mureng-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080