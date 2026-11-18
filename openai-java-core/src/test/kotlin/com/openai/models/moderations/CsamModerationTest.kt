// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.moderations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CsamModerationTest {

    @Test
    fun createAndRoundtrip() {
        val csamModeration =
            CsamModeration.builder()
                .categories(
                    CsamModeration.Categories.builder()
                        .likelyCsam(true)
                        .likelyCsamGenAi(true)
                        .build()
                )
                .categoryAppliedInputTypes(
                    CsamModeration.CategoryAppliedInputTypes.builder()
                        .addLikelyCsam(CsamModeration.CategoryAppliedInputTypes.LikelyCsam.IMAGE)
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

        assertThat(csamModeration.categories())
            .isEqualTo(
                CsamModeration.Categories.builder().likelyCsam(true).likelyCsamGenAi(true).build()
            )
        assertThat(csamModeration.categoryAppliedInputTypes())
            .isEqualTo(
                CsamModeration.CategoryAppliedInputTypes.builder()
                    .addLikelyCsam(CsamModeration.CategoryAppliedInputTypes.LikelyCsam.IMAGE)
                    .addLikelyCsamGenAi(
                        CsamModeration.CategoryAppliedInputTypes.LikelyCsamGenAi.IMAGE
                    )
                    .build()
            )
        assertThat(csamModeration.categoryScores())
            .isEqualTo(
                CsamModeration.CategoryScores.builder().likelyCsam(0.0).likelyCsamGenAi(0.0).build()
            )
        assertThat(csamModeration.flagged()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedCsamModeration =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(csamModeration),
                jacksonTypeRef<CsamModeration>(),
            )

        assertThat(roundtrippedCsamModeration).isEqualTo(csamModeration)
    }
}
