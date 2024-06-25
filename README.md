# spring-ai-java-assistant

## AI assistant for chatting about java features

Our
project's [spring initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.3.0&packaging=jar&jvmVersion=21&groupId=ali.artukov&artifactId=spring-ai-java-assistant&name=spring-ai-java-assistant&description=AI%20assistant%20for%20chatting%20about%20java%20features&packageName=ali.artukov.spring-ai-java-assistant&dependencies=spring-ai-openai,web,lombok,spring-ai-vectordb-pgvector,actuator,docker-compose,spring-shell)
Plus added next dependencies:

```xml

<dependencies>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.ai</groupId>
        <artifactId>spring-ai-pdf-document-reader</artifactId>
    </dependency>
</dependencies>
```

Full content of `pom.xml` file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.1</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>ali.artukov</groupId>
    <artifactId>spring-ai-java-assistant</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-ai-java-assistant</name>
    <description>AI assistant for chatting about java features</description>
    <properties>
        <java.version>21</java.version>
        <spring-ai.version>1.0.0-M1</spring-ai.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-openai-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-pgvector-store-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-docker-compose</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.5.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-pdf-document-reader</artifactId>
        </dependency>
    </dependencies>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.ai</groupId>
                <artifactId>spring-ai-bom</artifactId>
                <version>${spring-ai.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

</project>
```

# How to run

- Clone project from my [github repository](https://github.com/AliArtukov/spring-ai-java-assistant)
- Create OPENAI_API_KEY variable with your openai api kiy value
- Run next commands:

 ```shell
mvn spring-boot:run
 ```

- Open swagger page http://localhost:8080/swagger in your browser
- Use all the methods and have fun

# Result

I called GET
method [/api/simple-assistant?question=When published Java 22?](http://localhost:8080/api/simple-assistant?question=When%20published%20Java%2022%3F)
and received the
following response:

```json
{
  "question": "When published Java 22?",
  "topK": 3,
  "answer": "Java SE 22 is scheduled to be released in March 2024."
}
```

I called GET
method [/api/java-assistant?question=When published Java 22?](http://localhost:8080/api/java-assistant?question=When%20published%20Java%2022%3F)
and received the
following response:

```json
{
  "question": "When published Java 22?",
  "topK": 3,
  "answer": "Java SE 22 was published in March 2024."
}
```
