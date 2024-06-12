package ali.artukov.spring_ai_java_assistant.shell;

import ali.artukov.spring_ai_java_assistant.service.AssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.shell.command.annotation.Command;

@Command
@RequiredArgsConstructor
public class AssistantShell {

    private final AssistantService assistantService;

    @Command(command = "question")
    public String assistant(@DefaultValue(value = "What is Java?") String question) {
        return assistantService.giveResponse(question);
    }
}
