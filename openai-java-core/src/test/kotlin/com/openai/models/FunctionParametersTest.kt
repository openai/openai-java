// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionParametersTest {

    @Test
    fun create() {
        val functionParameters =
            FunctionParameters.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val functionParameters =
            FunctionParameters.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()

        val roundtrippedFunctionParameters =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(functionParameters),
                jacksonTypeRef<FunctionParameters>(),
            )

        assertThat(roundtrippedFunctionParameters).isEqualTo(functionParameters)
    }
}
