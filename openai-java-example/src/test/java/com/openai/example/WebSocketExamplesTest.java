package com.openai.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

@ResourceLock(Resources.SYSTEM_PROPERTIES)
@Timeout(value = 10, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class WebSocketExamplesTest {
    private final MockWebServer server = new MockWebServer();
    private final ObjectMapper json = new ObjectMapper();
    private final List<String> commands = new CopyOnWriteArrayList<>();
    private String previousBaseUrl;
    private String previousApiKey;

    @BeforeEach
    void setUp() {
        previousBaseUrl = System.setProperty("openai.baseUrl", server.url("/v1").toString());
        previousApiKey = System.setProperty("openai.apiKey", "fake-example-test-key");
    }

    @AfterEach
    void tearDown() throws Exception {
        restore("openai.baseUrl", previousBaseUrl);
        restore("openai.apiKey", previousApiKey);
        server.shutdown();
    }

    @Test
    void responsesContinuesOnTheSameConnection() throws Exception {
        server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
            @Override
            public void onMessage(WebSocket socket, String text) {
                commands.add(text);
                socket.send("{\"type\":\"response.completed\",\"sequence_number\":1,\"response\":{"
                        + "\"id\":\"resp_" + commands.size() + "\",\"created_at\":0,\"object\":\"response\","
                        + "\"model\":\"gpt-4o-mini\",\"output\":[],\"parallel_tool_calls\":false,"
                        + "\"tool_choice\":\"auto\",\"tools\":[],\"status\":\"completed\"}}");
            }

            @Override
            public void onClosing(WebSocket socket, int code, String reason) {
                socket.close(code, reason);
            }
        }));
        ResponsesWebSocketExample.main(new String[0]);
        assertPath("/v1/responses");
        assertEquals(2, commands.size());
        JsonNode first = json.readTree(commands.get(0));
        JsonNode second = json.readTree(commands.get(1));
        assertEquals("response.create", first.path("type").asText());
        assertEquals(json.readTree("false"), first.path("store"));
        assertEquals("response.create", second.path("type").asText());
        assertEquals("resp_1", second.path("previous_response_id").asText());
        assertEquals(json.readTree("false"), second.path("store"));
    }

    @Test
    void realtimeStartsAResponseAfterSessionCreated() throws Exception {
        server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
            @Override
            public void onOpen(WebSocket socket, Response response) {
                socket.send("{\"type\":\"session.created\",\"event_id\":\"ready\","
                        + "\"session\":{\"type\":\"realtime\",\"model\":\"gpt-realtime-2.1\"}}");
            }

            @Override
            public void onMessage(WebSocket socket, String text) {
                commands.add(text);
                socket.send("{\"type\":\"response.done\",\"event_id\":\"done\","
                        + "\"response\":{\"id\":\"resp_rt\",\"status\":\"completed\",\"output\":[]}}");
            }

            @Override
            public void onClosing(WebSocket socket, int code, String reason) {
                socket.close(code, reason);
            }
        }));
        RealtimeWebSocketExample.main(new String[0]);
        assertPath("/v1/realtime?model=gpt-realtime-2.1");
        assertEquals(1, commands.size());
        JsonNode message = json.readTree(commands.get(0));
        assertEquals("response.create", message.path("type").asText());
        assertEquals(json.readTree("[\"text\"]"), message.path("response").path("output_modalities"));
    }

    @Test
    void liveStartsSendsAudioAndCloses() throws Exception {
        server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
            @Override
            public void onMessage(WebSocket socket, String text) {
                commands.add(text);
                if (commands.size() == 1) {
                    socket.send("{\"type\":\"session.started\",\"event_id\":\"ready\","
                            + "\"session\":{\"id\":\"test-session\"}}");
                } else if (commands.size() == 5) {
                    socket.send("{\"type\":\"session.closed\",\"event_id\":\"closed\","
                            + "\"session\":{\"id\":\"test-session\"},\"reason\":\"client_request\"}");
                }
            }

            @Override
            public void onClosing(WebSocket socket, int code, String reason) {
                socket.close(code, reason);
            }
        }));
        LiveWebSocketExample.main(new String[0]);
        assertPath("/v1/live/sessions");
        assertEquals(5, commands.size());
        JsonNode start = json.readTree(commands.get(0));
        assertEquals("session.start", start.path("type").asText());
        assertEquals(json.readTree("false"), start.path("session").path("store"));
        for (int i = 1; i <= 3; i++) {
            JsonNode audio = json.readTree(commands.get(i));
            assertEquals("session.input_audio.append", audio.path("type").asText());
            assertEquals(960, Base64.getDecoder().decode(audio.path("audio").asText()).length);
        }
        assertEquals("session.close", json.readTree(commands.get(4)).path("type").asText());
    }

    private void assertPath(String path) throws Exception {
        RecordedRequest request = server.takeRequest(1, TimeUnit.SECONDS);
        assertNotNull(request, "example must open its WebSocket");
        assertEquals(path, request.getPath());
        assertEquals(1, server.getRequestCount(), "example must use one WebSocket");
    }

    private static void restore(String name, String original) {
        if (original == null) {
            System.clearProperty(name);
        } else {
            System.setProperty(name, original);
        }
    }
}
