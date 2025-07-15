// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.RealtimeService
import com.openai.services.blocking.beta.RealtimeServiceImpl
import java.util.function.Consumer

class BetaServiceImpl internal constructor(private val clientOptions: ClientOptions) : BetaService {

    private val withRawResponse: BetaService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val realtime: RealtimeService by lazy { RealtimeServiceImpl(clientOptions) }

    override fun withRawResponse(): BetaService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaService =
        BetaServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun realtime(): RealtimeService = realtime

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaService.WithRawResponse {

        private val realtime: RealtimeService.WithRawResponse by lazy {
            RealtimeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BetaService.WithRawResponse =
            BetaServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun realtime(): RealtimeService.WithRawResponse = realtime
    }
}
