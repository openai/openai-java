// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobWandbIntegrationObjectTest {

    @Test
    fun createFineTuningJobWandbIntegrationObject() {
        val fineTuningJobWandbIntegrationObject =
            FineTuningJobWandbIntegrationObject.builder()
                .type(FineTuningJobWandbIntegrationObject.Type.WANDB)
                .wandb(
                    FineTuningJobWandbIntegration.builder()
                        .project("my-wandb-project")
                        .entity("entity")
                        .name("name")
                        .addTag("custom-tag")
                        .build()
                )
                .build()
        assertThat(fineTuningJobWandbIntegrationObject).isNotNull
        assertThat(fineTuningJobWandbIntegrationObject.type())
            .isEqualTo(FineTuningJobWandbIntegrationObject.Type.WANDB)
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
