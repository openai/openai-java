// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AssistantDeleteParamsTest {

    @Test
    fun create() {
        AssistantDeleteParams.builder().assistantId("assistant_id").build()
    }

    @Test
    fun getPathParam() {
        val params = AssistantDeleteParams.builder().assistantId("assistant_id").build()
        assertThat(params).isNotNull
        // path param "assistantId"
        assertThat(params.getPathParam(0)).isEqualTo("assistant_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
