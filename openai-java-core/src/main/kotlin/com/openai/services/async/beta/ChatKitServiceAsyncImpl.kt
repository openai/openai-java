// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.core.withCancellation
import com.openai.services.async.beta.chatkit.SessionServiceAsync
import com.openai.services.async.beta.chatkit.SessionServiceAsyncImpl
import com.openai.services.async.beta.chatkit.ThreadServiceAsync
import com.openai.services.async.beta.chatkit.ThreadServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ChatKitServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ChatKitServiceAsync {

    private val withRawResponse: ChatKitServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sessions: SessionServiceAsync by lazy { SessionServiceAsyncImpl(clientOptions) }

    private val threads: ThreadServiceAsync by lazy { ThreadServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ChatKitServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitServiceAsync =
        ChatKitServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun sessions(): SessionServiceAsync = sessions

    override fun threads(): ThreadServiceAsync = threads

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatKitServiceAsync.WithRawResponse {

        private val sessions: SessionServiceAsync.WithRawResponse by lazy {
            SessionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val threads: ThreadServiceAsync.WithRawResponse by lazy {
            ThreadServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatKitServiceAsync.WithRawResponse =
            ChatKitServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun sessions(): SessionServiceAsync.WithRawResponse = sessions

        override fun threads(): ThreadServiceAsync.WithRawResponse = threads
    }
}
