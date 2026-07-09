// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaWebSearchPreviewToolTest {

    @Test
    fun create() {
        val betaWebSearchPreviewTool =
            BetaWebSearchPreviewTool.builder()
                .type(BetaWebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
                .addSearchContentType(BetaWebSearchPreviewTool.SearchContentType.TEXT)
                .searchContextSize(BetaWebSearchPreviewTool.SearchContextSize.LOW)
                .userLocation(
                    BetaWebSearchPreviewTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        assertThat(betaWebSearchPreviewTool.type())
            .isEqualTo(BetaWebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
        assertThat(betaWebSearchPreviewTool.searchContentTypes().getOrNull())
            .containsExactly(BetaWebSearchPreviewTool.SearchContentType.TEXT)
        assertThat(betaWebSearchPreviewTool.searchContextSize())
            .contains(BetaWebSearchPreviewTool.SearchContextSize.LOW)
        assertThat(betaWebSearchPreviewTool.userLocation())
            .contains(
                BetaWebSearchPreviewTool.UserLocation.builder()
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
        val betaWebSearchPreviewTool =
            BetaWebSearchPreviewTool.builder()
                .type(BetaWebSearchPreviewTool.Type.WEB_SEARCH_PREVIEW)
                .addSearchContentType(BetaWebSearchPreviewTool.SearchContentType.TEXT)
                .searchContextSize(BetaWebSearchPreviewTool.SearchContextSize.LOW)
                .userLocation(
                    BetaWebSearchPreviewTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .build()
                )
                .build()

        val roundtrippedBetaWebSearchPreviewTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaWebSearchPreviewTool),
                jacksonTypeRef<BetaWebSearchPreviewTool>(),
            )

        assertThat(roundtrippedBetaWebSearchPreviewTool).isEqualTo(betaWebSearchPreviewTool)
    }
}
