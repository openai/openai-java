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

internal class HostedSkillTest {

    @Test
    fun ofSkillReference() {
        val skillReference =
            HostedSkillReference.builder()
                .description("description")
                .name("name")
                .skillId("skill_id")
                .version("version")
                .build()

        val hostedSkill = HostedSkill.ofSkillReference(skillReference)

        assertThat(hostedSkill.skillReference()).contains(skillReference)
        assertThat(hostedSkill.inline()).isEmpty
    }

    @Test
    fun ofSkillReferenceRoundtrip() {
        val jsonMapper = jsonMapper()
        val hostedSkill =
            HostedSkill.ofSkillReference(
                HostedSkillReference.builder()
                    .description("description")
                    .name("name")
                    .skillId("skill_id")
                    .version("version")
                    .build()
            )

        val roundtrippedHostedSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedSkill),
                jacksonTypeRef<HostedSkill>(),
            )

        assertThat(roundtrippedHostedSkill).isEqualTo(hostedSkill)
    }

    @Test
    fun ofInline() {
        val inline = HostedSkill.Inline.builder().description("description").name("name").build()

        val hostedSkill = HostedSkill.ofInline(inline)

        assertThat(hostedSkill.skillReference()).isEmpty
        assertThat(hostedSkill.inline()).contains(inline)
    }

    @Test
    fun ofInlineRoundtrip() {
        val jsonMapper = jsonMapper()
        val hostedSkill =
            HostedSkill.ofInline(
                HostedSkill.Inline.builder().description("description").name("name").build()
            )

        val roundtrippedHostedSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedSkill),
                jacksonTypeRef<HostedSkill>(),
            )

        assertThat(roundtrippedHostedSkill).isEqualTo(hostedSkill)
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
        val hostedSkill = jsonMapper().convertValue(testCase.value, jacksonTypeRef<HostedSkill>())

        val e = assertThrows<OpenAIInvalidDataException> { hostedSkill.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
