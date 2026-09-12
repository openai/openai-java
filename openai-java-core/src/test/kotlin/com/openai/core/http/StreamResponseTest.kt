package com.openai.core.http

import java.util.Optional
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StreamResponseTest {

    @Test
    fun requestId_byDefault_isEmpty() {
        val response = streamResponse()

        assertThat(response.requestId()).isEmpty
    }

    @Test
    fun map_preservesRequestId() {
        val response = streamResponse(Optional.of("req_123"))

        val mappedResponse = response.map(String::length).map(Int::toString)

        assertThat(mappedResponse.requestId()).contains("req_123")
    }

    private fun streamResponse(
        requestId: Optional<String> = Optional.empty()
    ): StreamResponse<String> =
        object : StreamResponse<String> {
            override fun requestId(): Optional<String> = requestId

            override fun stream(): Stream<String> = Stream.empty()

            override fun close() {}
        }
}
