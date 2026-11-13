package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.errors.OpenAIException;

public final class ModelListExample {
    private ModelListExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        try {
            client.models().list().autoPager().forEach(model -> System.out.println(model.idOrThrow()));
        } catch (OpenAIException e) {
            e.headers()
                    .flatMap(headers -> headers.values("x-request-id").stream().findFirst())
                    .ifPresent(id -> System.err.println("Request ID: " + id));
            throw e;
        }
    }
}
