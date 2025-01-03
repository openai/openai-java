// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileSearchToolCallTest {

    @Test
    fun createFileSearchToolCall() {
        val fileSearchToolCall =
            FileSearchToolCall.builder()
                .id("id")
                .fileSearch(
                    FileSearchToolCall.FileSearch.builder()
                        .rankingOptions(
                            FileSearchToolCall.FileSearch.RankingOptions.builder()
                                .ranker(
                                    FileSearchToolCall.FileSearch.RankingOptions.Ranker
                                        .DEFAULT_2024_08_21
                                )
                                .scoreThreshold(0.0)
                                .build()
                        )
                        .results(
                            listOf(
                                FileSearchToolCall.FileSearch.Result.builder()
                                    .fileId("file_id")
                                    .fileName("file_name")
                                    .score(0.0)
                                    .content(
                                        listOf(
                                            FileSearchToolCall.FileSearch.Result.Content.builder()
                                                .text("text")
                                                .type(
                                                    FileSearchToolCall.FileSearch.Result.Content
                                                        .Type
                                                        .TEXT
                                                )
                                                .build()
                                        )
                                    )
                                    .build()
                            )
                        )
                        .build()
                )
                .type(FileSearchToolCall.Type.FILE_SEARCH)
                .build()
        assertThat(fileSearchToolCall).isNotNull
        assertThat(fileSearchToolCall.id()).isEqualTo("id")
        assertThat(fileSearchToolCall.fileSearch())
            .isEqualTo(
                FileSearchToolCall.FileSearch.builder()
                    .rankingOptions(
                        FileSearchToolCall.FileSearch.RankingOptions.builder()
                            .ranker(
                                FileSearchToolCall.FileSearch.RankingOptions.Ranker
                                    .DEFAULT_2024_08_21
                            )
                            .scoreThreshold(0.0)
                            .build()
                    )
                    .results(
                        listOf(
                            FileSearchToolCall.FileSearch.Result.builder()
                                .fileId("file_id")
                                .fileName("file_name")
                                .score(0.0)
                                .content(
                                    listOf(
                                        FileSearchToolCall.FileSearch.Result.Content.builder()
                                            .text("text")
                                            .type(
                                                FileSearchToolCall.FileSearch.Result.Content.Type
                                                    .TEXT
                                            )
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build()
            )
        assertThat(fileSearchToolCall.type()).isEqualTo(FileSearchToolCall.Type.FILE_SEARCH)
    }
}
