package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.http.HttpResponse;
import com.openai.models.batches.Batch;
import com.openai.models.batches.BatchCreateParams;
import com.openai.models.batches.BatchCreateParams.CompletionWindow;
import com.openai.models.batches.BatchCreateParams.Endpoint;
import com.openai.models.files.FileCreateParams;
import com.openai.models.files.FileObject;
import com.openai.models.files.FilePurpose;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class BatchProcessingExample {
    private BatchProcessingExample() {}

    public static void main(String[] args) throws URISyntaxException, InterruptedException, IOException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path requestsPath = Paths.get(classloader.getResource("requests.jsonl").toURI());

        FileCreateParams fileParams = FileCreateParams.builder()
                .purpose(FilePurpose.BATCH)
                .file(requestsPath)
                .build();
        FileObject file = client.files().create(fileParams);

        BatchCreateParams batchParams = BatchCreateParams.builder()
                .inputFileId(file.id())
                .endpoint(Endpoint.V1_CHAT_COMPLETIONS)
                .completionWindow(CompletionWindow._24H)
                .build();
        Batch batch = client.batches().create(batchParams);

        while (batch.outputFileId().isEmpty()) {
            System.out.println("Polling...");
            Thread.sleep(60_000);
            batch = client.batches().retrieve(batch.id());
        }

        try (HttpResponse response = client.files().content(batch.outputFileId().orElseThrow())) {
            response.body().transferTo(System.out);
        }
    }
}
