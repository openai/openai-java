// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.methods

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReinforcementMethodTest {

    @Test
    fun create() {
        val reinforcementMethod =
            ReinforcementMethod.builder()
                .grader(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .hyperparameters(
                    ReinforcementHyperparameters.builder()
                        .batchSizeAuto()
                        .computeMultiplierAuto()
                        .evalIntervalAuto()
                        .evalSamplesAuto()
                        .learningRateMultiplierAuto()
                        .nEpochsAuto()
                        .reasoningEffort(ReinforcementHyperparameters.ReasoningEffort.DEFAULT)
                        .build()
                )
                .build()

        assertThat(reinforcementMethod.grader())
            .isEqualTo(
                ReinforcementMethod.Grader.ofStringCheck(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
            )
        assertThat(reinforcementMethod.hyperparameters())
            .contains(
                ReinforcementHyperparameters.builder()
                    .batchSizeAuto()
                    .computeMultiplierAuto()
                    .evalIntervalAuto()
                    .evalSamplesAuto()
                    .learningRateMultiplierAuto()
                    .nEpochsAuto()
                    .reasoningEffort(ReinforcementHyperparameters.ReasoningEffort.DEFAULT)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val reinforcementMethod =
            ReinforcementMethod.builder()
                .grader(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .hyperparameters(
                    ReinforcementHyperparameters.builder()
                        .batchSizeAuto()
                        .computeMultiplierAuto()
                        .evalIntervalAuto()
                        .evalSamplesAuto()
                        .learningRateMultiplierAuto()
                        .nEpochsAuto()
                        .reasoningEffort(ReinforcementHyperparameters.ReasoningEffort.DEFAULT)
                        .build()
                )
                .build()

        val roundtrippedReinforcementMethod =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(reinforcementMethod),
                jacksonTypeRef<ReinforcementMethod>(),
            )

        assertThat(roundtrippedReinforcementMethod).isEqualTo(reinforcementMethod)
    }
}
