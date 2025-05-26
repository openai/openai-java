// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.methods

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SupervisedMethodTest {

    @Test
    fun create() {
        val supervisedMethod =
            SupervisedMethod.builder()
                .hyperparameters(
                    SupervisedHyperparameters.builder()
                        .batchSizeAuto()
                        .learningRateMultiplierAuto()
                        .nEpochsAuto()
                        .build()
                )
                .build()

        assertThat(supervisedMethod.hyperparameters())
            .contains(
                SupervisedHyperparameters.builder()
                    .batchSizeAuto()
                    .learningRateMultiplierAuto()
                    .nEpochsAuto()
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val supervisedMethod =
            SupervisedMethod.builder()
                .hyperparameters(
                    SupervisedHyperparameters.builder()
                        .batchSizeAuto()
                        .learningRateMultiplierAuto()
                        .nEpochsAuto()
                        .build()
                )
                .build()

        val roundtrippedSupervisedMethod =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(supervisedMethod),
                jacksonTypeRef<SupervisedMethod>(),
            )

        assertThat(roundtrippedSupervisedMethod).isEqualTo(supervisedMethod)
    }
}
