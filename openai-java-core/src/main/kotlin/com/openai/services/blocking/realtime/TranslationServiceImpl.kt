// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.realtime

import com.openai.core.ClientOptions
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

    override fun withRawResponse(): TranslationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranslationService =
        TranslationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun clientSecrets(): ClientSecretService = clientSecrets

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranslationService.WithRawResponse {

        private val clientSecrets: ClientSecretService.WithRawResponse by lazy {
            ClientSecretServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranslationService.WithRawResponse =
            TranslationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun clientSecrets(): ClientSecretService.WithRawResponse = clientSecrets
    }
}
