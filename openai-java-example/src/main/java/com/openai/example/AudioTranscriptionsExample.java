package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.MultipartField;
import com.openai.models.AudioModel;
import com.openai.models.AudioTranscriptionCreateParams;
import com.openai.models.Transcription;
import java.io.IOException;

public final class AudioTranscriptionsExample {
    private AudioTranscriptionsExample() {}

    public static void main(String[] args) throws IOException {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String filename = "sports.wav";

        AudioTranscriptionCreateParams createParams = AudioTranscriptionCreateParams.builder()
                .file(MultipartField.<byte[]>builder()
                        .value(classloader.getResourceAsStream(filename).readAllBytes())
                        .filename(filename)
                        .build())
                .model(AudioModel.WHISPER_1)
                .build();

        Transcription transcription =
                client.audio().transcriptions().create(createParams).asTranscription();
        System.out.println(transcription.text());
    }
}
