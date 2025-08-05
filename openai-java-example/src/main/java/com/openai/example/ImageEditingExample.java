package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.MultipartField;
import com.openai.models.images.ImageEditParams;
import com.openai.models.images.ImageEditParams.Image;
import com.openai.models.images.ImageModel;
import java.io.InputStream;

public final class ImageEditingExample {
    private ImageEditingExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The OPENAI_API_KEY environment variable
        // - The OPENAI_BASE_URL and AZURE_OPENAI_KEY environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String alohaFilename = "aloha.png";
        InputStream alohaStream = classloader.getResourceAsStream(alohaFilename);
        String maskFilename = "aloha-mask.png";
        InputStream maskStream = classloader.getResourceAsStream(maskFilename);

        ImageEditParams editParams = ImageEditParams.builder()
                .responseFormat(ImageEditParams.ResponseFormat.URL)
                .image(MultipartField.<Image>builder()
                        .value(
                                // Or use `Image.ofInputStreams` and pass a `List` to edit multiple images.
                                Image.ofInputStream(alohaStream))
                        .contentType("image/png")
                        .filename(alohaFilename)
                        .build())
                .mask(MultipartField.<InputStream>builder()
                        .value(maskStream)
                        .contentType("image/png")
                        .filename(maskFilename)
                        .build())
                .prompt("Fill the mask area with sand.")
                .model(ImageModel.DALL_E_2)
                .n(1)
                .build();

        client.images().edit(editParams).data().orElseThrow().stream()
                .flatMap(image -> image.url().stream())
                .forEach(System.out::println);
    }
}
