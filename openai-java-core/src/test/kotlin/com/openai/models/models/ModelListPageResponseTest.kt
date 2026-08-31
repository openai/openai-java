// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelListPageResponseTest {

    @Test
    fun create() {
        val modelListPageResponse =
            ModelListPageResponse.builder()
                .addData(
                    Model.builder()
                        .id("id")
                        .created(0L)
                        .ownedBy("owned_by")
                        .shutdownDate(LocalDate.parse("2019-12-27"))
                        .build()
                )
                .build()

        assertThat(modelListPageResponse.data())
            .containsExactly(
                Model.builder()
                    .id("id")
                    .created(0L)
                    .ownedBy("owned_by")
                    .shutdownDate(LocalDate.parse("2019-12-27"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val modelListPageResponse =
            ModelListPageResponse.builder()
                .addData(
                    Model.builder()
                        .id("id")
                        .created(0L)
                        .ownedBy("owned_by")
                        .shutdownDate(LocalDate.parse("2019-12-27"))
                        .build()
                )
                .build()

        val roundtrippedModelListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(modelListPageResponse),
                jacksonTypeRef<ModelListPageResponse>(),
            )

        assertThat(roundtrippedModelListPageResponse).isEqualTo(modelListPageResponse)
    }
}
