package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.JsonValue;
import com.openai.models.ChatModel;
import com.openai.models.ResponseFormatJsonSchema;
import com.openai.models.ResponseFormatJsonSchema.JsonSchema;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import java.util.Map;

public final class StructuredOutputsAsyncExample {
    private StructuredOutputsAsyncExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        // TODO: Update this once we support extracting JSON schemas from Java classes
        JsonSchema.Schema schema = JsonSchema.Schema.builder()
                .putAdditionalProperty("type", JsonValue.from("object"))
                .putAdditionalProperty(
                        "properties", JsonValue.from(Map.of("employees", Map.of("items", Map.of("type", "string")))))
                .build();
        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4O_MINI)
                .maxCompletionTokens(2048)
                .responseFormat(ResponseFormatJsonSchema.builder()
                        .jsonSchema(JsonSchema.builder()
                                .name("employee-list")
                                .schema(schema)
                                .build())
                        .build())
                .addUserMessage("Who works at OpenAI?")
                .build();

        client.chat()
                .completions()
                .create(createParams)
                .thenAccept(completion -> completion.choices().stream()
                        .flatMap(choice -> choice.message().content().stream())
                        .forEach(System.out::println))
                .join();
    }
}
