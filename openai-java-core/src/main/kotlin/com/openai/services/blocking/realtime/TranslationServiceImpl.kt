// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime

import com.openai.core.ClientOptions
import com.openai.services.blocking.realtime.translations.CallService
import com.openai.services.blocking.realtime.translations.CallServiceImpl
import com.openai.services.blocking.realtime.translations.ClientSecretService
import com.openai.services.blocking.realtime.translations.ClientSecretServiceImpl
import java.util.function.Consumer

class TranslationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TranslationService {

    private val withRawResponse: TranslationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val clientSecrets: ClientSecretService by lazy {
        ClientSecretServiceImpl(clientOptions)
    }

    private val calls: CallService by lazy { CallServiceImpl(clientOptions) }

    override fun withRawResponse(): TranslationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranslationService =
        TranslationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun clientSecrets(): ClientSecretService = clientSecrets

    override fun calls(): CallService = calls

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranslationService.WithRawResponse {

        private val clientSecrets: ClientSecretService.WithRawResponse by lazy {
            ClientSecretServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val calls: CallService.WithRawResponse by lazy {
            CallServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranslationService.WithRawResponse =
            TranslationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun clientSecrets(): ClientSecretService.WithRawResponse = clientSecrets

        override fun calls(): CallService.WithRawResponse = calls
    }
}
