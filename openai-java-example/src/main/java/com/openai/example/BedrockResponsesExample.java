package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.BedrockOpenAIOkHttpClient;
import com.openai.models.responses.ResponseCreateParams;

public final class BedrockResponsesExample {
    private BedrockResponsesExample() {}

    public static void main(String[] args) {
        // Uses the standard AWS credential chain, including ~/.aws/credentials and AWS_PROFILE.
        OpenAIClient client =
                BedrockOpenAIOkHttpClient.builder().awsRegion("us-east-1").build();

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input("Say hello from OpenAI on Bedrock")
                .model("openai.gpt-5.5")
                .build();

        client.responses().create(params).output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .forEach(outputText -> System.out.println(outputText.text()));
    }
}
