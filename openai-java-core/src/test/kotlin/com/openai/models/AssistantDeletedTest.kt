// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssistantDeletedTest {

    @Test
    fun createAssistantDeleted() {
        val assistantDeleted =
            AssistantDeleted.builder()
                .id("id")
                .deleted(true)
                .object_(AssistantDeleted.Object.ASSISTANT_DELETED)
                .build()
        assertThat(assistantDeleted).isNotNull
        assertThat(assistantDeleted.id()).isEqualTo("id")
        assertThat(assistantDeleted.deleted()).isEqualTo(true)
        assertThat(assistantDeleted.object_()).isEqualTo(AssistantDeleted.Object.ASSISTANT_DELETED)
    }
}
