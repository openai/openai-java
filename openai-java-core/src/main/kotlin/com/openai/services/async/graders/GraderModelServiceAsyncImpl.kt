// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.graders

import com.openai.core.ClientOptions

class GraderModelServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GraderModelServiceAsync {

    private val withRawResponse: GraderModelServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GraderModelServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GraderModelServiceAsync.WithRawResponse
}
