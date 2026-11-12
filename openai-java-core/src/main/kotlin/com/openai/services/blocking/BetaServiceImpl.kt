// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.AgentService
import com.openai.services.blocking.beta.AgentServiceImpl
import com.openai.services.blocking.beta.ChatKitService
import com.openai.services.blocking.beta.ChatKitServiceImpl
import com.openai.services.blocking.beta.RealtimeService
import com.openai.services.blocking.beta.RealtimeServiceImpl
import com.openai.services.blocking.beta.ResponseService
import com.openai.services.blocking.beta.ResponseServiceImpl
import java.util.function.Consumer

class BetaServiceImpl internal constructor(private val clientOptions: ClientOptions) : BetaService {

    private val withRawResponse: BetaService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val realtime: RealtimeService by lazy { RealtimeServiceImpl(clientOptions) }

    private val agents: AgentService by lazy { AgentServiceImpl(clientOptions) }

    private val responses: ResponseService by lazy { ResponseServiceImpl(clientOptions) }

    private val chatkit: ChatKitService by lazy { ChatKitServiceImpl(clientOptions) }

    override fun withRawResponse(): BetaService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaService =
        BetaServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    @Deprecated(
        "Realtime has now launched and is generally available. The old beta API is now deprecated."
    )
    override fun realtime(): RealtimeService = realtime

    override fun agents(): AgentService = agents

    /** Create and manage model responses. */
    override fun responses(): ResponseService = responses

    override fun chatkit(): ChatKitService = chatkit

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaService.WithRawResponse {

        private val realtime: RealtimeService.WithRawResponse by lazy {
            RealtimeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val agents: AgentService.WithRawResponse by lazy {
            AgentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val responses: ResponseService.WithRawResponse by lazy {
            ResponseServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val chatkit: ChatKitService.WithRawResponse by lazy {
            ChatKitServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BetaService.WithRawResponse =
            BetaServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        @Deprecated(
            "Realtime has now launched and is generally available. The old beta API is now deprecated."
        )
        override fun realtime(): RealtimeService.WithRawResponse = realtime

        override fun agents(): AgentService.WithRawResponse = agents

        /** Create and manage model responses. */
        override fun responses(): ResponseService.WithRawResponse = responses

        override fun chatkit(): ChatKitService.WithRawResponse = chatkit
    }
}
