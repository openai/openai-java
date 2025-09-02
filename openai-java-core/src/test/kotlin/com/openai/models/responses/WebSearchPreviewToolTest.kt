// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebSearchPreviewToolTest {

    @Test
    fun create() {
        val webSearchPreviewTool =
            WebSearchPreviewTool.builder()
                .type(WebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
                .searchContextSize(WebSearchPreviewTool.SearchContextSize.LOW)
                .userLocation(
                    WebSearchPreviewTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        assertThat(webSearchPreviewTool.type())
            .isEqualTo(WebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
        assertThat(webSearchPreviewTool.searchContextSize())
            .contains(WebSearchPreviewTool.SearchContextSize.LOW)
        assertThat(webSearchPreviewTool.userLocation())
            .contains(
                WebSearchPreviewTool.UserLocation.builder()
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
        val webSearchPreviewTool =
            WebSearchPreviewTool.builder()
                .type(WebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
                .searchContextSize(WebSearchPreviewTool.SearchContextSize.LOW)
                .userLocation(
                    WebSearchPreviewTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        val roundtrippedWebSearchPreviewTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webSearchPreviewTool),
                jacksonTypeRef<WebSearchPreviewTool>(),
            )

        assertThat(roundtrippedWebSearchPreviewTool).isEqualTo(webSearchPreviewTool)
    }
}
