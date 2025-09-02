// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.realtime.SessionService
import com.openai.services.blocking.beta.realtime.SessionServiceImpl
import com.openai.services.blocking.beta.realtime.TranscriptionSessionService
import com.openai.services.blocking.beta.realtime.TranscriptionSessionServiceImpl
import java.util.function.Consumer

@Deprecated(
    "Realtime has now launched and is generally available. The old beta API is now deprecated."
)
class RealtimeServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    RealtimeService {

    private val withRawResponse: RealtimeService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sessions: SessionService by lazy { SessionServiceImpl(clientOptions) }

    private val transcriptionSessions: TranscriptionSessionService by lazy {
        TranscriptionSessionServiceImpl(clientOptions)
    }

    override fun withRawResponse(): RealtimeService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeService =
        RealtimeServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun sessions(): SessionService = sessions

    override fun transcriptionSessions(): TranscriptionSessionService = transcriptionSessions

    @Deprecated(
        "Realtime has now launched and is generally available. The old beta API is now deprecated."
    )
    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RealtimeService.WithRawResponse {

        private val sessions: SessionService.WithRawResponse by lazy {
            SessionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val transcriptionSessions: TranscriptionSessionService.WithRawResponse by lazy {
            TranscriptionSessionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RealtimeService.WithRawResponse =
            RealtimeServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun sessions(): SessionService.WithRawResponse = sessions

        override fun transcriptionSessions(): TranscriptionSessionService.WithRawResponse =
            transcriptionSessions
    }
}
