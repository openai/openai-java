// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.methods

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SupervisedMethodTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedSupervisedMethod =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(supervisedMethod),
                jacksonTypeRef<SupervisedMethod>(),
            )

        assertThat(roundtrippedSupervisedMethod).isEqualTo(supervisedMethod)
    }
}
