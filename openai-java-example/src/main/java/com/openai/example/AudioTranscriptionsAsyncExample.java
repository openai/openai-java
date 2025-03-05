package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.MultipartField;
import com.openai.models.AudioModel;
import com.openai.models.AudioTranscriptionCreateParams;
import java.io.IOException;

public final class AudioTranscriptionsAsyncExample {
    private AudioTranscriptionsAsyncExample() {}

    public static void main(String[] args) throws IOException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String filename = "sports.wav";

        AudioTranscriptionCreateParams createParams = AudioTranscriptionCreateParams.builder()
                .file(MultipartField.<byte[]>builder()
                        .value(classloader.getResourceAsStream(filename).readAllBytes())
                        .filename(filename)
                        .build())
                .model(AudioModel.WHISPER_1)
                .build();

        client.audio()
                .transcriptions()
                .create(createParams)
                .thenAccept(response ->
                        System.out.println(response.asTranscription().text()))
                .join();
    }
}
