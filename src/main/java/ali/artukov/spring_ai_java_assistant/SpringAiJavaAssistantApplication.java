package ali.artukov.spring_ai_java_assistant;

import ali.artukov.spring_ai_java_assistant.config.HintsRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.shell.command.annotation.CommandScan;


@ImportRuntimeHints(HintsRegistrar.class)
@CommandScan
@SpringBootApplication
public class SpringAiJavaAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiJavaAssistantApplication.class, args);
    }
}
