// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.withCancellation
import com.openai.services.async.graders.GraderModelServiceAsync
import com.openai.services.async.graders.GraderModelServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class GraderServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GraderServiceAsync {

    private val withRawResponse: GraderServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val graderModels: GraderModelServiceAsync by lazy {
        GraderModelServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): GraderServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderServiceAsync =
        GraderServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun graderModels(): GraderModelServiceAsync = graderModels

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GraderServiceAsync.WithRawResponse {

        private val graderModels: GraderModelServiceAsync.WithRawResponse by lazy {
            GraderModelServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GraderServiceAsync.WithRawResponse =
            GraderServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun graderModels(): GraderModelServiceAsync.WithRawResponse = graderModels
    }
}
