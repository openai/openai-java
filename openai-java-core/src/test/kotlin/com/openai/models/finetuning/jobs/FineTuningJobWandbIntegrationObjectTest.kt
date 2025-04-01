// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FineTuningJobWandbIntegrationObjectTest {

    @Test
    fun create() {
        val fineTuningJobWandbIntegrationObject =
            FineTuningJobWandbIntegrationObject.builder()
                .wandb(
                    FineTuningJobWandbIntegration.builder()
                        .project("my-wandb-project")
                        .entity("entity")
                        .name("name")
                        .addTag("custom-tag")
                        .build()
                )
                .build()

        assertThat(fineTuningJobWandbIntegrationObject.wandb())
            .isEqualTo(
                FineTuningJobWandbIntegration.builder()
                    .project("my-wandb-project")
                    .entity("entity")
                    .name("name")
                    .addTag("custom-tag")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fineTuningJobWandbIntegrationObject =
            FineTuningJobWandbIntegrationObject.builder()
                .wandb(
                    FineTuningJobWandbIntegration.builder()
                        .project("my-wandb-project")
                        .entity("entity")
                        .name("name")
                        .addTag("custom-tag")
                        .build()
                )
                .build()

        val roundtrippedFineTuningJobWandbIntegrationObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fineTuningJobWandbIntegrationObject),
                jacksonTypeRef<FineTuningJobWandbIntegrationObject>(),
            )

        assertThat(roundtrippedFineTuningJobWandbIntegrationObject)
            .isEqualTo(fineTuningJobWandbIntegrationObject)
    }
}
