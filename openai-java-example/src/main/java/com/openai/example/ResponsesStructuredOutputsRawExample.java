package com.openai.example;

import static com.openai.models.responses.ResponseFormatTextJsonSchemaConfig.Schema;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.JsonValue;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseFormatTextJsonSchemaConfig;
import com.openai.models.responses.ResponseTextConfig;
import java.util.List;
import java.util.Map;

public final class ResponsesStructuredOutputsRawExample {
    private ResponsesStructuredOutputsRawExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        Schema schema = Schema.builder()
                .putAdditionalProperty("type", JsonValue.from("object"))
                .putAdditionalProperty(
                        "properties",
                        JsonValue.from(Map.of("employees", Map.of("type", "array", "items", Map.of("type", "string")))))
                .putAdditionalProperty("required", JsonValue.from(List.of("employees")))
                .putAdditionalProperty("additionalProperties", JsonValue.from(false))
                .build();
        ResponseTextConfig textConfig = ResponseTextConfig.builder()
                .format(ResponseFormatTextJsonSchemaConfig.builder()
                        .name("employees")
                        .schema(schema)
                        .strict(true)
                        .build())
                .build();

        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .input("Who works at OpenAI?")
                .text(textConfig)
                .model(ChatModel.GPT_4O)
                .build();

        client.responses().create(createParams).output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .forEach(outputText -> System.out.println(outputText.text()));
    }
}
