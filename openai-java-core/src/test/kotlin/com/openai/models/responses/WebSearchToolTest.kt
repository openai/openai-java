// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebSearchToolTest {

    @Test
    fun create() {
        val webSearchTool =
            WebSearchTool.builder()
                .type(WebSearchTool.Type.WEB_SEARCH_PREVIEW)
                .searchContextSize(WebSearchTool.SearchContextSize.LOW)
                .userLocation(
                    WebSearchTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        assertThat(webSearchTool.type()).isEqualTo(WebSearchTool.Type.WEB_SEARCH_PREVIEW)
        assertThat(webSearchTool.searchContextSize()).contains(WebSearchTool.SearchContextSize.LOW)
        assertThat(webSearchTool.userLocation())
            .contains(
                WebSearchTool.UserLocation.builder()
                    .city("city")
                    .country("country")
                    .region("region")
                    .timezone("timezone")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webSearchTool =
            WebSearchTool.builder()
                .type(WebSearchTool.Type.WEB_SEARCH_PREVIEW)
                .searchContextSize(WebSearchTool.SearchContextSize.LOW)
                .userLocation(
                    WebSearchTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        val roundtrippedWebSearchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webSearchTool),
                jacksonTypeRef<WebSearchTool>(),
            )

        assertThat(roundtrippedWebSearchTool).isEqualTo(webSearchTool)
    }
}
