// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.core.ClientOptions

class MethodServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MethodServiceAsync {

    private val withRawResponse: MethodServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MethodServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MethodServiceAsync.WithRawResponse
}
