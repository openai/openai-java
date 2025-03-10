// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelDeletedTest {

    @Test
    fun createModelDeleted() {
        val modelDeleted = ModelDeleted.builder().id("id").deleted(true).object_("object").build()
        assertThat(modelDeleted).isNotNull
        assertThat(modelDeleted.id()).isEqualTo("id")
        assertThat(modelDeleted.deleted()).isEqualTo(true)
        assertThat(modelDeleted.object_()).isEqualTo("object")
    }
}
