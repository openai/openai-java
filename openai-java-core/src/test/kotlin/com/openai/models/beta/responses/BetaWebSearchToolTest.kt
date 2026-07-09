// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaWebSearchToolTest {

    @Test
    fun create() {
        val betaWebSearchTool =
            BetaWebSearchTool.builder()
                .type(BetaWebSearchTool.Type.WEB_SEARCH)
                .filters(BetaWebSearchTool.Filters.builder().addAllowedDomain("string").build())
                .searchContextSize(BetaWebSearchTool.SearchContextSize.LOW)
                .userLocation(
                    BetaWebSearchTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .type(BetaWebSearchTool.UserLocation.Type.APPROXIMATE)
                        .build()
                )
                .build()

        assertThat(betaWebSearchTool.type()).isEqualTo(BetaWebSearchTool.Type.WEB_SEARCH)
        assertThat(betaWebSearchTool.filters())
            .contains(BetaWebSearchTool.Filters.builder().addAllowedDomain("string").build())
        assertThat(betaWebSearchTool.searchContextSize())
            .contains(BetaWebSearchTool.SearchContextSize.LOW)
        assertThat(betaWebSearchTool.userLocation())
            .contains(
                BetaWebSearchTool.UserLocation.builder()
                    .city("city")
                    .country("country")
                    .region("region")
                    .timezone("timezone")
                    .type(BetaWebSearchTool.UserLocation.Type.APPROXIMATE)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaWebSearchTool =
            BetaWebSearchTool.builder()
                .type(BetaWebSearchTool.Type.WEB_SEARCH)
                .filters(BetaWebSearchTool.Filters.builder().addAllowedDomain("string").build())
                .searchContextSize(BetaWebSearchTool.SearchContextSize.LOW)
                .userLocation(
                    BetaWebSearchTool.UserLocation.builder()
                        .city("city")
                        .country("country")
                        .region("region")
                        .timezone("timezone")
                        .type(BetaWebSearchTool.UserLocation.Type.APPROXIMATE)
                        .build()
                )
                .build()

        val roundtrippedBetaWebSearchTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaWebSearchTool),
                jacksonTypeRef<BetaWebSearchTool>(),
            )

        assertThat(roundtrippedBetaWebSearchTool).isEqualTo(betaWebSearchTool)
    }
}
