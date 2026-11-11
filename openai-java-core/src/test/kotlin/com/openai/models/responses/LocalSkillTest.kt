// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LocalSkillTest {

    @Test
    fun createAndRoundtrip() {
        val localSkill =
            LocalSkill.builder().description("description").name("name").path("path").build()

        assertThat(localSkill.description()).contains("description")
        assertThat(localSkill.name()).contains("name")
        assertThat(localSkill.path()).contains("path")

        val jsonMapper = jsonMapper()

        val roundtrippedLocalSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(localSkill),
                jacksonTypeRef<LocalSkill>(),
            )

        assertThat(roundtrippedLocalSkill).isEqualTo(localSkill)
    }
}
