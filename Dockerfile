FROM openjdk:17-jdk-slim

# Instalar Git e Maven
RUN apt-get update && apt-get install -y git maven && rm -rf /var/lib/apt/lists/*

# Defina o diretório de trabalho
WORKDIR /app

# Clone o projeto diretamente do GitHub
RUN git clone https://github.com/FBCRD/docker.git .

# Compilar o projeto
RUN mvn clean package -DskipTests

# Criar a pasta de logs
RUN mkdir -p /app/logs

# Expor a porta 8080
EXPOSE 8080

# Inicializar a aplicação
ENTRYPOINT ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
