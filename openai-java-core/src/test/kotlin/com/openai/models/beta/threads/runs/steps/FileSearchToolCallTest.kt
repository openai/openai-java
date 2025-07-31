// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileSearchToolCallTest {

    @Test
    fun create() {
        val fileSearchToolCall =
            FileSearchToolCall.builder()
                .id("id")
                .fileSearch(
                    FileSearchToolCall.FileSearch.builder()
                        .rankingOptions(
                            FileSearchToolCall.FileSearch.RankingOptions.builder()
                                .ranker(FileSearchToolCall.FileSearch.RankingOptions.Ranker.AUTO)
                                .scoreThreshold(0.0)
                                .build()
                        )
                        .addResult(
                            FileSearchToolCall.FileSearch.Result.builder()
                                .fileId("file_id")
                                .fileName("file_name")
                                .score(0.0)
                                .addContent(
                                    FileSearchToolCall.FileSearch.Result.Content.builder()
                                        .text("text")
                                        .type(
                                            FileSearchToolCall.FileSearch.Result.Content.Type.TEXT
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(fileSearchToolCall.id()).isEqualTo("id")
        assertThat(fileSearchToolCall.fileSearch())
            .isEqualTo(
                FileSearchToolCall.FileSearch.builder()
                    .rankingOptions(
                        FileSearchToolCall.FileSearch.RankingOptions.builder()
                            .ranker(FileSearchToolCall.FileSearch.RankingOptions.Ranker.AUTO)
                            .scoreThreshold(0.0)
                            .build()
                    )
                    .addResult(
                        FileSearchToolCall.FileSearch.Result.builder()
                            .fileId("file_id")
                            .fileName("file_name")
                            .score(0.0)
                            .addContent(
                                FileSearchToolCall.FileSearch.Result.Content.builder()
                                    .text("text")
                                    .type(FileSearchToolCall.FileSearch.Result.Content.Type.TEXT)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileSearchToolCall =
            FileSearchToolCall.builder()
                .id("id")
                .fileSearch(
                    FileSearchToolCall.FileSearch.builder()
                        .rankingOptions(
                            FileSearchToolCall.FileSearch.RankingOptions.builder()
                                .ranker(FileSearchToolCall.FileSearch.RankingOptions.Ranker.AUTO)
                                .scoreThreshold(0.0)
                                .build()
                        )
                        .addResult(
                            FileSearchToolCall.FileSearch.Result.builder()
                                .fileId("file_id")
                                .fileName("file_name")
                                .score(0.0)
                                .addContent(
                                    FileSearchToolCall.FileSearch.Result.Content.builder()
                                        .text("text")
                                        .type(
                                            FileSearchToolCall.FileSearch.Result.Content.Type.TEXT
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedFileSearchToolCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileSearchToolCall),
                jacksonTypeRef<FileSearchToolCall>(),
            )

        assertThat(roundtrippedFileSearchToolCall).isEqualTo(fileSearchToolCall)
    }
}
