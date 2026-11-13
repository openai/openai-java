package com.openai.services.blocking

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat

internal fun WireMockRuntimeInfo.withStrictClient(test: (OpenAIClient) -> Unit) {
    val client =
        OpenAIOkHttpClient.builder()
            .baseUrl(httpBaseUrl)
            .apiKey("test-key")
            .responseValidation(true)
            .build()
    try {
        test(client)
    } finally {
        client.close()
    }
}

internal fun assertWireJson(model: Any, expected: String) {
    val mapper = jsonMapper()
    assertThat(mapper.readTree(mapper.writeValueAsBytes(model)))
        .isEqualTo(mapper.readTree(expected))
}
