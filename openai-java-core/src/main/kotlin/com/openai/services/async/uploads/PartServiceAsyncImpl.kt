// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.uploads

import com.openai.core.ClientOptions

class PartServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PartServiceAsync {

    private val withRawResponse: PartServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PartServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PartServiceAsync.WithRawResponse
}
