package com.openai.example;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.*;
import java.util.Collection;

public final class FunctionCallingExample {
    private FunctionCallingExample() {}

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

    @JsonClassDescription("Gets the review score (out of 10) for the named SDK.")
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

        // Use a `Builder` so that more messages can be appended below. When `build()` is called, it
        // creates an immutable object that is unaffected by future mutations of the builder.
        ChatCompletionCreateParams.Builder createParamsBuilder = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_3_5_TURBO)
                .maxCompletionTokens(2048)
                .addTool(GetSdkQuality.class)
                .addTool(GetSdkScore.class)
                .addUserMessage("How good are the following SDKs and what do reviewers say: "
                        + "OpenAI Java SDK, Unknown Company SDK.");

        client.chat().completions().create(createParamsBuilder.build()).choices().stream()
                .map(ChatCompletion.Choice::message)
                // Add each assistant message onto the builder so that we keep track of the
                // conversation for asking a follow-up question later.
                .peek(createParamsBuilder::addMessage)
                .flatMap(message -> {
                    message.content().ifPresent(System.out::println);
                    return message.toolCalls().stream().flatMap(Collection::stream);
                })
                .forEach(toolCall -> {
                    Object result = callFunction(toolCall.function());
                    // Add the tool call result to the conversation.
                    createParamsBuilder.addMessage(ChatCompletionToolMessageParam.builder()
                            .toolCallId(toolCall.id())
                            .contentAsJson(result)
                            .build());
                });

        // Ask a follow-up question about the function call result.
        createParamsBuilder.addUserMessage("Why do you say that?");
        client.chat().completions().create(createParamsBuilder.build()).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);
    }

    private static Object callFunction(ChatCompletionMessageToolCall.Function function) {
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
