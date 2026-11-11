// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HostedSkillReferenceTest {

    @Test
    fun createAndRoundtrip() {
        val hostedSkillReference =
            HostedSkillReference.builder()
                .description("description")
                .name("name")
                .skillId("skill_id")
                .version("version")
                .build()

        assertThat(hostedSkillReference.description()).contains("description")
        assertThat(hostedSkillReference.name()).contains("name")
        assertThat(hostedSkillReference.skillId()).contains("skill_id")
        assertThat(hostedSkillReference.version()).contains("version")

        val jsonMapper = jsonMapper()

        val roundtrippedHostedSkillReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedSkillReference),
                jacksonTypeRef<HostedSkillReference>(),
            )

        assertThat(roundtrippedHostedSkillReference).isEqualTo(hostedSkillReference)
    }
}
