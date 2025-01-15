// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ThreadTest {

    @Test
    fun createThread() {
        val thread =
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
        assertThat(thread).isNotNull
        assertThat(thread.id()).isEqualTo("id")
        assertThat(thread.createdAt()).isEqualTo(0L)
        assertThat(thread._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(thread.object_()).isEqualTo(Thread.Object.THREAD)
        assertThat(thread.toolResources())
            .contains(
                Thread.ToolResources.builder()
                    .codeInterpreter(
                        Thread.ToolResources.CodeInterpreter.builder().addFileId("string").build()
                    )
                    .fileSearch(
                        Thread.ToolResources.FileSearch.builder().addVectorStoreId("string").build()
                    )
                    .build()
            )
    }
}
