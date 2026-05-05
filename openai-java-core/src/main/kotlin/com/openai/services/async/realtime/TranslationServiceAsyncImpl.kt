// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.realtime

import com.openai.core.ClientOptions
import com.openai.services.async.realtime.translations.CallServiceAsync
import com.openai.services.async.realtime.translations.CallServiceAsyncImpl
import com.openai.services.async.realtime.translations.ClientSecretServiceAsync
import com.openai.services.async.realtime.translations.ClientSecretServiceAsyncImpl
import java.util.function.Consumer

class TranslationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TranslationServiceAsync {

    private val withRawResponse: TranslationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val clientSecrets: ClientSecretServiceAsync by lazy {
        ClientSecretServiceAsyncImpl(clientOptions)
    }

    private val calls: CallServiceAsync by lazy { CallServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): TranslationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranslationServiceAsync =
        TranslationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun clientSecrets(): ClientSecretServiceAsync = clientSecrets

    override fun calls(): CallServiceAsync = calls

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranslationServiceAsync.WithRawResponse {

        private val clientSecrets: ClientSecretServiceAsync.WithRawResponse by lazy {
            ClientSecretServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val calls: CallServiceAsync.WithRawResponse by lazy {
            CallServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranslationServiceAsync.WithRawResponse =
            TranslationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun clientSecrets(): ClientSecretServiceAsync.WithRawResponse = clientSecrets

        override fun calls(): CallServiceAsync.WithRawResponse = calls
    }
}
