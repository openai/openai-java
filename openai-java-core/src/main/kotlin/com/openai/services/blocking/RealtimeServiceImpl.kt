// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.realtime.CallService
import com.openai.services.blocking.realtime.CallServiceImpl
import com.openai.services.blocking.realtime.ClientSecretService
import com.openai.services.blocking.realtime.ClientSecretServiceImpl
import java.util.function.Consumer

class RealtimeServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    RealtimeService {

    private val withRawResponse: RealtimeService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val clientSecrets: ClientSecretService by lazy {
        ClientSecretServiceImpl(clientOptions)
    }

    private val calls: CallService by lazy { CallServiceImpl(clientOptions) }

    override fun withRawResponse(): RealtimeService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeService =
        RealtimeServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun clientSecrets(): ClientSecretService = clientSecrets

    override fun calls(): CallService = calls

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RealtimeService.WithRawResponse {

        private val clientSecrets: ClientSecretService.WithRawResponse by lazy {
            ClientSecretServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val calls: CallService.WithRawResponse by lazy {
            CallServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RealtimeService.WithRawResponse =
            RealtimeServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun clientSecrets(): ClientSecretService.WithRawResponse = clientSecrets

        override fun calls(): CallService.WithRawResponse = calls
    }
}
