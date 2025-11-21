// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.core.ClientOptions
import com.openai.core.withCancellation
import com.openai.services.async.finetuning.alpha.GraderServiceAsync
import com.openai.services.async.finetuning.alpha.GraderServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AlphaServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AlphaServiceAsync {

    private val withRawResponse: AlphaServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val graders: GraderServiceAsync by lazy { GraderServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): AlphaServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlphaServiceAsync =
        AlphaServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun graders(): GraderServiceAsync = graders

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AlphaServiceAsync.WithRawResponse {

        private val graders: GraderServiceAsync.WithRawResponse by lazy {
            GraderServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AlphaServiceAsync.WithRawResponse =
            AlphaServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun graders(): GraderServiceAsync.WithRawResponse = graders
    }
}
