// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime.translations

import com.openai.core.ClientOptions
import java.util.function.Consumer

class ClientSecretServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ClientSecretService {

    private val withRawResponse: ClientSecretService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ClientSecretService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ClientSecretService =
        ClientSecretServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ClientSecretService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ClientSecretService.WithRawResponse =
            ClientSecretServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
