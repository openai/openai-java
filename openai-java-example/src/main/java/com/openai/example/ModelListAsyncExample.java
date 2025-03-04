package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.ModelListPageAsync;
import java.util.concurrent.CompletableFuture;

public final class ModelListAsyncExample {
    private ModelListAsyncExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        CompletableFuture<ModelListPageAsync> pageFuture = client.models().list();
        pageFuture
                .thenComposeAsync(page -> page.autoPager()
                        .forEach(
                                model -> {
                                    System.out.println(model.id());
                                    // Keep iterating
                                    return true;
                                },
                                pageFuture.defaultExecutor()))
                .join();
    }
}
