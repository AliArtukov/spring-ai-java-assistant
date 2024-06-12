package ali.artukov.spring_ai_java_assistant.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ServiceConfig {

    @Value("classpath:/prompts/java-assistant-reference.st")
    private Resource resource;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem(resource)
                .build();
    }
}
