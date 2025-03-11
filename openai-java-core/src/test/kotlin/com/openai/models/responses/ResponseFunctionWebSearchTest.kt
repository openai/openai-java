// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseFunctionWebSearchTest {

    @Test
    fun createResponseFunctionWebSearch() {
        val responseFunctionWebSearch =
            ResponseFunctionWebSearch.builder()
                .id("id")
                .status(ResponseFunctionWebSearch.Status.IN_PROGRESS)
                .build()
        assertThat(responseFunctionWebSearch).isNotNull
        assertThat(responseFunctionWebSearch.id()).isEqualTo("id")
        assertThat(responseFunctionWebSearch.status())
            .isEqualTo(ResponseFunctionWebSearch.Status.IN_PROGRESS)
    }
}
