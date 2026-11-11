// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogProbPropertiesTest {

    @Test
    fun createAndRoundtrip() {
        val logProbProperties =
            LogProbProperties.builder().token("token").addByte(0L).logprob(0.0).build()

        assertThat(logProbProperties.token()).contains("token")
        assertThat(logProbProperties.bytes().getOrNull()).containsExactly(0L)
        assertThat(logProbProperties.logprob()).contains(0.0)

        val jsonMapper = jsonMapper()

        val roundtrippedLogProbProperties =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(logProbProperties),
                jacksonTypeRef<LogProbProperties>(),
            )

        assertThat(roundtrippedLogProbProperties).isEqualTo(logProbProperties)
    }
}
