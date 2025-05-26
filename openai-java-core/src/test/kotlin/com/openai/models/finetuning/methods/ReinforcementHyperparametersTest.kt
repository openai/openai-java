// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.methods

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReinforcementHyperparametersTest {

    @Test
    fun create() {
        val reinforcementHyperparameters =
            ReinforcementHyperparameters.builder()
                .batchSizeAuto()
                .computeMultiplierAuto()
                .evalIntervalAuto()
                .evalSamplesAuto()
                .learningRateMultiplierAuto()
                .nEpochsAuto()
                .reasoningEffort(ReinforcementHyperparameters.ReasoningEffort.DEFAULT)
                .build()

        assertThat(reinforcementHyperparameters.batchSize())
            .contains(ReinforcementHyperparameters.BatchSize.ofAuto())
        assertThat(reinforcementHyperparameters.computeMultiplier())
            .contains(ReinforcementHyperparameters.ComputeMultiplier.ofAuto())
        assertThat(reinforcementHyperparameters.evalInterval())
            .contains(ReinforcementHyperparameters.EvalInterval.ofAuto())
        assertThat(reinforcementHyperparameters.evalSamples())
            .contains(ReinforcementHyperparameters.EvalSamples.ofAuto())
        assertThat(reinforcementHyperparameters.learningRateMultiplier())
            .contains(ReinforcementHyperparameters.LearningRateMultiplier.ofAuto())
        assertThat(reinforcementHyperparameters.nEpochs())
            .contains(ReinforcementHyperparameters.NEpochs.ofAuto())
        assertThat(reinforcementHyperparameters.reasoningEffort())
            .contains(ReinforcementHyperparameters.ReasoningEffort.DEFAULT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val reinforcementHyperparameters =
            ReinforcementHyperparameters.builder()
                .batchSizeAuto()
                .computeMultiplierAuto()
                .evalIntervalAuto()
                .evalSamplesAuto()
                .learningRateMultiplierAuto()
                .nEpochsAuto()
                .reasoningEffort(ReinforcementHyperparameters.ReasoningEffort.DEFAULT)
                .build()

        val roundtrippedReinforcementHyperparameters =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(reinforcementHyperparameters),
                jacksonTypeRef<ReinforcementHyperparameters>(),
            )

        assertThat(roundtrippedReinforcementHyperparameters).isEqualTo(reinforcementHyperparameters)
    }
}
