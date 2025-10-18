// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import com.openai.core.http.QueryParams
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseIncludable
import com.openai.models.responses.ResponseInputItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemCreateParamsTest {

    @Test
    fun create() {
        ItemCreateParams.builder()
            .conversationId("conv_123")
            .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
            .addItem(
                EasyInputMessage.builder()
                    .content("string")
                    .role(EasyInputMessage.Role.USER)
                    .type(EasyInputMessage.Type.MESSAGE)
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ItemCreateParams.builder()
                .conversationId("conv_123")
                .addItem(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("conv_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ItemCreateParams.builder()
                .conversationId("conv_123")
                .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .addItem(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("include[]", "file_search_call.results").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ItemCreateParams.builder()
                .conversationId("conv_123")
                .addItem(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            ItemCreateParams.builder()
                .conversationId("conv_123")
                .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .addItem(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.items())
            .containsExactly(
                ResponseInputItem.ofEasyInputMessage(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ItemCreateParams.builder()
                .conversationId("conv_123")
                .addItem(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.items())
            .containsExactly(
                ResponseInputItem.ofEasyInputMessage(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
            )
    }
}
