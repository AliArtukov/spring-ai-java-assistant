package ali.artukov.spring_ai_java_assistant.controller;

import ali.artukov.spring_ai_java_assistant.model.AssistantResponse;
import ali.artukov.spring_ai_java_assistant.service.AssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AssistantController {

    private final AssistantService assistantService;

    @PostMapping(value = "/simple-assistant", produces = "application/json")
    public AssistantResponse simpleAssistant(@RequestParam(value = "question", defaultValue = "When published Java 22?") String question) {
        return assistantService.giveResponse(question, false);
    }

    @PostMapping(value = "/java-assistant", produces = "application/json")
    public AssistantResponse javaAssistant(@RequestParam(value = "question", defaultValue = "When published Java 22?") String question) {
        return assistantService.giveResponse(question, true);
    }
}
