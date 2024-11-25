// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelTest {

    @Test
    fun createModel() {
        val model =
            Model.builder()
                .id("id")
                .created(0L)
                .object_(Model.Object.MODEL)
                .ownedBy("owned_by")
                .build()
        assertThat(model).isNotNull
        assertThat(model.id()).isEqualTo("id")
        assertThat(model.created()).isEqualTo(0L)
        assertThat(model.object_()).isEqualTo(Model.Object.MODEL)
        assertThat(model.ownedBy()).isEqualTo("owned_by")
    }
}
