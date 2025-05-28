// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.core.ClientOptions

class MethodServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MethodService {

    private val withRawResponse: MethodService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MethodService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MethodService.WithRawResponse
}
