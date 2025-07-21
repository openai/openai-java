// File generated from our OpenAPI spec by Stainless.

package com.openai.springboot

import com.openai.client.okhttp.OpenAIOkHttpClient

fun interface OpenAIClientCustomizer {

    fun customize(builder: OpenAIOkHttpClient.Builder)
}
