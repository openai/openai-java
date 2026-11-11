package com.openai.models.admin.organization.projects.apikeys

import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonNull
import com.openai.core.jsonMapper
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateHttpTest {
    @Test
    fun preservesMissingNullAndSetExpiryOnTheWire() {
        MockWebServer().use { server ->
            val expectedBodies =
                listOf(
                    """{"scopes":["api.all.read"]}""",
                    """{"scopes":["api.all.read"],"expires_in_seconds":null}""",
                    """{"scopes":["api.all.read"],"expires_in_seconds":60}""",
                )
            repeat(expectedBodies.size) {
                server.enqueue(
                    MockResponse().setHeader("Content-Type", "application/json").setBody("{}")
                )
            }
            val client =
                OpenAIOkHttpClient.builder()
                    .baseUrl(server.url("/").toString())
                    .adminApiKey("test-admin-key")
                    .maxRetries(0)
                    .build()
            try {
                val keys = client.admin().organization().projects().apiKeys()
                val builder =
                    ApiKeyUpdateParams.builder().projectId("proj_test").apiKeyId("key_test")
                keys.update(builder.addScope("api.all.read").build())
                keys.update(builder.expiresInSeconds(JsonNull.of()).build())
                keys.update(builder.expiresInSeconds(60L).build())

                for (expected in expectedBodies) {
                    val request = checkNotNull(server.takeRequest(5, TimeUnit.SECONDS))
                    assertThat(request.method).isEqualTo("POST")
                    assertThat(request.path)
                        .isEqualTo("/organization/projects/proj_test/api_keys/key_test")
                    assertThat(jsonMapper().readTree(request.body.readUtf8()))
                        .isEqualTo(jsonMapper().readTree(expected))
                }
                assertThat(server.requestCount).isEqualTo(expectedBodies.size)
            } finally {
                client.close()
            }
        }
    }
}
