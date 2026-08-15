package com.openai.example;

import com.openai.bedrock.BedrockEndpoint;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.BedrockOpenAIOkHttpClient;
import com.openai.core.http.StreamResponse;
import com.openai.models.chat.completions.ChatCompletionChunk;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public final class BedrockRuntimeChatExample {
    private BedrockRuntimeChatExample() {}

    public static void main(String[] args) {
        String region = environmentOrDefault("AWS_REGION", "us-east-1");
        String model = environmentOrDefault("BEDROCK_MODEL", "us.openai.gpt-5.6-sol");
        String auth = environmentOrDefault("BEDROCK_AUTH", "sigv4");

        BedrockOpenAIOkHttpClient.Builder builder = BedrockOpenAIOkHttpClient.builder()
                .endpoint(BedrockEndpoint.RUNTIME)
                .awsRegion(region);

        if ("bearer".equals(auth)) {
            String bearerToken = System.getenv("AWS_BEARER_TOKEN_BEDROCK");
            if (bearerToken == null || bearerToken.isBlank()) {
                throw new IllegalArgumentException("BEDROCK_AUTH=bearer requires AWS_BEARER_TOKEN_BEDROCK.");
            }
            builder.apiKey(bearerToken);
        } else if ("sigv4".equals(auth)) {
            String profile = System.getenv("AWS_PROFILE");
            if (profile != null && !profile.isBlank()) {
                // Explicit profiles take precedence over an environment bearer token.
                builder.awsProfile(profile);
            } else if (System.getenv("AWS_BEARER_TOKEN_BEDROCK") != null) {
                throw new IllegalArgumentException("Unset AWS_BEARER_TOKEN_BEDROCK or set AWS_PROFILE to use SigV4.");
            }
        } else {
            throw new IllegalArgumentException("BEDROCK_AUTH must be sigv4 or bearer.");
        }

        OpenAIClient client = builder.build();
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)
                .addUserMessage("Say hello from Amazon Bedrock Runtime")
                .build();

        try {
            if (Boolean.parseBoolean(System.getenv("BEDROCK_STREAM"))) {
                try (StreamResponse<ChatCompletionChunk> stream =
                        client.chat().completions().createStreaming(params)) {
                    stream.stream()
                            .flatMap(chunk -> chunk.choices().stream())
                            .flatMap(choice -> choice.delta().content().stream())
                            .forEach(System.out::print);
                }
                System.out.println();
            } else {
                client.chat().completions().create(params).choices().stream()
                        .flatMap(choice -> choice.message().content().stream())
                        .forEach(System.out::println);
            }
        } finally {
            client.close();
        }
    }

    private static String environmentOrDefault(String name, String defaultValue) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? defaultValue : value;
    }
}
