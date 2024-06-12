package ali.artukov.spring_ai_java_assistant.controller;

import ali.artukov.spring_ai_java_assistant.service.AssistantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assistant")
public class AssistantController {

    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @GetMapping(produces = "text/markdown")
    public String assistant(@RequestParam(value = "question", defaultValue = "What is Java?") String question) {
        return assistantService.giveResponse(question);
    }
}
