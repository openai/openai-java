// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EasyInputMessageTest {

    @Test
    fun create() {
        val easyInputMessage =
            EasyInputMessage.builder()
                .content("string")
                .role(EasyInputMessage.Role.USER)
                .type(EasyInputMessage.Type.MESSAGE)
                .build()

        assertThat(easyInputMessage.content())
            .isEqualTo(EasyInputMessage.Content.ofTextInput("string"))
        assertThat(easyInputMessage.role()).isEqualTo(EasyInputMessage.Role.USER)
        assertThat(easyInputMessage.type()).contains(EasyInputMessage.Type.MESSAGE)
    }
}
