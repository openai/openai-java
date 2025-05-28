// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.core.ClientOptions
import com.openai.services.async.finetuning.alpha.GraderServiceAsync
import com.openai.services.async.finetuning.alpha.GraderServiceAsyncImpl

class AlphaServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AlphaServiceAsync {

    private val withRawResponse: AlphaServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val graders: GraderServiceAsync by lazy { GraderServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): AlphaServiceAsync.WithRawResponse = withRawResponse

    override fun graders(): GraderServiceAsync = graders

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AlphaServiceAsync.WithRawResponse {

        private val graders: GraderServiceAsync.WithRawResponse by lazy {
            GraderServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun graders(): GraderServiceAsync.WithRawResponse = graders
    }
}
