// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.junit.jupiter.api.Test

internal class FunctionParametersTest {

    @Test
    fun create() {
        val functionParameters =
            FunctionParameters.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
    }
}
