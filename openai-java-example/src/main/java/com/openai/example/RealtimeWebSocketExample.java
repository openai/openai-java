package com.openai.example;

import com.openai.client.okhttp.OkHttpClient;
import com.openai.core.ClientOptions;
import com.openai.helpers.RealtimeConnection;
import com.openai.helpers.RealtimeWebSocketOptions;
import com.openai.models.realtime.RealtimeClientEvent;
import com.openai.models.realtime.RealtimeResponseCreateParams;
import com.openai.models.realtime.RealtimeServerEvent;
import com.openai.models.realtime.ResponseCreateEvent;
import java.util.concurrent.TimeUnit;

/** Run with: ./gradlew :openai-java-example:run -Pexample=RealtimeWebSocket */
public final class RealtimeWebSocketExample {
    private RealtimeWebSocketExample() {}

    public static void main(String[] args) throws Exception {
        ClientOptions options =
                ClientOptions.builder().fromEnv().httpClient(OkHttpClient.builder().build()).build();
        try (RealtimeConnection connection = RealtimeConnection.connect(
                options, RealtimeWebSocketOptions.builder().model("gpt-realtime-2.1").build())) {
            while (true) {
                RealtimeServerEvent event = connection.receiveAsync().get(20, TimeUnit.SECONDS);
                if (event.isError()) {
                    throw new IllegalStateException("Realtime returned an error event");
                }
                if (event.isSessionCreated()) {
                    connection.send(RealtimeClientEvent.ofResponseCreate(ResponseCreateEvent.builder()
                            .response(RealtimeResponseCreateParams.builder()
                                    .instructions("Say hello in one short sentence.")
                                    .addOutputModality(RealtimeResponseCreateParams.OutputModality.TEXT)
                                    .build())
                            .build()));
                } else if (event.isResponseDone()) {
                    System.out.println(
                            "Realtime response: " + event.asResponseDone().response().status());
                    break;
                }
            }
        } finally {
            // Releases both the shared HTTP transport and the client's callback executor.
            options.close();
        }
    }
}
