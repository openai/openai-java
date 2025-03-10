// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobWandbIntegrationTest {

    @Test
    fun createFineTuningJobWandbIntegration() {
        val fineTuningJobWandbIntegration =
            FineTuningJobWandbIntegration.builder()
                .project("my-wandb-project")
                .entity("entity")
                .name("name")
                .addTag("custom-tag")
                .build()
        assertThat(fineTuningJobWandbIntegration).isNotNull
        assertThat(fineTuningJobWandbIntegration.project()).isEqualTo("my-wandb-project")
        assertThat(fineTuningJobWandbIntegration.entity()).contains("entity")
        assertThat(fineTuningJobWandbIntegration.name()).contains("name")
        assertThat(fineTuningJobWandbIntegration.tags().get()).containsExactly("custom-tag")
    }
}
