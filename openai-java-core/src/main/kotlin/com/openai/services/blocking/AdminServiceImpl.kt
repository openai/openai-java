// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.admin.OrganizationService
import com.openai.services.blocking.admin.OrganizationServiceImpl
import java.util.function.Consumer

class AdminServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AdminService {

    private val withRawResponse: AdminService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val organization: OrganizationService by lazy { OrganizationServiceImpl(clientOptions) }

    override fun withRawResponse(): AdminService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AdminService =
        AdminServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun organization(): OrganizationService = organization

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AdminService.WithRawResponse {

        private val organization: OrganizationService.WithRawResponse by lazy {
            OrganizationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AdminService.WithRawResponse =
            AdminServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun organization(): OrganizationService.WithRawResponse = organization
    }
}
