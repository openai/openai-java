// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCompactParamsTest {

    @Test
    fun create() {
        ResponseCompactParams.builder()
            .model(ResponseCompactParams.Model.GPT_5_4)
            .input("string")
            .instructions("instructions")
            .previousResponseId("resp_123")
            .promptCacheKey("prompt_cache_key")
            .promptCacheRetention(ResponseCompactParams.PromptCacheRetention.IN_MEMORY)
            .serviceTier(ResponseCompactParams.ServiceTier.AUTO)
            .build()
    }

    @Test
    fun body() {
        val params =
            ResponseCompactParams.builder()
                .model(ResponseCompactParams.Model.GPT_5_4)
                .input("string")
                .instructions("instructions")
                .previousResponseId("resp_123")
                .promptCacheKey("prompt_cache_key")
                .promptCacheRetention(ResponseCompactParams.PromptCacheRetention.IN_MEMORY)
                .serviceTier(ResponseCompactParams.ServiceTier.AUTO)
                .build()

        val body = params._body()

        assertThat(body.model()).contains(ResponseCompactParams.Model.GPT_5_4)
        assertThat(body.input()).contains(ResponseCompactParams.Input.ofString("string"))
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.previousResponseId()).contains("resp_123")
        assertThat(body.promptCacheKey()).contains("prompt_cache_key")
        assertThat(body.promptCacheRetention())
            .contains(ResponseCompactParams.PromptCacheRetention.IN_MEMORY)
        assertThat(body.serviceTier()).contains(ResponseCompactParams.ServiceTier.AUTO)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ResponseCompactParams.builder().model(ResponseCompactParams.Model.GPT_5_4).build()

        val body = params._body()

        assertThat(body.model()).contains(ResponseCompactParams.Model.GPT_5_4)
    }
}
