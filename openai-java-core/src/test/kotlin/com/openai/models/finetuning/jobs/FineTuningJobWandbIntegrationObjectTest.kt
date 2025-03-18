// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

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
}
