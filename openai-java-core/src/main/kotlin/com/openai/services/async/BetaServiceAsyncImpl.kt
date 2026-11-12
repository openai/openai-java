// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.beta.AgentServiceAsync
import com.openai.services.async.beta.AgentServiceAsyncImpl
import com.openai.services.async.beta.ChatKitServiceAsync
import com.openai.services.async.beta.ChatKitServiceAsyncImpl
import com.openai.services.async.beta.RealtimeServiceAsync
import com.openai.services.async.beta.RealtimeServiceAsyncImpl
import com.openai.services.async.beta.ResponseServiceAsync
import com.openai.services.async.beta.ResponseServiceAsyncImpl
import java.util.function.Consumer

class BetaServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BetaServiceAsync {

    private val withRawResponse: BetaServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val realtime: RealtimeServiceAsync by lazy { RealtimeServiceAsyncImpl(clientOptions) }

    private val agents: AgentServiceAsync by lazy { AgentServiceAsyncImpl(clientOptions) }

    private val responses: ResponseServiceAsync by lazy { ResponseServiceAsyncImpl(clientOptions) }

    private val chatkit: ChatKitServiceAsync by lazy { ChatKitServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): BetaServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaServiceAsync =
        BetaServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    @Deprecated(
        "Realtime has now launched and is generally available. The old beta API is now deprecated."
    )
    override fun realtime(): RealtimeServiceAsync = realtime

    override fun agents(): AgentServiceAsync = agents

    /** Create and manage model responses. */
    override fun responses(): ResponseServiceAsync = responses

    override fun chatkit(): ChatKitServiceAsync = chatkit

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaServiceAsync.WithRawResponse {

        private val realtime: RealtimeServiceAsync.WithRawResponse by lazy {
            RealtimeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val agents: AgentServiceAsync.WithRawResponse by lazy {
            AgentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val responses: ResponseServiceAsync.WithRawResponse by lazy {
            ResponseServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val chatkit: ChatKitServiceAsync.WithRawResponse by lazy {
            ChatKitServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BetaServiceAsync.WithRawResponse =
            BetaServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        @Deprecated(
            "Realtime has now launched and is generally available. The old beta API is now deprecated."
        )
        override fun realtime(): RealtimeServiceAsync.WithRawResponse = realtime

        override fun agents(): AgentServiceAsync.WithRawResponse = agents

        /** Create and manage model responses. */
        override fun responses(): ResponseServiceAsync.WithRawResponse = responses

        override fun chatkit(): ChatKitServiceAsync.WithRawResponse = chatkit
    }
}
