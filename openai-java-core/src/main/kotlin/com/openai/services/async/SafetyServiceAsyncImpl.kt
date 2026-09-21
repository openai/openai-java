// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.safety.AlertServiceAsync
import com.openai.services.async.safety.AlertServiceAsyncImpl
import com.openai.services.async.safety.CaseServiceAsync
import com.openai.services.async.safety.CaseServiceAsyncImpl
import java.util.function.Consumer

class SafetyServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SafetyServiceAsync {

    private val withRawResponse: SafetyServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val alerts: AlertServiceAsync by lazy { AlertServiceAsyncImpl(clientOptions) }

    private val cases: CaseServiceAsync by lazy { CaseServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): SafetyServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SafetyServiceAsync =
        SafetyServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun alerts(): AlertServiceAsync = alerts

    override fun cases(): CaseServiceAsync = cases

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SafetyServiceAsync.WithRawResponse {

        private val alerts: AlertServiceAsync.WithRawResponse by lazy {
            AlertServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val cases: CaseServiceAsync.WithRawResponse by lazy {
            CaseServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SafetyServiceAsync.WithRawResponse =
            SafetyServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun alerts(): AlertServiceAsync.WithRawResponse = alerts

        override fun cases(): CaseServiceAsync.WithRawResponse = cases
    }
}
