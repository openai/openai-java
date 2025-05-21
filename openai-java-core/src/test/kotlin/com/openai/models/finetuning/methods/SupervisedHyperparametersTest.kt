// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.methods

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SupervisedHyperparametersTest {

    @Test
    fun create() {
        val supervisedHyperparameters =
            SupervisedHyperparameters.builder()
                .batchSizeAuto()
                .learningRateMultiplierAuto()
                .nEpochsAuto()
                .build()

        assertThat(supervisedHyperparameters.batchSize())
            .contains(SupervisedHyperparameters.BatchSize.ofAuto())
        assertThat(supervisedHyperparameters.learningRateMultiplier())
            .contains(SupervisedHyperparameters.LearningRateMultiplier.ofAuto())
        assertThat(supervisedHyperparameters.nEpochs())
            .contains(SupervisedHyperparameters.NEpochs.ofAuto())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val supervisedHyperparameters =
            SupervisedHyperparameters.builder()
                .batchSizeAuto()
                .learningRateMultiplierAuto()
                .nEpochsAuto()
                .build()

        val roundtrippedSupervisedHyperparameters =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(supervisedHyperparameters),
                jacksonTypeRef<SupervisedHyperparameters>(),
            )

        assertThat(roundtrippedSupervisedHyperparameters).isEqualTo(supervisedHyperparameters)
    }
}
