// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.methods

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DpoHyperparametersTest {

    @Test
    fun create() {
        val dpoHyperparameters =
            DpoHyperparameters.builder()
                .batchSizeAuto()
                .betaAuto()
                .learningRateMultiplierAuto()
                .nEpochsAuto()
                .build()

        assertThat(dpoHyperparameters.batchSize()).contains(DpoHyperparameters.BatchSize.ofAuto())
        assertThat(dpoHyperparameters.beta()).contains(DpoHyperparameters.Beta.ofAuto())
        assertThat(dpoHyperparameters.learningRateMultiplier())
            .contains(DpoHyperparameters.LearningRateMultiplier.ofAuto())
        assertThat(dpoHyperparameters.nEpochs()).contains(DpoHyperparameters.NEpochs.ofAuto())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dpoHyperparameters =
            DpoHyperparameters.builder()
                .batchSizeAuto()
                .betaAuto()
                .learningRateMultiplierAuto()
                .nEpochsAuto()
                .build()

        val roundtrippedDpoHyperparameters =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(dpoHyperparameters),
                jacksonTypeRef<DpoHyperparameters>(),
            )

        assertThat(roundtrippedDpoHyperparameters).isEqualTo(dpoHyperparameters)
    }
}
