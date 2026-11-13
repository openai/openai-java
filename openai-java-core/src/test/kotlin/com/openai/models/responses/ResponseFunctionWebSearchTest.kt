// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionWebSearchTest {

    @Test
    fun createAndRoundtrip() {
        val responseFunctionWebSearch =
            ResponseFunctionWebSearch.builder()
                .id("id")
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .action(
                    ResponseFunctionWebSearch.Action.Search.builder()
                        .addQuery("string")
                        .query("query")
                        .addSource(
                            ResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(responseFunctionWebSearch.id()).contains("id")
        assertThat(responseFunctionWebSearch.status())
            .contains(ResponseFunctionWebSearch.Status.IN_PROGRESS)
        assertThat(responseFunctionWebSearch.action())
            .contains(
                ResponseFunctionWebSearch.Action.ofSearch(
                    ResponseFunctionWebSearch.Action.Search.builder()
                        .addQuery("string")
                        .query("query")
                        .addSource(
                            ResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFunctionWebSearch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionWebSearch),
                jacksonTypeRef<ResponseFunctionWebSearch>(),
            )

        assertThat(roundtrippedResponseFunctionWebSearch).isEqualTo(responseFunctionWebSearch)
    }
}
