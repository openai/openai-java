package com.openai.example;

import com.openai.client.okhttp.OkHttpClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.ClientOptions;
import com.openai.core.LogLevel;
import com.openai.helpers.TranslationConnection;
import com.openai.helpers.TranslationWebSocketOptions;
import com.openai.models.realtime.RealtimeTranslationClientEvent;
import com.openai.models.realtime.RealtimeTranslationClientSecretCreateRequest;
import com.openai.models.realtime.RealtimeTranslationInputAudioBufferAppendEvent;
import com.openai.models.realtime.RealtimeTranslationSessionCreateRequest;
import com.openai.models.realtime.translations.clientsecrets.ClientSecretCreateParams;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Translate a caller-provided raw PCM16, mono, 24 kHz file using an issued client secret.
 *
 * <p>Set OPENAI_API_KEY for server-side secret issuance, then run:
 * <pre>
 * ./gradlew :openai-java-example:run -Pexample=RealtimeTranslation --args="/path/to/input.pcm fr"
 * </pre>
 *
 * <p>The example issues a short-lived secret, opens a fresh token-only connection, streams input
 * while receiving output, and finishes by draining through session.closed. It stops input after two
 * minutes and bounds network waits. It supports the OpenAI API; Azure and Bedrock Translation are
 * not supported. Do not log or persist either credential.
 */
public final class RealtimeTranslationExample {
    private RealtimeTranslationExample() {}

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: RealtimeTranslation <input.pcm> <output-language>");
        }
        Path input = Path.of(args[0]);
        if (Files.size(input) == 0 || Files.size(input) % 2 != 0) {
            throw new IllegalArgumentException("Input must contain complete PCM16 samples.");
        }
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException("Set OPENAI_API_KEY for server-side secret issuance.");
        }
        String model = "gpt-realtime-translate";
        var issuer = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .timeout(Duration.ofSeconds(20))
                .logLevel(LogLevel.OFF)
                .build();
        try (AutoCloseable closeIssuer = issuer::close) {
            // Issue the short-lived secret on your server. Never expose the main API key to clients.
            var session = RealtimeTranslationSessionCreateRequest.builder()
                    .model(model)
                    .audio(RealtimeTranslationSessionCreateRequest.Audio.builder()
                            .output(RealtimeTranslationSessionCreateRequest.Audio.Output.builder()
                                    .language(args[1])
                                    .build())
                            .build())
                    .build();
            var secret = issuer.realtime()
                    .translations()
                    .clientSecrets()
                    .create(ClientSecretCreateParams.builder()
                            .realtimeTranslationClientSecretCreateRequest(
                                    RealtimeTranslationClientSecretCreateRequest.builder()
                                            .session(session)
                                            .build())
                            .build());

            try (var http = OkHttpClient.builder().build();
                    InputStream audio = Files.newInputStream(input)) {
                // A fresh client uses only the issued token, without ambient API keys or headers.
                // In an application, pass this secret to the client over your authenticated channel.
                var options = ClientOptions.builder()
                        .httpClient(http)
                        .apiKey(secret.value())
                        .timeout(Duration.ofSeconds(20))
                        .logLevel(LogLevel.OFF)
                        .build();
                var readerPool = Executors.newSingleThreadExecutor(runnable -> {
                    Thread thread = new Thread(runnable, "translation-example-reader");
                    thread.setDaemon(true);
                    return thread;
                });
                // Reverse-order cleanup closes the socket before waiting for the reader to exit.
                try (AutoCloseable closeOptions = options::close;
                        AutoCloseable stopReader = () -> {
                            readerPool.shutdownNow();
                            if (!readerPool.awaitTermination(5, TimeUnit.SECONDS)) {
                                throw new IllegalStateException("Translation reader did not stop.");
                            }
                        };
                        var connection = TranslationConnection.connect(
                                options,
                                TranslationWebSocketOptions.builder()
                                        .model(model)
                                        .sendTimeout(Duration.ofSeconds(5))
                                        .build())) {
                    // One receiver consumes output while input is sent and finish waits for closure.
                    var reader = readerPool.submit(() -> {
                        while (true) {
                            var event = connection.receiveAsync().get(30, TimeUnit.SECONDS);
                            if (event.isError()) {
                                throw new IllegalStateException("Translation returned an error event.");
                            }
                            if (event.isSessionOutputTranscriptDelta()) {
                                System.out.print(
                                        event.asSessionOutputTranscriptDelta().delta());
                            }
                            // event.asSessionOutputAudioDelta().delta() contains translated audio
                            // when event.isSessionOutputAudioDelta() is true.
                            if (event.isSessionClosed()) {
                                return null;
                            }
                        }
                    });
                    long deadline = System.nanoTime() + TimeUnit.MINUTES.toNanos(2);
                    byte[] chunk;
                    while ((chunk = audio.readNBytes(2400)).length != 0) {
                        if (System.nanoTime() >= deadline) {
                            throw new IllegalStateException("Example input timeout; use a shorter audio file.");
                        }
                        if (reader.isDone()) {
                            reader.get();
                            throw new IllegalStateException("Translation closed before input finished.");
                        }
                        connection.send(RealtimeTranslationClientEvent.ofSessionInputAudioBufferAppend(
                                RealtimeTranslationInputAudioBufferAppendEvent.builder()
                                        .audio(Base64.getEncoder().encodeToString(chunk))
                                        .build()));
                        TimeUnit.MILLISECONDS.sleep(50); // 2,400 bytes represent 50 ms of audio.
                    }
                    // close() aborts; finish() sends session.close and waits for validated closure.
                    connection.finish(Duration.ofSeconds(30));
                    reader.get(35, TimeUnit.SECONDS); // Drain all final output through session.closed.
                    System.out.println();
                }
            }
        }
    }
}
