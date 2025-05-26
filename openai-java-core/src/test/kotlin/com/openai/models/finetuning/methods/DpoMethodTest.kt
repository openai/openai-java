// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.methods

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DpoMethodTest {

    @Test
    fun create() {
        val dpoMethod =
            DpoMethod.builder()
                .hyperparameters(
                    DpoHyperparameters.builder()
                        .batchSizeAuto()
                        .betaAuto()
                        .learningRateMultiplierAuto()
                        .nEpochsAuto()
                        .build()
                )
                .build()

        assertThat(dpoMethod.hyperparameters())
            .contains(
                DpoHyperparameters.builder()
                    .batchSizeAuto()
                    .betaAuto()
                    .learningRateMultiplierAuto()
                    .nEpochsAuto()
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dpoMethod =
            DpoMethod.builder()
                .hyperparameters(
                    DpoHyperparameters.builder()
                        .batchSizeAuto()
                        .betaAuto()
                        .learningRateMultiplierAuto()
                        .nEpochsAuto()
                        .build()
                )
                .build()

        val roundtrippedDpoMethod =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(dpoMethod),
                jacksonTypeRef<DpoMethod>(),
            )

        assertThat(roundtrippedDpoMethod).isEqualTo(dpoMethod)
    }
}
