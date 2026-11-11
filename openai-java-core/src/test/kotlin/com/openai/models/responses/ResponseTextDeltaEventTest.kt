// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextDeltaEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseTextDeltaEvent =
            ResponseTextDeltaEvent.builder()
                .contentIndex(0L)
                .delta("delta")
                .itemId("item_id")
                .addLogprob(
                    ResponseTextDeltaEvent.Logprob.builder()
                        .token("token")
                        .logprob(0.0)
                        .addTopLogprob(
                            ResponseTextDeltaEvent.Logprob.TopLogprob.builder()
                                .token("token")
                                .logprob(0.0)
                                .build()
                        )
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseTextDeltaEvent.contentIndex()).contains(0L)
        assertThat(responseTextDeltaEvent.delta()).contains("delta")
        assertThat(responseTextDeltaEvent.itemId()).contains("item_id")
        assertThat(responseTextDeltaEvent.logprobs().getOrNull())
            .containsExactly(
                ResponseTextDeltaEvent.Logprob.builder()
                    .token("token")
                    .logprob(0.0)
                    .addTopLogprob(
                        ResponseTextDeltaEvent.Logprob.TopLogprob.builder()
                            .token("token")
                            .logprob(0.0)
                            .build()
                    )
                    .build()
            )
        assertThat(responseTextDeltaEvent.outputIndex()).contains(0L)
        assertThat(responseTextDeltaEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseTextDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextDeltaEvent),
                jacksonTypeRef<ResponseTextDeltaEvent>(),
            )

        assertThat(roundtrippedResponseTextDeltaEvent).isEqualTo(responseTextDeltaEvent)
    }
}
