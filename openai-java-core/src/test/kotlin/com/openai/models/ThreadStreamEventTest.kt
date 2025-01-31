// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ThreadStreamEventTest {

    @Test
    fun createThreadStreamEvent() {
        val threadStreamEvent =
            ThreadStreamEvent.builder()
                .data(
                    Thread.builder()
                        .id("id")
                        .createdAt(0L)
                        .metadata(
                            Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .toolResources(
                            Thread.ToolResources.builder()
                                .codeInterpreter(
                                    Thread.ToolResources.CodeInterpreter.builder()
                                        .addFileId("string")
                                        .build()
                                )
                                .fileSearch(
                                    Thread.ToolResources.FileSearch.builder()
                                        .addVectorStoreId("string")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .enabled(true)
                .build()
        assertThat(threadStreamEvent).isNotNull
        assertThat(threadStreamEvent.data())
            .isEqualTo(
                Thread.builder()
                    .id("id")
                    .createdAt(0L)
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .toolResources(
                        Thread.ToolResources.builder()
                            .codeInterpreter(
                                Thread.ToolResources.CodeInterpreter.builder()
                                    .addFileId("string")
                                    .build()
                            )
                            .fileSearch(
                                Thread.ToolResources.FileSearch.builder()
                                    .addVectorStoreId("string")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(threadStreamEvent.enabled()).contains(true)
    }
}
