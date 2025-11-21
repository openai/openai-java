// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.withCancellation
import com.openai.services.async.realtime.CallServiceAsync
import com.openai.services.async.realtime.CallServiceAsyncImpl
import com.openai.services.async.realtime.ClientSecretServiceAsync
import com.openai.services.async.realtime.ClientSecretServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class RealtimeServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RealtimeServiceAsync {

    private val withRawResponse: RealtimeServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val clientSecrets: ClientSecretServiceAsync by lazy {
        ClientSecretServiceAsyncImpl(clientOptions)
    }

    private val calls: CallServiceAsync by lazy { CallServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): RealtimeServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeServiceAsync =
        RealtimeServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun clientSecrets(): ClientSecretServiceAsync = clientSecrets

    override fun calls(): CallServiceAsync = calls

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RealtimeServiceAsync.WithRawResponse {

        private val clientSecrets: ClientSecretServiceAsync.WithRawResponse by lazy {
            ClientSecretServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val calls: CallServiceAsync.WithRawResponse by lazy {
            CallServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RealtimeServiceAsync.WithRawResponse =
            RealtimeServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun clientSecrets(): ClientSecretServiceAsync.WithRawResponse = clientSecrets

        override fun calls(): CallServiceAsync.WithRawResponse = calls
    }
}
