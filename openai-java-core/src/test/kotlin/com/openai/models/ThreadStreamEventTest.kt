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
                        .metadata(JsonValue.from(mapOf<String, Any>()))
                        .object_(Thread.Object.THREAD)
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
                .event(ThreadStreamEvent.Event.THREAD_CREATED)
                .enabled(true)
                .build()
        assertThat(threadStreamEvent).isNotNull
        assertThat(threadStreamEvent.data())
            .isEqualTo(
                Thread.builder()
                    .id("id")
                    .createdAt(0L)
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .object_(Thread.Object.THREAD)
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
        assertThat(threadStreamEvent.event()).isEqualTo(ThreadStreamEvent.Event.THREAD_CREATED)
        assertThat(threadStreamEvent.enabled()).contains(true)
    }
}
