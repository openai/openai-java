package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.AudioModel;
import com.openai.models.AudioTranscriptionCreateParams;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class AudioTranscriptionsAsyncExample {
    private AudioTranscriptionsAsyncExample() {}

    public static void main(String[] args) throws Exception {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path path = Paths.get(classloader.getResource("sports.wav").toURI());

        AudioTranscriptionCreateParams createParams = AudioTranscriptionCreateParams.builder()
                .file(path)
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
