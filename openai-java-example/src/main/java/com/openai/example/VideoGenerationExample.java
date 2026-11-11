package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.videos.Video;
import com.openai.models.videos.VideoCreateParams;
import com.openai.models.videos.VideoModel;

public final class VideoGenerationExample {
    private VideoGenerationExample() {}

    public static void main(String[] args) throws InterruptedException {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        VideoCreateParams params = VideoCreateParams.builder()
                .model(VideoModel.SORA_2)
                .prompt("A video of the words 'Thank you' in sparkling letters")
                .build();

        Video video = client.videos().create(params);

        // Poll until video is completed or failed
        while (video.statusOrThrow() != Video.Status.COMPLETED && video.statusOrThrow() != Video.Status.FAILED) {
            System.out.println("Polling... Progress: " + video.progressOrThrow() + "%");
            Thread.sleep(10_000); // Poll every 10 seconds
            video = client.videos().retrieve(video.idOrThrow());
        }

        if (video.statusOrThrow() == Video.Status.COMPLETED) {
            System.out.println("Video successfully completed!");
            System.out.println("Video ID: " + video.idOrThrow());
        } else {
            System.out.println("Video creation did not complete. Status: " + video.statusOrThrow());
            video.error().ifPresent(error -> {
                System.out.println("Error: " + error);
            });
        }
    }
}
