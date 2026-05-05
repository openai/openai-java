// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime.translations

import com.openai.core.ClientOptions
import java.util.function.Consumer

class CallServiceImpl internal constructor(private val clientOptions: ClientOptions) : CallService {

    private val withRawResponse: CallService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CallService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallService =
        CallServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CallService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CallService.WithRawResponse =
            CallServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
