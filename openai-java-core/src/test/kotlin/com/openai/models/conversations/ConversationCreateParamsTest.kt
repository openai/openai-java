// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.openai.core.JsonValue
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseInputItem
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationCreateParamsTest {

    @Test
    fun create() {
        ConversationCreateParams.builder()
            .addItem(
                EasyInputMessage.builder()
                    .content("string")
                    .role(EasyInputMessage.Role.USER)
                    .type(EasyInputMessage.Type.MESSAGE)
                    .build()
            )
            .metadata(
                ConversationCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ConversationCreateParams.builder()
                .addItem(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .metadata(
                    ConversationCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.items().getOrNull())
            .containsExactly(
                ResponseInputItem.ofEasyInputMessage(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
            )
        assertThat(body.metadata())
            .contains(
                ConversationCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ConversationCreateParams.builder().build()

        val body = params._body()
    }
}
