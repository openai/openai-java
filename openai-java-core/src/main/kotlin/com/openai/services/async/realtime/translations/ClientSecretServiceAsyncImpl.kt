// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.realtime.translations

import com.openai.core.ClientOptions
import java.util.function.Consumer

class ClientSecretServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ClientSecretServiceAsync {

    private val withRawResponse: ClientSecretServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ClientSecretServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ClientSecretServiceAsync =
        ClientSecretServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ClientSecretServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ClientSecretServiceAsync.WithRawResponse =
            ClientSecretServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
