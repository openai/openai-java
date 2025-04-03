// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobWandbIntegrationTest {

    @Test
    fun create() {
        val fineTuningJobWandbIntegration =
            FineTuningJobWandbIntegration.builder()
                .project("my-wandb-project")
                .entity("entity")
                .name("name")
                .addTag("custom-tag")
                .build()

        assertThat(fineTuningJobWandbIntegration.project()).isEqualTo("my-wandb-project")
        assertThat(fineTuningJobWandbIntegration.entity()).contains("entity")
        assertThat(fineTuningJobWandbIntegration.name()).contains("name")
        assertThat(fineTuningJobWandbIntegration.tags().getOrNull()).containsExactly("custom-tag")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fineTuningJobWandbIntegration =
            FineTuningJobWandbIntegration.builder()
                .project("my-wandb-project")
                .entity("entity")
                .name("name")
                .addTag("custom-tag")
                .build()

        val roundtrippedFineTuningJobWandbIntegration =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fineTuningJobWandbIntegration),
                jacksonTypeRef<FineTuningJobWandbIntegration>(),
            )

        assertThat(roundtrippedFineTuningJobWandbIntegration)
            .isEqualTo(fineTuningJobWandbIntegration)
    }
}
