// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantRetrieveParamsTest {

    @Test
    fun create() {
        AssistantRetrieveParams.builder().assistantId("assistant_id").build()
    }

    @Test
    fun pathParams() {
        val params = AssistantRetrieveParams.builder().assistantId("assistant_id").build()

        assertThat(params._pathParam(0)).isEqualTo("assistant_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
