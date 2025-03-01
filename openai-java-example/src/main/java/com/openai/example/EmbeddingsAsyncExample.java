package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.EmbeddingCreateParams;
import com.openai.models.EmbeddingModel;

public final class EmbeddingsAsyncExample {
    private EmbeddingsAsyncExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        EmbeddingCreateParams createParams = EmbeddingCreateParams.builder()
                .input("The quick brown fox jumped over the lazy dog")
                .model(EmbeddingModel.TEXT_EMBEDDING_3_SMALL)
                .build();

        client.embeddings().create(createParams).thenAccept(System.out::println).join();
    }
}
