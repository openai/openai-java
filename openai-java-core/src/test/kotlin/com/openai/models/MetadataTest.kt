// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MetadataTest {

    @Test
    fun createMetadata() {
        val metadata =
            Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
        assertThat(metadata).isNotNull
    }
}
