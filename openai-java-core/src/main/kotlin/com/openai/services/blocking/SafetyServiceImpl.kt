// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.safety.AlertService
import com.openai.services.blocking.safety.AlertServiceImpl
import java.util.function.Consumer

class SafetyServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SafetyService {

    private val withRawResponse: SafetyService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val alerts: AlertService by lazy { AlertServiceImpl(clientOptions) }

    override fun withRawResponse(): SafetyService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SafetyService =
        SafetyServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun alerts(): AlertService = alerts

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SafetyService.WithRawResponse {

        private val alerts: AlertService.WithRawResponse by lazy {
            AlertServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SafetyService.WithRawResponse =
            SafetyServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun alerts(): AlertService.WithRawResponse = alerts
    }
}
