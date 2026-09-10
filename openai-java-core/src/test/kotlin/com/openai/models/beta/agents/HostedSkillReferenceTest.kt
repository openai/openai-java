// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HostedSkillReferenceTest {

    @Test
    fun create() {
        val hostedSkillReference =
            HostedSkillReference.builder()
                .description("description")
                .name("name")
                .skillId("skill_id")
                .version("version")
                .build()

        assertThat(hostedSkillReference.description()).isEqualTo("description")
        assertThat(hostedSkillReference.name()).isEqualTo("name")
        assertThat(hostedSkillReference.skillId()).isEqualTo("skill_id")
        assertThat(hostedSkillReference.version()).isEqualTo("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val hostedSkillReference =
            HostedSkillReference.builder()
                .description("description")
                .name("name")
                .skillId("skill_id")
                .version("version")
                .build()

        val roundtrippedHostedSkillReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedSkillReference),
                jacksonTypeRef<HostedSkillReference>(),
            )

        assertThat(roundtrippedHostedSkillReference).isEqualTo(hostedSkillReference)
    }
}
