// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.contentprovenancechecks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContentProvenanceCheckTest {

    @Test
    fun create() {
        val contentProvenanceCheck =
            ContentProvenanceCheck.builder()
                .createdAt(0L)
                .object_(ContentProvenanceCheck.Object.CONTENT_PROVENANCE_CHECK)
                .addResult(
                    ContentProvenanceCheck.Result.C2pa.builder()
                        .generatedAt("generated_at")
                        .issuer("issuer")
                        .model("model")
                        .outcome(ContentProvenanceCheck.Result.C2pa.Outcome.DETECTED)
                        .validationState(ContentProvenanceCheck.Result.C2pa.ValidationState.TRUSTED)
                        .build()
                )
                .build()

        assertThat(contentProvenanceCheck.createdAt()).isEqualTo(0L)
        assertThat(contentProvenanceCheck.object_())
            .isEqualTo(ContentProvenanceCheck.Object.CONTENT_PROVENANCE_CHECK)
        assertThat(contentProvenanceCheck.results())
            .containsExactly(
                ContentProvenanceCheck.Result.ofC2pa(
                    ContentProvenanceCheck.Result.C2pa.builder()
                        .generatedAt("generated_at")
                        .issuer("issuer")
                        .model("model")
                        .outcome(ContentProvenanceCheck.Result.C2pa.Outcome.DETECTED)
                        .validationState(ContentProvenanceCheck.Result.C2pa.ValidationState.TRUSTED)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contentProvenanceCheck =
            ContentProvenanceCheck.builder()
                .createdAt(0L)
                .object_(ContentProvenanceCheck.Object.CONTENT_PROVENANCE_CHECK)
                .addResult(
                    ContentProvenanceCheck.Result.C2pa.builder()
                        .generatedAt("generated_at")
                        .issuer("issuer")
                        .model("model")
                        .outcome(ContentProvenanceCheck.Result.C2pa.Outcome.DETECTED)
                        .validationState(ContentProvenanceCheck.Result.C2pa.ValidationState.TRUSTED)
                        .build()
                )
                .build()

        val roundtrippedContentProvenanceCheck =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contentProvenanceCheck),
                jacksonTypeRef<ContentProvenanceCheck>(),
            )

        assertThat(roundtrippedContentProvenanceCheck).isEqualTo(contentProvenanceCheck)
    }
}
