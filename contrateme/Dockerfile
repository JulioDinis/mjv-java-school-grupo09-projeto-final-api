# Etapa 1: Usar a imagem base com JDK 11
FROM openjdk:11-jdk AS build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o código-fonte para o contêiner
COPY . .

# Definir variáveis de ambiente para o Maven
ENV MAVEN_OPTS="-Dmaven.repo.local=/app/.m2/repository"

# Construir o projeto usando o Maven Wrapper
RUN ./mvnw clean install -DskipTests

# Etapa 2: Usar a imagem base do JDK 11 para o runtime
FROM openjdk:11-jre-slim

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR gerado para o contêiner
COPY --from=build /app/target/contrateme-1.0.0-SNAPSHOT.jar /app/my-app.jar

# Expor a porta que o aplicativo vai rodar
EXPOSE 8080

# Comando para rodar o aplicativo
CMD ["java", "-jar", "/app/my-app.jar"]
