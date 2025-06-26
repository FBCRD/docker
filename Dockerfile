FROM maven:3.9.6-eclipse-temurin-17 AS build

# Clona o repositório
WORKDIR /app
RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/fbcrd/docker.git projeto

# Compila o projeto
WORKDIR /app/projeto
RUN mvn clean package -DskipTests





FROM jboss/wildfly:latest

# Instala o driver JDBC do PostgreSQL
RUN curl -L -o /opt/jboss/wildfly/standalone/deployments/postgresql.jar https://jdbc.postgresql.org/download/postgresql-42.7.3.jar

# Copia o WAR da aplicação para ser implantado
COPY target/*.war /opt/jboss/wildfly/standalone/deployments/

# Expõe a porta padrão do WildFly
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
