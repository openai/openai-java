// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionWebSearchTest {

    @Test
    fun deserializeIncompleteStatus() {
        val responseFunctionWebSearch =
            jsonMapper()
                .readValue(
                    """
                    {
                        "id": "ws_incomplete",
                        "type": "web_search_call",
                        "status": "incomplete",
                        "action": {"type": "search", "query": "synthetic query"}
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<ResponseFunctionWebSearch>(),
                )

        responseFunctionWebSearch.validate()
        assertThat(responseFunctionWebSearch.status().value())
            .isEqualTo(ResponseFunctionWebSearch.Status.Value.INCOMPLETE)
        assertThat(responseFunctionWebSearch.status().known())
            .isEqualTo(ResponseFunctionWebSearch.Status.Known.INCOMPLETE)
    }

    @Test
    fun create() {
        val responseFunctionWebSearch =
            ResponseFunctionWebSearch.builder()
                .id("id")
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
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .build()

        assertThat(responseFunctionWebSearch.id()).isEqualTo("id")
        assertThat(responseFunctionWebSearch.action())
            .isEqualTo(
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
                        .addQuery("string")
                        .query("query")
                        .addSource(
                            ResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("https://example.com")
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
}
