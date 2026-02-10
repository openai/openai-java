// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LocalEnvironmentTest {

    @Test
    fun create() {
        val localEnvironment =
            LocalEnvironment.builder()
                .addSkill(
                    LocalSkill.builder()
                        .description("description")
                        .name("name")
                        .path("path")
                        .build()
                )
                .build()

        assertThat(localEnvironment.skills().getOrNull())
            .containsExactly(
                LocalSkill.builder().description("description").name("name").path("path").build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val localEnvironment =
            LocalEnvironment.builder()
                .addSkill(
                    LocalSkill.builder()
                        .description("description")
                        .name("name")
                        .path("path")
                        .build()
                )
                .build()

        val roundtrippedLocalEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(localEnvironment),
                jacksonTypeRef<LocalEnvironment>(),
            )

        assertThat(roundtrippedLocalEnvironment).isEqualTo(localEnvironment)
    }
}
