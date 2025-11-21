// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.graders

import com.openai.core.ClientOptions
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class GraderModelServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GraderModelServiceAsync {

    private val withRawResponse: GraderModelServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GraderModelServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderModelServiceAsync =
        GraderModelServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GraderModelServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GraderModelServiceAsync.WithRawResponse =
            GraderModelServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
