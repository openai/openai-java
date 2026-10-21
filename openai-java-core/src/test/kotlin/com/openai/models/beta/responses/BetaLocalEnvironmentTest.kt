// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaLocalEnvironmentTest {

    @Test
    fun createAndRoundtrip() {
        val betaLocalEnvironment =
            BetaLocalEnvironment.builder()
                .addSkill(
                    BetaLocalSkill.builder()
                        .description("description")
                        .name("name")
                        .path("path")
                        .build()
                )
                .build()

        assertThat(betaLocalEnvironment.skills().getOrNull())
            .containsExactly(
                BetaLocalSkill.builder()
                    .description("description")
                    .name("name")
                    .path("path")
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaLocalEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaLocalEnvironment),
                jacksonTypeRef<BetaLocalEnvironment>(),
            )

        assertThat(roundtrippedBetaLocalEnvironment).isEqualTo(betaLocalEnvironment)
    }
}
