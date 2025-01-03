// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ThreadDeletedTest {

    @Test
    fun createThreadDeleted() {
        val threadDeleted =
            ThreadDeleted.builder()
                .id("id")
                .deleted(true)
                .object_(ThreadDeleted.Object.THREAD_DELETED)
                .build()
        assertThat(threadDeleted).isNotNull
        assertThat(threadDeleted.id()).isEqualTo("id")
        assertThat(threadDeleted.deleted()).isEqualTo(true)
        assertThat(threadDeleted.object_()).isEqualTo(ThreadDeleted.Object.THREAD_DELETED)
    }
}
