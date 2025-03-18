// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnnotationDeltaTest {

    @Test
    fun ofFileCitation() {
        val fileCitation = FileCitationDeltaAnnotation.builder().index(0L).build()

        val annotationDelta = AnnotationDelta.ofFileCitation(fileCitation)

        assertThat(annotationDelta.fileCitation()).contains(fileCitation)
        assertThat(annotationDelta.filePath()).isEmpty
    }

    @Test
    fun ofFilePath() {
        val filePath = FilePathDeltaAnnotation.builder().index(0L).build()

        val annotationDelta = AnnotationDelta.ofFilePath(filePath)

        assertThat(annotationDelta.fileCitation()).isEmpty
        assertThat(annotationDelta.filePath()).contains(filePath)
    }
}
