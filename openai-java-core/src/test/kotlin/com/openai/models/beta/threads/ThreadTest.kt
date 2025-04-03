// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadTest {

    @Test
    fun create() {
        val thread =
            Thread.builder()
                .id("id")
                .createdAt(0L)
                .metadata(
                    Thread.Metadata.builder()
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

        assertThat(thread.id()).isEqualTo("id")
        assertThat(thread.createdAt()).isEqualTo(0L)
        assertThat(thread.metadata())
            .contains(
                Thread.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val thread =
            Thread.builder()
                .id("id")
                .createdAt(0L)
                .metadata(
                    Thread.Metadata.builder()
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

        val roundtrippedThread =
            jsonMapper.readValue(jsonMapper.writeValueAsString(thread), jacksonTypeRef<Thread>())

        assertThat(roundtrippedThread).isEqualTo(thread)
    }
}
