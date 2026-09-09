// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.safety.AlertServiceAsync
import com.openai.services.async.safety.AlertServiceAsyncImpl
import java.util.function.Consumer

class SafetyServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SafetyServiceAsync {

    private val withRawResponse: SafetyServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val alerts: AlertServiceAsync by lazy { AlertServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): SafetyServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SafetyServiceAsync =
        SafetyServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun alerts(): AlertServiceAsync = alerts

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SafetyServiceAsync.WithRawResponse {

        private val alerts: AlertServiceAsync.WithRawResponse by lazy {
            AlertServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SafetyServiceAsync.WithRawResponse =
            SafetyServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun alerts(): AlertServiceAsync.WithRawResponse = alerts
    }
}
