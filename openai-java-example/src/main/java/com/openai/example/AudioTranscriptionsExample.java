package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.AudioModel;
import com.openai.models.AudioTranscriptionCreateParams;
import com.openai.models.Transcription;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class AudioTranscriptionsExample {
    private AudioTranscriptionsExample() {}

    public static void main(String[] args) throws Exception {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Path path = Paths.get(classloader.getResource("sports.wav").toURI());

        AudioTranscriptionCreateParams createParams = AudioTranscriptionCreateParams.builder()
                .file(path)
                .model(AudioModel.WHISPER_1)
                .build();

        Transcription transcription =
                client.audio().transcriptions().create(createParams).asTranscription();
        System.out.println(transcription.text());
    }
}
