// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TextTest {

    @Test
    fun createAndRoundtrip() {
        val text =
            Text.builder()
                .addAnnotation(
                    FileCitationAnnotation.builder()
                        .endIndex(0L)
                        .fileCitation(
                            FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                        )
                        .startIndex(0L)
                        .text("text")
                        .build()
                )
                .value("value")
                .build()

        assertThat(text.annotations())
            .containsExactly(
                Annotation.ofFileCitation(
                    FileCitationAnnotation.builder()
                        .endIndex(0L)
                        .fileCitation(
                            FileCitationAnnotation.FileCitation.builder().fileId("file_id").build()
                        )
                        .startIndex(0L)
                        .text("text")
                        .build()
                )
            )
        assertThat(text.value()).isEqualTo("value")

        val jsonMapper = jsonMapper()

        val roundtrippedText =
            jsonMapper.readValue(jsonMapper.writeValueAsString(text), jacksonTypeRef<Text>())

        assertThat(roundtrippedText).isEqualTo(text)
    }
}
