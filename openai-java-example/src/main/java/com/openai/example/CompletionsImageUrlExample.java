package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionContentPart;
import com.openai.models.chat.completions.ChatCompletionContentPartImage;
import com.openai.models.chat.completions.ChatCompletionContentPartText;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.List;

public final class CompletionsImageUrlExample {
    private CompletionsImageUrlExample() {}

    public static void main(String[] args) throws URISyntaxException, InterruptedException, IOException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        byte[] logoBytes = classloader.getResource("logo.png").openStream().readAllBytes();
        String logoBase64Url = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(logoBytes);

        ChatCompletionContentPart logoContentPart =
                ChatCompletionContentPart.ofImageUrl(ChatCompletionContentPartImage.builder()
                        .imageUrl(ChatCompletionContentPartImage.ImageUrl.builder()
                                .url(logoBase64Url)
                                .build())
                        .build());
        ChatCompletionContentPart questionContentPart =
                ChatCompletionContentPart.ofText(ChatCompletionContentPartText.builder()
                        .text("Describe this image.")
                        .build());
        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4O_MINI)
                .maxCompletionTokens(2048)
                .addUserMessageOfArrayOfContentParts(List.of(questionContentPart, logoContentPart))
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);
    }
}
