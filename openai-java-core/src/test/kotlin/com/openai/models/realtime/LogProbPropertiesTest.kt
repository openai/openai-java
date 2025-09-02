// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogProbPropertiesTest {

    @Test
    fun create() {
        val logProbProperties =
            LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()

        assertThat(logProbProperties.token()).isEqualTo("token")
        assertThat(logProbProperties.bytes()).containsExactly(0L)
        assertThat(logProbProperties.logprob()).isEqualTo(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val logProbProperties =
            LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()

        val roundtrippedLogProbProperties =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(logProbProperties),
                jacksonTypeRef<LogProbProperties>(),
            )

        assertThat(roundtrippedLogProbProperties).isEqualTo(logProbProperties)
    }
}
