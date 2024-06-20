# Utiliser une image OpenJDK Runtime comme image parent
FROM openjdk:17-jdk-alpine
COPY target/emploxi.jar .
# Exposer le port sur lequel l'application va écouter
EXPOSE 9000
# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "emploxi.jar"]
