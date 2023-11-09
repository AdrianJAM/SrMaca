# Etapa de construcción
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Copiar el archivo POM y descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente y compilar la aplicación
COPY src ./src
RUN mvn package -DskipTests -Dmaven.repo.local=/maven/repo

# Etapa de producción
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiar la caché de Maven desde la etapa de construcción
COPY --from=build /maven/repo /root/.m2

# Copiar el artefacto compilado (WAR)
COPY --from=build /app/target/srmaca-0.0.1-SNAPSHOT.war /app/srmaca.war

# Exponer el puerto en el que la aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "srmaca.war"]