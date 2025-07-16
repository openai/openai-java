package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.http.StreamResponse;
import com.openai.models.images.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public final class ImageStreamingExample {
    private ImageStreamingExample() {}

    public static void main(String[] args) throws IOException {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        System.out.println("Starting image streaming example...");

        ImageGenerateParams params = ImageGenerateParams.builder()
                .model(ImageModel.GPT_IMAGE_1)
                .prompt("A cute baby sea otter")
                .n(1L)
                .size(ImageGenerateParams.Size._1024X1024)
                .partialImages(3L)
                .build();

        StreamResponse<ImageGenStreamEvent> stream = client.images().generateStreaming(params);

        stream.stream().forEach(event -> {
            try {
                if (event.isGenerationPartialImage()) {
                    ImageGenPartialImageEvent partialEvent = event.asGenerationPartialImage();
                    System.out.printf("  Partial image %d/3 received%n", partialEvent.partialImageIndex() + 1);
                    System.out.printf(
                            "   Size: %d characters (base64)%n",
                            partialEvent.b64Json().length());

                    // Save partial image to file
                    String filename = String.format("partial_%d.png", partialEvent.partialImageIndex() + 1);
                    saveBase64Image(partialEvent.b64Json(), filename);
                    Path absolutePath = Paths.get(filename).toAbsolutePath();
                    System.out.printf("   💾 Saved to: %s%n", absolutePath);

                } else if (event.isGenerationCompleted()) {
                    ImageGenCompletedEvent completedEvent = event.asGenerationCompleted();
                    System.out.println("\n✅ Final image completed!");
                    System.out.printf(
                            "   Size: %d characters (base64)%n",
                            completedEvent.b64Json().length());

                    // Save final image to file
                    String filename = "final_image.png";
                    saveBase64Image(completedEvent.b64Json(), filename);
                    Path absolutePath = Paths.get(filename).toAbsolutePath();
                    System.out.printf("   💾 Saved to: %s%n", absolutePath);

                } else {
                    System.out.println("❓ Unknown event received");
                }
            } catch (IOException e) {
                System.err.println("Error saving image: " + e.getMessage());
            }
        });

        System.out.println("Image streaming completed!");
    }

    private static void saveBase64Image(String b64Data, String filename) throws IOException {
        byte[] imageData = Base64.getDecoder().decode(b64Data);
        Files.write(Paths.get(filename), imageData);
    }
}
