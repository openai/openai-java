// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.moderations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CsamModerationResponseTest {

    @Test
    fun createAndRoundtrip() {
        val csamModerationResponse =
            CsamModerationResponse.builder()
                .id("id")
                .addResult(
                    CsamModeration.builder()
                        .categories(
                            CsamModeration.Categories.builder()
                                .likelyCsam(true)
                                .likelyCsamGenAi(true)
                                .build()
                        )
                        .categoryAppliedInputTypes(
                            CsamModeration.CategoryAppliedInputTypes.builder()
                                .addLikelyCsam(
                                    CsamModeration.CategoryAppliedInputTypes.LikelyCsam.IMAGE
                                )
                                .addLikelyCsamGenAi(
                                    CsamModeration.CategoryAppliedInputTypes.LikelyCsamGenAi.IMAGE
                                )
                                .build()
                        )
                        .categoryScores(
                            CsamModeration.CategoryScores.builder()
                                .likelyCsam(0.0)
                                .likelyCsamGenAi(0.0)
                                .build()
                        )
                        .flagged(true)
                        .build()
                )
                .build()

        assertThat(csamModerationResponse.id()).contains("id")
        assertThat(csamModerationResponse.results().getOrNull())
            .containsExactly(
                CsamModeration.builder()
                    .categories(
                        CsamModeration.Categories.builder()
                            .likelyCsam(true)
                            .likelyCsamGenAi(true)
                            .build()
                    )
                    .categoryAppliedInputTypes(
                        CsamModeration.CategoryAppliedInputTypes.builder()
                            .addLikelyCsam(
                                CsamModeration.CategoryAppliedInputTypes.LikelyCsam.IMAGE
                            )
                            .addLikelyCsamGenAi(
                                CsamModeration.CategoryAppliedInputTypes.LikelyCsamGenAi.IMAGE
                            )
                            .build()
                    )
                    .categoryScores(
                        CsamModeration.CategoryScores.builder()
                            .likelyCsam(0.0)
                            .likelyCsamGenAi(0.0)
                            .build()
                    )
                    .flagged(true)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedCsamModerationResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(csamModerationResponse),
                jacksonTypeRef<CsamModerationResponse>(),
            )

        assertThat(roundtrippedCsamModerationResponse).isEqualTo(csamModerationResponse)
    }
}
