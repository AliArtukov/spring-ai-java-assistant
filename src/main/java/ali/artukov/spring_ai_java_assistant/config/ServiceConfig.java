package ali.artukov.spring_ai_java_assistant.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@Log4j2
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class ServiceConfig {

    @Value("classpath:/java-assistant-reference.st")
    private Resource javaAssistantReference;

    @Value("classpath:/docs/Java-SE-22.pdf")
    private Resource java22DocumentReference;
    private final VectorStore vectorStore;
    private final JdbcClient jdbcClient;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, PgVectorStore vectorStore) {
        return builder
                .defaultSystem(javaAssistantReference)
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore, SearchRequest.defaults()))
                .build();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void embeddingJava22Doc() {
        Integer count = jdbcClient.sql("select count(*) from vector_store")
                .query(Integer.class)
                .single();

        log.info("Count of data in vector store: {}", count);

        if (count == 0) {
            PdfDocumentReaderConfig config = PdfDocumentReaderConfig.builder()
                    .withPageExtractedTextFormatter(new ExtractedTextFormatter.Builder()
                            .withNumberOfBottomTextLinesToDelete(0)
                            .withNumberOfTopPagesToSkipBeforeDelete(0)
                            .build())
                    .withPagesPerDocument(1)
                    .build();

            PagePdfDocumentReader pdfReader = new PagePdfDocumentReader(java22DocumentReference, config);
            TokenTextSplitter tokenTextSplitter = new TokenTextSplitter();
            List<Document> apply = tokenTextSplitter.apply(pdfReader.get());
            vectorStore.accept(apply);
            log.info("Embedding Java 22 Doc");
        }
    }
}
