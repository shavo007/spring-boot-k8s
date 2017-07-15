FROM  openjdk:8u131-jdk-alpine  
VOLUME /tmp  
WORKDIR /app  
COPY ./build/libs/demo-0.0.1-SNAPSHOT.jar .  
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/demo-0.0.1-SNAPSHOT.jar"]  
