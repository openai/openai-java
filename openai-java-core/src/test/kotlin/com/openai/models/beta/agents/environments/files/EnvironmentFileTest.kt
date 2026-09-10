// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentFileTest {

    @Test
    fun create() {
        val environmentFile =
            EnvironmentFile.builder()
                .environmentId("environment_id")
                .path("path")
                .sizeBytes(0L)
                .build()

        assertThat(environmentFile.environmentId()).isEqualTo("environment_id")
        assertThat(environmentFile.path()).isEqualTo("path")
        assertThat(environmentFile.sizeBytes()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val environmentFile =
            EnvironmentFile.builder()
                .environmentId("environment_id")
                .path("path")
                .sizeBytes(0L)
                .build()

        val roundtrippedEnvironmentFile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentFile),
                jacksonTypeRef<EnvironmentFile>(),
            )

        assertThat(roundtrippedEnvironmentFile).isEqualTo(environmentFile)
    }
}
