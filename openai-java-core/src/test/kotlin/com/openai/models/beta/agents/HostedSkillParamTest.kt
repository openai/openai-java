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

internal class HostedSkillParamTest {

    @Test
    fun ofSkillReference() {
        val skillReference =
            HostedSkillParam.SkillReference.builder().skillId("x").version("version").build()

        val hostedSkillParam = HostedSkillParam.ofSkillReference(skillReference)

        assertThat(hostedSkillParam.skillReference()).contains(skillReference)
        assertThat(hostedSkillParam.inline()).isEmpty
    }

    @Test
    fun ofSkillReferenceRoundtrip() {
        val jsonMapper = jsonMapper()
        val hostedSkillParam =
            HostedSkillParam.ofSkillReference(
                HostedSkillParam.SkillReference.builder().skillId("x").version("version").build()
            )

        val roundtrippedHostedSkillParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedSkillParam),
                jacksonTypeRef<HostedSkillParam>(),
            )

        assertThat(roundtrippedHostedSkillParam).isEqualTo(hostedSkillParam)
    }

    @Test
    fun ofInline() {
        val inline =
            HostedSkillParam.Inline.builder()
                .description("description")
                .name("x")
                .source(InlineCapabilitySourceParam.builder().data("x").build())
                .build()

        val hostedSkillParam = HostedSkillParam.ofInline(inline)

        assertThat(hostedSkillParam.skillReference()).isEmpty
        assertThat(hostedSkillParam.inline()).contains(inline)
    }

    @Test
    fun ofInlineRoundtrip() {
        val jsonMapper = jsonMapper()
        val hostedSkillParam =
            HostedSkillParam.ofInline(
                HostedSkillParam.Inline.builder()
                    .description("description")
                    .name("x")
                    .source(InlineCapabilitySourceParam.builder().data("x").build())
                    .build()
            )

        val roundtrippedHostedSkillParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedSkillParam),
                jacksonTypeRef<HostedSkillParam>(),
            )

        assertThat(roundtrippedHostedSkillParam).isEqualTo(hostedSkillParam)
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
        val hostedSkillParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<HostedSkillParam>())

        val e = assertThrows<OpenAIInvalidDataException> { hostedSkillParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
