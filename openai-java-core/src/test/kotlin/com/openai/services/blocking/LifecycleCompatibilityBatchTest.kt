package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.batches.Batch
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class LifecycleCompatibilityBatchTest {
    private fun batch(status: String, fields: String = "") =
        """{
            "id":"batch_test", "object":"batch", "endpoint":"/v1/responses",
            "input_file_id":"file_input", "completion_window":"24h", "created_at":1,
            "status":"$status" $fields
        }"""

    private val explicitNulls =
        """, "in_progress_at":null, "expires_at":null, "finalizing_at":null,
                "completed_at":null, "output_file_id":null, "error_file_id":null"""

    @Test
    fun missingAndExplicitNullAreEmptyButSerializeDifferently() {
        for (fields in listOf("", explicitNulls)) {
            val json = batch("validating", fields)
            val result = jsonMapper().readValue(json, Batch::class.java).validate()
            assertThat(result.inProgressAt()).isEmpty
            assertThat(result.expiresAt()).isEmpty
            assertThat(result.finalizingAt()).isEmpty
            assertThat(result.completedAt()).isEmpty
            assertThat(result.outputFileId()).isEmpty
            assertThat(result.errorFileId()).isEmpty
            assertWireJson(result, json)
        }
    }

    @Test
    fun builderCanWriteExplicitNullForEachLifecycleField() {
        val pending = jsonMapper().readValue(batch("validating"), Batch::class.java)
        val explicit =
            pending
                .toBuilder()
                .inProgressAt(Optional.empty())
                .expiresAt(Optional.empty())
                .finalizingAt(Optional.empty())
                .completedAt(Optional.empty())
                .outputFileId(Optional.empty())
                .errorFileId(Optional.empty())
                .build()
                .validate()
        assertWireJson(explicit, batch("validating", explicitNulls))
    }

    @Test
    fun completedBatchExposesAllFourTimestampsAndBothFiles(server: WireMockRuntimeInfo) {
        val json =
            batch(
                "completed",
                """, "in_progress_at":2, "expires_at":100, "finalizing_at":3, "completed_at":4,
                    "output_file_id":"file_output", "error_file_id":"file_errors"
                """,
            )
        server.wireMock.register(get("/batches/batch_test").willReturn(okJson(json)))
        server.withStrictClient { client ->
            val result = client.batches().retrieve("batch_test")
            assertThat(result.inProgressAt()).contains(2L)
            assertThat(result.expiresAt()).contains(100L)
            assertThat(result.finalizingAt()).contains(3L)
            assertThat(result.completedAt()).contains(4L)
            assertThat(result.outputFileId()).contains("file_output")
            assertThat(result.errorFileId()).contains("file_errors")
            assertWireJson(result, json)
        }
    }

    @Test
    fun malformedTimestampIsAvailableToRawConsumers() {
        val json = batch("in_progress", """, "in_progress_at":{"unexpected":true}""")
        val result = jsonMapper().readValue(json, Batch::class.java)
        assertThat(result._inProgressAt().asObject().get()).containsKey("unexpected")
        assertThrows<OpenAIInvalidDataException> { result.inProgressAt() }
        assertThrows<OpenAIInvalidDataException> { result.validate() }
        assertWireJson(result, json)
    }
}
