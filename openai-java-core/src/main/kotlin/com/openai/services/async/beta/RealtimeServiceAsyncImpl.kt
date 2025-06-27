// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.services.async.beta.realtime.SessionServiceAsync
import com.openai.services.async.beta.realtime.SessionServiceAsyncImpl
import com.openai.services.async.beta.realtime.TranscriptionSessionServiceAsync
import com.openai.services.async.beta.realtime.TranscriptionSessionServiceAsyncImpl
import java.util.function.Consumer

class RealtimeServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RealtimeServiceAsync {

    private val withRawResponse: RealtimeServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sessions: SessionServiceAsync by lazy { SessionServiceAsyncImpl(clientOptions) }

    private val transcriptionSessions: TranscriptionSessionServiceAsync by lazy {
        TranscriptionSessionServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): RealtimeServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeServiceAsync =
        RealtimeServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun sessions(): SessionServiceAsync = sessions

    override fun transcriptionSessions(): TranscriptionSessionServiceAsync = transcriptionSessions

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RealtimeServiceAsync.WithRawResponse {

        private val sessions: SessionServiceAsync.WithRawResponse by lazy {
            SessionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val transcriptionSessions:
            TranscriptionSessionServiceAsync.WithRawResponse by lazy {
            TranscriptionSessionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RealtimeServiceAsync.WithRawResponse =
            RealtimeServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun sessions(): SessionServiceAsync.WithRawResponse = sessions

        override fun transcriptionSessions(): TranscriptionSessionServiceAsync.WithRawResponse =
            transcriptionSessions
    }
}
