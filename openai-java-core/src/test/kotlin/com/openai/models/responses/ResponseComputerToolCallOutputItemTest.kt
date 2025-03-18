// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseComputerToolCallOutputItemTest {

    @Test
    fun create() {
        val responseComputerToolCallOutputItem =
            ResponseComputerToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output(
                    ResponseComputerToolCallOutputScreenshot.builder()
                        .fileId("file_id")
                        .imageUrl("image_url")
                        .build()
                )
                .addAcknowledgedSafetyCheck(
                    ResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .status(ResponseComputerToolCallOutputItem.Status.IN_PROGRESS)
                .build()

        assertThat(responseComputerToolCallOutputItem.id()).isEqualTo("id")
        assertThat(responseComputerToolCallOutputItem.callId()).isEqualTo("call_id")
        assertThat(responseComputerToolCallOutputItem.output())
            .isEqualTo(
                ResponseComputerToolCallOutputScreenshot.builder()
                    .fileId("file_id")
                    .imageUrl("image_url")
                    .build()
            )
        assertThat(responseComputerToolCallOutputItem.acknowledgedSafetyChecks().getOrNull())
            .containsExactly(
                ResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                    .id("id")
                    .code("code")
                    .message("message")
                    .build()
            )
        assertThat(responseComputerToolCallOutputItem.status())
            .contains(ResponseComputerToolCallOutputItem.Status.IN_PROGRESS)
    }
}
