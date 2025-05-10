// File generated from our OpenAPI spec by Stainless.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PythonGraderTest {

    @Test
    fun create() {
        val pythonGrader =
            PythonGrader.builder().name("name").source("source").imageTag("image_tag").build()

        assertThat(pythonGrader.name()).isEqualTo("name")
        assertThat(pythonGrader.source()).isEqualTo("source")
        assertThat(pythonGrader.imageTag()).contains("image_tag")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val pythonGrader =
            PythonGrader.builder().name("name").source("source").imageTag("image_tag").build()

        val roundtrippedPythonGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(pythonGrader),
                jacksonTypeRef<PythonGrader>(),
            )

        assertThat(roundtrippedPythonGrader).isEqualTo(pythonGrader)
    }
}
