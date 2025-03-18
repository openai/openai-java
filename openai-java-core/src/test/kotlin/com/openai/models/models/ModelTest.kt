// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelTest {

    @Test
    fun create() {
        val model = Model.builder().id("id").created(0L).ownedBy("owned_by").build()

        assertThat(model.id()).isEqualTo("id")
        assertThat(model.created()).isEqualTo(0L)
        assertThat(model.ownedBy()).isEqualTo("owned_by")
    }
}
