// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileSearchToolTest {

    @Test
    fun createFileSearchTool() {
        val fileSearchTool =
            FileSearchTool.builder()
                .type(FileSearchTool.Type.FILE_SEARCH)
                .fileSearch(
                    FileSearchTool.FileSearch.builder()
                        .maxNumResults(1L)
                        .rankingOptions(
                            FileSearchTool.FileSearch.RankingOptions.builder()
                                .scoreThreshold(0.0)
                                .ranker(FileSearchTool.FileSearch.RankingOptions.Ranker.AUTO)
                                .build()
                        )
                        .build()
                )
                .build()
        assertThat(fileSearchTool).isNotNull
        assertThat(fileSearchTool.type()).isEqualTo(FileSearchTool.Type.FILE_SEARCH)
        assertThat(fileSearchTool.fileSearch())
            .contains(
                FileSearchTool.FileSearch.builder()
                    .maxNumResults(1L)
                    .rankingOptions(
                        FileSearchTool.FileSearch.RankingOptions.builder()
                            .scoreThreshold(0.0)
                            .ranker(FileSearchTool.FileSearch.RankingOptions.Ranker.AUTO)
                            .build()
                    )
                    .build()
            )
    }
}
