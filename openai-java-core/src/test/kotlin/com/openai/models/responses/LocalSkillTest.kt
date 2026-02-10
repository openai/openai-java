// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LocalSkillTest {

    @Test
    fun create() {
        val localSkill =
            LocalSkill.builder().description("description").name("name").path("path").build()

        assertThat(localSkill.description()).isEqualTo("description")
        assertThat(localSkill.name()).isEqualTo("name")
        assertThat(localSkill.path()).isEqualTo("path")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val localSkill =
            LocalSkill.builder().description("description").name("name").path("path").build()

        val roundtrippedLocalSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(localSkill),
                jacksonTypeRef<LocalSkill>(),
            )

        assertThat(roundtrippedLocalSkill).isEqualTo(localSkill)
    }
}
