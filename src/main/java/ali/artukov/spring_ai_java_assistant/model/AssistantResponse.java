package ali.artukov.spring_ai_java_assistant.model;

public record AssistantResponse(String question, int topK, String answer) {
}
