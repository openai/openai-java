package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.*;

public final class ModelListExample {
    private ModelListExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        client.models()
                // TODO: Update this example once we support `.list()` without arguments.
                .list(ModelListParams.builder().build())
                .autoPager()
                .forEach(model -> System.out.println(model.id()));
    }
}
