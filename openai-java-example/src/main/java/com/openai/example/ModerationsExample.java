package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ModerationCreateParams;
import com.openai.models.ModerationModel;

public final class ModerationsExample {
    private ModerationsExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ModerationCreateParams createParams = ModerationCreateParams.builder()
                .input("I want to kill them.")
                .model(ModerationModel.OMNI_MODERATION_LATEST)
                .build();

        System.out.println(client.moderations().create(createParams));
    }
}
