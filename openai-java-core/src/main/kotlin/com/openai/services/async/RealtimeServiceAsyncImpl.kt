// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.realtime.ClientSecretServiceAsync
import com.openai.services.async.realtime.ClientSecretServiceAsyncImpl
import java.util.function.Consumer

class RealtimeServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RealtimeServiceAsync {

    private val withRawResponse: RealtimeServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val clientSecrets: ClientSecretServiceAsync by lazy {
        ClientSecretServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): RealtimeServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeServiceAsync =
        RealtimeServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun clientSecrets(): ClientSecretServiceAsync = clientSecrets

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RealtimeServiceAsync.WithRawResponse {

        private val clientSecrets: ClientSecretServiceAsync.WithRawResponse by lazy {
            ClientSecretServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RealtimeServiceAsync.WithRawResponse =
            RealtimeServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun clientSecrets(): ClientSecretServiceAsync.WithRawResponse = clientSecrets
    }
}
