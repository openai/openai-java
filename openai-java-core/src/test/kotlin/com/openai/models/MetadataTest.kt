// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.junit.jupiter.api.Test

internal class MetadataTest {

    @Test
    fun create() {
        val metadata =
            Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
    }
}
