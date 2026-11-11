// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseShellCallOutputContentDoneEventTest {

    @Test
    fun createAndRoundtrip() {
        val responseShellCallOutputContentDoneEvent =
            ResponseShellCallOutputContentDoneEvent.builder()
                .commandIndex(0L)
                .itemId("item_id")
                .addOutput(
                    ResponseShellCallOutputContentDoneEvent.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseShellCallOutputContentDoneEvent.commandIndex()).contains(0L)
        assertThat(responseShellCallOutputContentDoneEvent.itemId()).contains("item_id")
        assertThat(responseShellCallOutputContentDoneEvent.output().getOrNull())
            .containsExactly(
                ResponseShellCallOutputContentDoneEvent.Output.builder()
                    .outcomeTimeout()
                    .stderr("stderr")
                    .stdout("stdout")
                    .createdBy("created_by")
                    .build()
            )
        assertThat(responseShellCallOutputContentDoneEvent.outputIndex()).contains(0L)
        assertThat(responseShellCallOutputContentDoneEvent.sequenceNumber()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseShellCallOutputContentDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseShellCallOutputContentDoneEvent),
                jacksonTypeRef<ResponseShellCallOutputContentDoneEvent>(),
            )

        assertThat(roundtrippedResponseShellCallOutputContentDoneEvent)
            .isEqualTo(responseShellCallOutputContentDoneEvent)
    }
}
