// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.admin.OrganizationServiceAsync
import com.openai.services.async.admin.OrganizationServiceAsyncImpl
import java.util.function.Consumer

class AdminServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AdminServiceAsync {

    private val withRawResponse: AdminServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val organization: OrganizationServiceAsync by lazy {
        OrganizationServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): AdminServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AdminServiceAsync =
        AdminServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun organization(): OrganizationServiceAsync = organization

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AdminServiceAsync.WithRawResponse {

        private val organization: OrganizationServiceAsync.WithRawResponse by lazy {
            OrganizationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AdminServiceAsync.WithRawResponse =
            AdminServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun organization(): OrganizationServiceAsync.WithRawResponse = organization
    }
}
