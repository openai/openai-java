package com.openai.client.okhttp;

import static org.assertj.core.api.Assertions.assertThat;

import com.openai.client.OpenAIClient;
import com.openai.helpers.RealtimeConnection;
import com.openai.models.realtime.RealtimeClientEvent;
import com.openai.models.realtime.RealtimeSessionCreateRequest;
import com.openai.models.realtime.RealtimeTranscriptionSessionCreateRequest;
import com.openai.models.realtime.SessionUpdateEvent;
import com.openai.models.realtime.clientsecrets.ClientSecretCreateParams;

final class JavaRealtimeSessionRequests {
    static void sendRealtime(OpenAIClient client, RealtimeConnection connection) {
        var session =
                RealtimeSessionCreateRequest.builder().instructions("speak").build();
        var secret = client.realtime()
                .clientSecrets()
                .create(ClientSecretCreateParams.builder().session(session).build());
        assertThat(secret.sessionOrThrow().isRealtime()).isTrue();
        connection.send(RealtimeClientEvent.ofSessionUpdate(SessionUpdateEvent.builder()
                .session(SessionUpdateEvent.Session.ofRealtime(session))
                .build()));
    }

    static void sendTranscription(OpenAIClient client, RealtimeConnection connection) {
        var session = RealtimeTranscriptionSessionCreateRequest.builder()
                .addInclude(RealtimeTranscriptionSessionCreateRequest.Include.ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS)
                .build();
        var secret = client.realtime()
                .clientSecrets()
                .create(ClientSecretCreateParams.builder().session(session).build());
        assertThat(secret.sessionOrThrow().isTranscription()).isTrue();
        connection.send(RealtimeClientEvent.ofSessionUpdate(SessionUpdateEvent.builder()
                .session(SessionUpdateEvent.Session.ofTranscription(session))
                .build()));
    }
}
