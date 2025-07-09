package com.openai.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.JsonObject;
import com.openai.core.JsonValue;
import com.openai.models.ChatModel;
import com.openai.models.responses.FunctionTool;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseFunctionToolCall;
import com.openai.models.responses.ResponseInputItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ResponsesFunctionCallingRawExample {
    private ResponsesFunctionCallingRawExample() {}

    static class SdkQuality {
        public String quality;

        public SdkQuality(String name, String evaluation) {
            quality = name + ": " + evaluation;
        }
    }

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        List<ResponseInputItem> inputs = new ArrayList<>();

        inputs.add(ResponseInputItem.ofMessage(ResponseInputItem.Message.builder()
                .addInputTextContent("What is the quality of the following SDKs and what do reviewers say: "
                        + "OpenAI Java SDK, Unknown Company SDK.")
                .role(ResponseInputItem.Message.Role.USER)
                .build()));

        // Use a `Builder` so that more messages can be appended below. When `build()` is called, it
        // creates an immutable object that is unaffected by future mutations of the builder.
        ResponseCreateParams.Builder createParamsBuilder = ResponseCreateParams.builder()
                .model(ChatModel.GPT_3_5_TURBO)
                .addTool(FunctionTool.builder()
                        .name("get-sdk-quality")
                        .description("Gets the quality of the given SDK.")
                        .parameters(FunctionTool.Parameters.builder()
                                .putAdditionalProperty("type", JsonValue.from("object"))
                                .putAdditionalProperty(
                                        "properties",
                                        JsonValue.from(Map.of(
                                                "name",
                                                Map.of("type", "string", "description", "The name of the SDK."))))
                                .putAdditionalProperty("required", JsonValue.from(List.of("name")))
                                .putAdditionalProperty("additionalProperties", JsonValue.from(false))
                                .build())
                        .strict(true)
                        .build())
                .addTool(FunctionTool.builder()
                        .name("get-sdk-score")
                        .description("Gets the review score (out of 10) for the given SDK.")
                        .parameters(FunctionTool.Parameters.builder()
                                .putAdditionalProperty("type", JsonValue.from("object"))
                                .putAdditionalProperty(
                                        "properties", JsonValue.from(Map.of("name", Map.of("type", "string"))))
                                .putAdditionalProperty("required", JsonValue.from(List.of("name")))
                                .putAdditionalProperty("additionalProperties", JsonValue.from(false))
                                .build())
                        .strict(true)
                        .build())
                .maxOutputTokens(2048)
                .input(ResponseCreateParams.Input.ofResponse(inputs));

        client.responses().create(createParamsBuilder.build()).output().forEach(item -> {
            if (item.isFunctionCall()) {
                ResponseFunctionToolCall functionCall = item.asFunctionCall();

                inputs.add(ResponseInputItem.ofFunctionCall(functionCall));
                inputs.add(ResponseInputItem.ofFunctionCallOutput(ResponseInputItem.FunctionCallOutput.builder()
                        .callId(functionCall.callId())
                        .output(callFunction(functionCall))
                        .build()));
            }
        });

        // Pass the function call results back to the model to complete the process.
        createParamsBuilder.input(ResponseCreateParams.Input.ofResponse(inputs));

        client.responses().create(createParamsBuilder.build()).output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .forEach(outputText -> System.out.println(outputText.text()));
    }

    private static String callFunction(ResponseFunctionToolCall function) {
        ObjectMapper mapper = new ObjectMapper();
        JsonValue arguments;

        try {
            arguments = JsonValue.from(mapper.readTree(function.arguments()));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Bad function arguments", e);
        }

        String sdkName = ((JsonObject) arguments).values().get("name").asStringOrThrow();
        Object result;

        switch (function.name()) {
            case "get-sdk-quality":
                result = new SdkQuality(sdkName, sdkName.contains("OpenAI") ? "It's robust and polished!" : "*shrug*");
                break;

            case "get-sdk-score":
                result = sdkName.contains("OpenAI") ? 10 : 3;
                break;

            default:
                throw new IllegalArgumentException("Unknown function: " + function.name());
        }

        try {
            return mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Bad function result", e);
        }
    }
}
