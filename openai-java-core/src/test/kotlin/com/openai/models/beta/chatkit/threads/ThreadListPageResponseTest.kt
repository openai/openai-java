// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadListPageResponseTest {

    @Test
    fun create() {
        val threadListPageResponse =
            ThreadListPageResponse.builder()
                .addData(
                    ChatKitThread.builder()
                        .id("cthr_def456")
                        .createdAt(1712345600L)
                        .statusActive()
                        .title("Demo feedback")
                        .user("user_456")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(threadListPageResponse.data())
            .containsExactly(
                ChatKitThread.builder()
                    .id("cthr_def456")
                    .createdAt(1712345600L)
                    .statusActive()
                    .title("Demo feedback")
                    .user("user_456")
                    .build()
            )
        assertThat(threadListPageResponse.firstId()).contains("first_id")
        assertThat(threadListPageResponse.hasMore()).isEqualTo(true)
        assertThat(threadListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val threadListPageResponse =
            ThreadListPageResponse.builder()
                .addData(
                    ChatKitThread.builder()
                        .id("cthr_def456")
                        .createdAt(1712345600L)
                        .statusActive()
                        .title("Demo feedback")
                        .user("user_456")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedThreadListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(threadListPageResponse),
                jacksonTypeRef<ThreadListPageResponse>(),
            )

        assertThat(roundtrippedThreadListPageResponse).isEqualTo(threadListPageResponse)
    }
}
