// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

internal class ResponseFunctionWebSearchTest {

    @Test
    fun create() {
        val responseFunctionWebSearch =
            ResponseFunctionWebSearch.builder()
                .id("id")
                .action(
                    ResponseFunctionWebSearch.Action.Search.builder()
                        .query("query")
                        .addSource(
                            ResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("url")
                                .build()
                        )
                        .build()
                )
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .build()

        assertThat(responseFunctionWebSearch.id()).isEqualTo("id")
        assertThat(responseFunctionWebSearch.action())
            .isEqualTo(
                ResponseFunctionWebSearch.Action.ofSearch(
                    ResponseFunctionWebSearch.Action.Search.builder()
                        .query("query")
                        .addSource(
                            ResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("url")
                                .build()
                        )
                        .build()
                )
            )
        assertThat(responseFunctionWebSearch.status())
            .isEqualTo(ResponseFunctionWebSearch.Status.IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionWebSearch =
            ResponseFunctionWebSearch.builder()
                .id("id")
                .action(
                    ResponseFunctionWebSearch.Action.Search.builder()
                        .query("query")
                        .addSource(
                            ResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("url")
                                .build()
                        )
                        .build()
                )
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .build()

        val roundtrippedResponseFunctionWebSearch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionWebSearch),
                jacksonTypeRef<ResponseFunctionWebSearch>(),
            )

        assertThat(roundtrippedResponseFunctionWebSearch).isEqualTo(responseFunctionWebSearch)
    }

    @Test
    fun deserializeWithoutAction() {
        val jsonMapper = jsonMapper()
        val payload = """
            {"id":"ws_missing","status":"completed","type":"web_search_call"}
        """.trimIndent()

        val responseFunctionWebSearch =
            jsonMapper.readValue(payload, jacksonTypeRef<ResponseFunctionWebSearch>())

        assertThat(responseFunctionWebSearch.actionOptional()).isEmpty
        assertThat(responseFunctionWebSearch.status())
            .isEqualTo(ResponseFunctionWebSearch.Status.COMPLETED)
        assertThatCode { responseFunctionWebSearch.validate() }.doesNotThrowAnyException()
    }
}
