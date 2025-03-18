// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantDeletedTest {

    @Test
    fun create() {
        val assistantDeleted = AssistantDeleted.builder().id("id").deleted(true).build()

        assertThat(assistantDeleted.id()).isEqualTo("id")
        assertThat(assistantDeleted.deleted()).isEqualTo(true)
    }
}
