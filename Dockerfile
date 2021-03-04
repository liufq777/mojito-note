# Dockerfile

FROM java:8
COPY target/mojito-note-1.0-SNAPSHOT.jar mojito-note.jar
ENTRYPOINT ["java","-jar","/mojito-note.jar","--spring.profiles.active=prod"]
EXPOSE 8086
