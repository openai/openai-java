// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentTemplateDeletedTest {

    @Test
    fun create() {
        val environmentTemplateDeleted =
            EnvironmentTemplateDeleted.builder().id("id").deleted(true).build()

        assertThat(environmentTemplateDeleted.id()).isEqualTo("id")
        assertThat(environmentTemplateDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val environmentTemplateDeleted =
            EnvironmentTemplateDeleted.builder().id("id").deleted(true).build()

        val roundtrippedEnvironmentTemplateDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentTemplateDeleted),
                jacksonTypeRef<EnvironmentTemplateDeleted>(),
            )

        assertThat(roundtrippedEnvironmentTemplateDeleted).isEqualTo(environmentTemplateDeleted)
    }
}
