package ali.artukov.spring_ai_java_assistant.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class AssistantService {


    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    public String giveResponse(String question) {
        log.info("USER: {}", question);

        String document = String.join("\n", findSimilarDocuments(question));
        log.info("DOCUMENT: {}", document);
        String answer = chatClient
                .prompt()
                .system(systemSpec -> systemSpec.param("document", document))
                .user(question)
                .call()
                .content();

        log.info("JAVA ASSISTANT: {}", answer);
        return answer;
    }

    private List<String> findSimilarDocuments(String message) {
        List<Document> similarDocuments = vectorStore.similaritySearch(SearchRequest.query(message).withTopK(3));
        return similarDocuments.stream().map(Document::getContent).toList();
    }
}
