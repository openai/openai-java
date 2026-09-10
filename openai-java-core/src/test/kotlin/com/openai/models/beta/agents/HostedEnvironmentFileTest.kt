// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class HostedEnvironmentFileTest {

    @Test
    fun ofFileId() {
        val fileId =
            HostedEnvironmentFileId.builder()
                .id("id")
                .fileId("file_id")
                .path("path")
                .sizeBytes(0L)
                .build()

        val hostedEnvironmentFile = HostedEnvironmentFile.ofFileId(fileId)

        assertThat(hostedEnvironmentFile.fileId()).contains(fileId)
        assertThat(hostedEnvironmentFile.inline()).isEmpty
    }

    @Test
    fun ofFileIdRoundtrip() {
        val jsonMapper = jsonMapper()
        val hostedEnvironmentFile =
            HostedEnvironmentFile.ofFileId(
                HostedEnvironmentFileId.builder()
                    .id("id")
                    .fileId("file_id")
                    .path("path")
                    .sizeBytes(0L)
                    .build()
            )

        val roundtrippedHostedEnvironmentFile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedEnvironmentFile),
                jacksonTypeRef<HostedEnvironmentFile>(),
            )

        assertThat(roundtrippedHostedEnvironmentFile).isEqualTo(hostedEnvironmentFile)
    }

    @Test
    fun ofInline() {
        val inline =
            HostedEnvironmentFile.Inline.builder().id("id").path("path").sizeBytes(0L).build()

        val hostedEnvironmentFile = HostedEnvironmentFile.ofInline(inline)

        assertThat(hostedEnvironmentFile.fileId()).isEmpty
        assertThat(hostedEnvironmentFile.inline()).contains(inline)
    }

    @Test
    fun ofInlineRoundtrip() {
        val jsonMapper = jsonMapper()
        val hostedEnvironmentFile =
            HostedEnvironmentFile.ofInline(
                HostedEnvironmentFile.Inline.builder().id("id").path("path").sizeBytes(0L).build()
            )

        val roundtrippedHostedEnvironmentFile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedEnvironmentFile),
                jacksonTypeRef<HostedEnvironmentFile>(),
            )

        assertThat(roundtrippedHostedEnvironmentFile).isEqualTo(hostedEnvironmentFile)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val hostedEnvironmentFile =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<HostedEnvironmentFile>())

        val e = assertThrows<OpenAIInvalidDataException> { hostedEnvironmentFile.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
