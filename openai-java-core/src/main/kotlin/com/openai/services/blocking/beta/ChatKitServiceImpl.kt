// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.chatkit.SessionService
import com.openai.services.blocking.beta.chatkit.SessionServiceImpl
import com.openai.services.blocking.beta.chatkit.ThreadService
import com.openai.services.blocking.beta.chatkit.ThreadServiceImpl
import java.util.function.Consumer

class ChatKitServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ChatKitService {

    private val withRawResponse: ChatKitService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sessions: SessionService by lazy { SessionServiceImpl(clientOptions) }

    private val threads: ThreadService by lazy { ThreadServiceImpl(clientOptions) }

    override fun withRawResponse(): ChatKitService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitService =
        ChatKitServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun sessions(): SessionService = sessions

    override fun threads(): ThreadService = threads

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatKitService.WithRawResponse {

        private val sessions: SessionService.WithRawResponse by lazy {
            SessionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val threads: ThreadService.WithRawResponse by lazy {
            ThreadServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatKitService.WithRawResponse =
            ChatKitServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun sessions(): SessionService.WithRawResponse = sessions

        override fun threads(): ThreadService.WithRawResponse = threads
    }
}
