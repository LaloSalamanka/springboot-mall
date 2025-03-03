# 使用 Maven 和 JDK 17 來構建專案
FROM maven:3.8.4-openjdk-17 AS build

# 設定工作目錄
WORKDIR /app

# 複製專案的 pom.xml 並執行 Maven 來下載依賴
COPY pom.xml .
RUN mvn dependency:go-offline

# 複製專案的源碼並構建專案
COPY src ./src
RUN mvn clean package -DskipTests

# 使用 JDK 17 作為基礎鏡像來執行應用
FROM openjdk:17-jdk-slim

# 設定工作目錄
WORKDIR /app

# 複製在構建階段生成的 jar 檔案
COPY --from=build /app/target/springboot-mall-0.0.1-SNAPSHOT.jar .

# 讓其他開發者或容器工具知道你的應用程式在哪個端口上運行
EXPOSE 8080

# 執行 Spring Boot 應用
ENTRYPOINT ["java", "-jar", "/app/springboot-mall-0.0.1-SNAPSHOT.jar"]
