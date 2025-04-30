package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.images.ImageGenerateParams;
import com.openai.models.images.ImageModel;
import java.io.IOException;

public final class ImageGenerationExample {
    private ImageGenerationExample() {}

    public static void main(String[] args) throws IOException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ImageGenerateParams imageGenerateParams = ImageGenerateParams.builder()
                .responseFormat(ImageGenerateParams.ResponseFormat.URL)
                .prompt("Two cats playing ping-pong")
                .model(ImageModel.DALL_E_2)
                .size(ImageGenerateParams.Size._512X512)
                .n(1)
                .build();

        client.images().generate(imageGenerateParams).data().orElseThrow().stream()
                .flatMap(image -> image.url().stream())
                .forEach(System.out::println);
    }
}
