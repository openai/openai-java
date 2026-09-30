package com.openai.example;

import com.openai.client.okhttp.OkHttpClient;
import com.openai.core.ClientOptions;
import com.openai.helpers.LiveConnection;
import com.openai.models.live.AudioFormat;
import com.openai.models.live.ClientEvent;
import com.openai.models.live.InputAudioAppendEvent;
import com.openai.models.live.ServerEvent;
import com.openai.models.live.SessionCloseEvent;
import com.openai.models.live.SessionConfig;
import com.openai.models.live.SessionStartEvent;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

/** Run with: ./gradlew :openai-java-example:run -Pexample=LiveWebSocket */
public final class LiveWebSocketExample {
    private LiveWebSocketExample() {}

    public static void main(String[] args) throws Exception {
        ClientOptions options = ClientOptions.builder()
                .fromEnv()
                .httpClient(OkHttpClient.builder().build())
                .build();
        try (LiveConnection connection = LiveConnection.connect(options)) {
            // Opening the transport does not start a Live session. Send the configuration explicitly.
            connection.send(ClientEvent.ofSessionStart(SessionStartEvent.builder()
                    .session(SessionConfig.builder()
                            .model("gpt-live-1")
                            .store(false)
                            .audio(SessionConfig.Audio.builder()
                                    .audioPcmFormat(AudioFormat.AudioPcm.Rate.of(24000L))
                                    .build())
                            .build())
                    .build()));
            while (true) {
                ServerEvent event = connection.receiveAsync().get(20, TimeUnit.SECONDS);
                if (event.isErrorEvent()) {
                    // Do not mistake session.closed after an error for success.
                    throw new IllegalStateException("Live returned an error event");
                }
                if (event.isSessionStarted()) {
                    // Three synthetic 20ms PCM16/24kHz frames; no microphone or recording needed.
                    String silence = Base64.getEncoder().encodeToString(new byte[960]);
                    for (int frame = 0; frame < 3; frame++) {
                        connection.send(ClientEvent.ofSessionInputAudioAppend(
                                InputAudioAppendEvent.builder().audio(silence).build()));
                        TimeUnit.MILLISECONDS.sleep(20);
                    }
                    connection.send(ClientEvent.ofSessionClose(
                            SessionCloseEvent.builder().build()));
                } else if (event.isSessionClosed()) {
                    System.out.println("Live session closed.");
                    break;
                }
            }
        } finally {
            options.close();
        }
    }
}
