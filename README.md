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
        <version>3.3.0</version>
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
        <spring-shell.version>3.3.0</spring-shell.version>
        <vaadin.version>24.4.1</vaadin.version>
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
        <dependency>
            <groupId>org.springframework.shell</groupId>
            <artifactId>spring-shell-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
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
            <dependency>
                <groupId>org.springframework.shell</groupId>
                <artifactId>spring-shell-dependencies</artifactId>
                <version>${spring-shell.version}</version>
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

I called GET method [/assistant](http://localhost:8080/assistant) without params and received the following response:

```markdown
Java is a general-purpose, concurrent, class-based, object-oriented programming language. It is designed to be simple
enough for many programmers to achieve fluency. Java is related to C and C++ but is organized differently, omitting some
features of these languages and incorporating ideas from other languages. It is intended for production use rather than
research, avoiding untested features.

Java is strongly and statically typed, with clear distinctions between compile-time errors and run-time errors. It is a
relatively high-level language that abstracts away details of machine representation and includes automatic storage
management, typically using a garbage collector. Java does not include unsafe constructs like unchecked array accesses,
ensuring programs behave in a specified manner.

Java programs are normally compiled to a machine-independent bytecode, which is executed by the Java Virtual Machine (
JVM).
```

I called GET
method [/assistant?question=When published Java 22? Write list of Java 22 writers](http://localhost:8080/assistant?question=When%20published%20Java%2022%3F%20Write%20list%20of%20Java%2022%20writers)
and received the
following response:

```markdown
Java SE 22 Edition was published on March 2024.

The writers of the Java SE 22 Edition are:

1. James Gosling
2. Bill Joy
3. Guy Steele
4. Gilad Bracha
5. Alex Buckley
6. Daniel Smith
7. Gavin Bierman
```
