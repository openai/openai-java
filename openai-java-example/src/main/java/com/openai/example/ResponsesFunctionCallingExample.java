package com.openai.example;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseFunctionToolCall;
import com.openai.models.responses.ResponseInputItem;
import java.util.ArrayList;
import java.util.List;

public final class ResponsesFunctionCallingExample {
    private ResponsesFunctionCallingExample() {}

    //    @JsonTypeName("get-sdk-quality")
    @JsonClassDescription("Gets the quality of the given SDK.")
    static class GetSdkQuality {
        @JsonPropertyDescription("The name of the SDK.")
        public String name;

        public SdkQuality execute() {
            return new SdkQuality(name, name.contains("OpenAI") ? "It's robust and polished!" : "*shrug*");
        }
    }

    static class SdkQuality {
        public String quality;

        public SdkQuality(String name, String evaluation) {
            quality = name + ": " + evaluation;
        }
    }

    @JsonClassDescription("Gets the review score (out of 10) for the given SDK.")
    static class GetSdkScore {
        public String name;

        public int execute() {
            return name.contains("OpenAI") ? 10 : 3;
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
                .addTool(GetSdkQuality.class)
                .addTool(GetSdkScore.class)
                .maxOutputTokens(2048)
                .input(ResponseCreateParams.Input.ofResponse(inputs));

        client.responses().create(createParamsBuilder.build()).output().forEach(item -> {
            if (item.isFunctionCall()) {
                ResponseFunctionToolCall functionCall = item.asFunctionCall();

                inputs.add(ResponseInputItem.ofFunctionCall(functionCall));
                inputs.add(ResponseInputItem.ofFunctionCallOutput(ResponseInputItem.FunctionCallOutput.builder()
                        .callId(functionCall.callId())
                        .outputAsJson(callFunction(functionCall))
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

    private static Object callFunction(ResponseFunctionToolCall function) {
        switch (function.name()) {
            case "GetSdkQuality":
                return function.arguments(GetSdkQuality.class).execute();
            case "GetSdkScore":
                return function.arguments(GetSdkScore.class).execute();
            default:
                throw new IllegalArgumentException("Unknown function: " + function.name());
        }
    }
}
