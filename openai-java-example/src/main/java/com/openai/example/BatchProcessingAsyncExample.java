package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.batches.Batch;
import com.openai.models.batches.BatchCreateParams;
import com.openai.models.batches.BatchCreateParams.CompletionWindow;
import com.openai.models.batches.BatchCreateParams.Endpoint;
import com.openai.models.files.FileCreateParams;
import com.openai.models.files.FileObject;
import com.openai.models.files.FilePurpose;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class BatchProcessingAsyncExample {
    private BatchProcessingAsyncExample() {}

    public static void main(String[] args) throws URISyntaxException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path requestsPath = Paths.get(classloader.getResource("requests.jsonl").toURI());

        FileCreateParams fileParams = FileCreateParams.builder()
                .purpose(FilePurpose.BATCH)
                .file(requestsPath)
                .build();
        CompletableFuture<FileObject> fileFuture = client.files().create(fileParams);

        CompletableFuture<Batch> batchFuture = fileFuture.thenComposeAsync(file -> {
            BatchCreateParams batchParams = BatchCreateParams.builder()
                    .inputFileId(file.id())
                    .endpoint(Endpoint.V1_CHAT_COMPLETIONS)
                    .completionWindow(CompletionWindow._24H)
                    .build();
            return client.batches().create(batchParams);
        });

        Executor delayedExecutor = CompletableFuture.delayedExecutor(1, TimeUnit.MINUTES);
        batchFuture = pollBatch(client, batchFuture, delayedExecutor);

        batchFuture
                .thenCompose(
                        batch -> client.files().content(batch.outputFileId().orElseThrow()))
                .thenAccept(response -> {
                    try (response) {
                        response.body().transferTo(System.out);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                })
                .join();
    }

    private static CompletableFuture<Batch> pollBatch(
            OpenAIClientAsync client, CompletableFuture<Batch> batchFuture, Executor delayedExecutor) {
        return batchFuture.thenComposeAsync(batch -> {
            if (batch.outputFileId().isPresent()) {
                return CompletableFuture.completedFuture(batch);
            }

            System.out.println("Polling...");
            return pollBatch(
                    client,
                    CompletableFuture.supplyAsync(() -> null, delayedExecutor)
                            .thenComposeAsync((unused) -> client.batches().retrieve(batch.id())),
                    delayedExecutor);
        });
    }
}
