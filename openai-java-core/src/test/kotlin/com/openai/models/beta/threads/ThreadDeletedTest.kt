// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadDeletedTest {

    @Test
    fun create() {
        val threadDeleted = ThreadDeleted.builder().id("id").deleted(true).build()

        assertThat(threadDeleted.id()).isEqualTo("id")
        assertThat(threadDeleted.deleted()).isEqualTo(true)
    }
}
