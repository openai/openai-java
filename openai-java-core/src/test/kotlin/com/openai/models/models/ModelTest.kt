// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelTest {

    @Test
    fun create() {
        val model =
            Model.builder()
                .id("id")
                .created(0L)
                .ownedBy("owned_by")
                .shutdownDate(LocalDate.parse("2019-12-27"))
                .build()

        assertThat(model.id()).isEqualTo("id")
        assertThat(model.created()).isEqualTo(0L)
        assertThat(model.ownedBy()).isEqualTo("owned_by")
        assertThat(model.shutdownDate()).contains(LocalDate.parse("2019-12-27"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val model =
            Model.builder()
                .id("id")
                .created(0L)
                .ownedBy("owned_by")
                .shutdownDate(LocalDate.parse("2019-12-27"))
                .build()

        val roundtrippedModel =
            jsonMapper.readValue(jsonMapper.writeValueAsString(model), jacksonTypeRef<Model>())

        assertThat(roundtrippedModel).isEqualTo(model)
    }
}
