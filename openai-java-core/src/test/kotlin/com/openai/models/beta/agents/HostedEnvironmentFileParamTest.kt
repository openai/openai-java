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

internal class HostedEnvironmentFileParamTest {

    @Test
    fun ofFileId() {
        val fileId = HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()

        val hostedEnvironmentFileParam = HostedEnvironmentFileParam.ofFileId(fileId)

        assertThat(hostedEnvironmentFileParam.fileId()).contains(fileId)
        assertThat(hostedEnvironmentFileParam.inline()).isEmpty
    }

    @Test
    fun ofFileIdRoundtrip() {
        val jsonMapper = jsonMapper()
        val hostedEnvironmentFileParam =
            HostedEnvironmentFileParam.ofFileId(
                HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
            )

        val roundtrippedHostedEnvironmentFileParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedEnvironmentFileParam),
                jacksonTypeRef<HostedEnvironmentFileParam>(),
            )

        assertThat(roundtrippedHostedEnvironmentFileParam).isEqualTo(hostedEnvironmentFileParam)
    }

    @Test
    fun ofInline() {
        val inline = HostedEnvironmentFileParam.Inline.builder().data("data").path("x").build()

        val hostedEnvironmentFileParam = HostedEnvironmentFileParam.ofInline(inline)

        assertThat(hostedEnvironmentFileParam.fileId()).isEmpty
        assertThat(hostedEnvironmentFileParam.inline()).contains(inline)
    }

    @Test
    fun ofInlineRoundtrip() {
        val jsonMapper = jsonMapper()
        val hostedEnvironmentFileParam =
            HostedEnvironmentFileParam.ofInline(
                HostedEnvironmentFileParam.Inline.builder().data("data").path("x").build()
            )

        val roundtrippedHostedEnvironmentFileParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedEnvironmentFileParam),
                jacksonTypeRef<HostedEnvironmentFileParam>(),
            )

        assertThat(roundtrippedHostedEnvironmentFileParam).isEqualTo(hostedEnvironmentFileParam)
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
        val hostedEnvironmentFileParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<HostedEnvironmentFileParam>())

        val e = assertThrows<OpenAIInvalidDataException> { hostedEnvironmentFileParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
