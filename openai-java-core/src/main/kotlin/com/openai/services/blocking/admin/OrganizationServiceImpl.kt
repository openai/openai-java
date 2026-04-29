// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin

import com.openai.core.ClientOptions
import com.openai.services.blocking.admin.organization.AuditLogService
import com.openai.services.blocking.admin.organization.AuditLogServiceImpl
import java.util.function.Consumer

class OrganizationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrganizationService {

    private val withRawResponse: OrganizationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val auditLogs: AuditLogService by lazy { AuditLogServiceImpl(clientOptions) }

    override fun withRawResponse(): OrganizationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationService =
        OrganizationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** List user actions and configuration changes within this organization. */
    override fun auditLogs(): AuditLogService = auditLogs

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrganizationService.WithRawResponse {

        private val auditLogs: AuditLogService.WithRawResponse by lazy {
            AuditLogServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationService.WithRawResponse =
            OrganizationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** List user actions and configuration changes within this organization. */
        override fun auditLogs(): AuditLogService.WithRawResponse = auditLogs
    }
}
