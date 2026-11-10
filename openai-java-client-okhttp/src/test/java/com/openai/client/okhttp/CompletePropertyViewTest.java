package com.openai.client.okhttp;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.openai.client.OpenAIClient;
import com.openai.core.JsonValue;
import com.openai.core.ObjectMappers;
import com.openai.models.responses.ResponseUsage;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Test;

class CompletePropertyViewTest {
    @Test
    void readsCacheWriteDetailsAcrossTheSdkFieldPromotion() throws Exception {
        // The API added cache_write_tokens_details to the Java model in 4.99.0.
        String details = "{\"ttl_12h_tokens\":3,\"ttl_30m_tokens\":1}";
        String body = "{\"usage\":{\"input_tokens_details\":{\"cache_write_tokens_details\":" + details
                + ",\"future_detail\":true}}}";
        try (MockWebServer server = new MockWebServer()) {
            server.enqueue(new MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setBody(body));
            OpenAIClient client = OpenAIOkHttpClient.builder()
                    .apiKey("fake-api-key")
                    .baseUrl(server.url("/").toString())
                    .build();
            try {
                ResponseUsage.InputTokensDetails usage = client.responses()
                        .retrieve("resp_example")
                        .usage()
                        .get()
                        .inputTokensDetails();
                JsonValue promoted = usage._allProperties().get("cache_write_tokens_details");
                JsonMapper mapper = ObjectMappers.jsonMapper();
                JsonNode actual = mapper.readTree(mapper.writeValueAsBytes(promoted));
                assertThat(actual).isEqualTo(mapper.readTree(details));
                assertThat(usage._allProperties().get("future_detail")).isEqualTo(JsonValue.from(true));
            } finally {
                client.close();
            }
        }
    }
}
