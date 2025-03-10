// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.openai.core.JsonValue
import com.openai.models.Metadata
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ThreadTest {

    @Test
    fun createThread() {
        val thread =
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
        assertThat(thread).isNotNull
        assertThat(thread.id()).isEqualTo("id")
        assertThat(thread.createdAt()).isEqualTo(0L)
        assertThat(thread.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
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
