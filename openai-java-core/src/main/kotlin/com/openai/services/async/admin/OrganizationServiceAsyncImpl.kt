// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin

import com.openai.core.ClientOptions
import com.openai.services.async.admin.organization.AdminApiKeyServiceAsync
import com.openai.services.async.admin.organization.AdminApiKeyServiceAsyncImpl
import com.openai.services.async.admin.organization.AuditLogServiceAsync
import com.openai.services.async.admin.organization.AuditLogServiceAsyncImpl
import com.openai.services.async.admin.organization.CertificateServiceAsync
import com.openai.services.async.admin.organization.CertificateServiceAsyncImpl
import com.openai.services.async.admin.organization.GroupServiceAsync
import com.openai.services.async.admin.organization.GroupServiceAsyncImpl
import com.openai.services.async.admin.organization.InviteServiceAsync
import com.openai.services.async.admin.organization.InviteServiceAsyncImpl
import com.openai.services.async.admin.organization.ProjectServiceAsync
import com.openai.services.async.admin.organization.ProjectServiceAsyncImpl
import com.openai.services.async.admin.organization.RoleServiceAsync
import com.openai.services.async.admin.organization.RoleServiceAsyncImpl
import com.openai.services.async.admin.organization.UsageServiceAsync
import com.openai.services.async.admin.organization.UsageServiceAsyncImpl
import com.openai.services.async.admin.organization.UserServiceAsync
import com.openai.services.async.admin.organization.UserServiceAsyncImpl
import java.util.function.Consumer

class OrganizationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OrganizationServiceAsync {

    private val withRawResponse: OrganizationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val auditLogs: AuditLogServiceAsync by lazy { AuditLogServiceAsyncImpl(clientOptions) }

    private val adminApiKeys: AdminApiKeyServiceAsync by lazy {
        AdminApiKeyServiceAsyncImpl(clientOptions)
    }

    private val usage: UsageServiceAsync by lazy { UsageServiceAsyncImpl(clientOptions) }

    private val invites: InviteServiceAsync by lazy { InviteServiceAsyncImpl(clientOptions) }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptions) }

    private val groups: GroupServiceAsync by lazy { GroupServiceAsyncImpl(clientOptions) }

    private val roles: RoleServiceAsync by lazy { RoleServiceAsyncImpl(clientOptions) }

    private val certificates: CertificateServiceAsync by lazy {
        CertificateServiceAsyncImpl(clientOptions)
    }

    private val projects: ProjectServiceAsync by lazy { ProjectServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): OrganizationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationServiceAsync =
        OrganizationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** List user actions and configuration changes within this organization. */
    override fun auditLogs(): AuditLogServiceAsync = auditLogs

    override fun adminApiKeys(): AdminApiKeyServiceAsync = adminApiKeys

    override fun usage(): UsageServiceAsync = usage

    override fun invites(): InviteServiceAsync = invites

    override fun users(): UserServiceAsync = users

    override fun groups(): GroupServiceAsync = groups

    override fun roles(): RoleServiceAsync = roles

    override fun certificates(): CertificateServiceAsync = certificates

    override fun projects(): ProjectServiceAsync = projects

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrganizationServiceAsync.WithRawResponse {

        private val auditLogs: AuditLogServiceAsync.WithRawResponse by lazy {
            AuditLogServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val adminApiKeys: AdminApiKeyServiceAsync.WithRawResponse by lazy {
            AdminApiKeyServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val usage: UsageServiceAsync.WithRawResponse by lazy {
            UsageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val invites: InviteServiceAsync.WithRawResponse by lazy {
            InviteServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val groups: GroupServiceAsync.WithRawResponse by lazy {
            GroupServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val roles: RoleServiceAsync.WithRawResponse by lazy {
            RoleServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val certificates: CertificateServiceAsync.WithRawResponse by lazy {
            CertificateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val projects: ProjectServiceAsync.WithRawResponse by lazy {
            ProjectServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationServiceAsync.WithRawResponse =
            OrganizationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** List user actions and configuration changes within this organization. */
        override fun auditLogs(): AuditLogServiceAsync.WithRawResponse = auditLogs

        override fun adminApiKeys(): AdminApiKeyServiceAsync.WithRawResponse = adminApiKeys

        override fun usage(): UsageServiceAsync.WithRawResponse = usage

        override fun invites(): InviteServiceAsync.WithRawResponse = invites

        override fun users(): UserServiceAsync.WithRawResponse = users

        override fun groups(): GroupServiceAsync.WithRawResponse = groups

        override fun roles(): RoleServiceAsync.WithRawResponse = roles

        override fun certificates(): CertificateServiceAsync.WithRawResponse = certificates

        override fun projects(): ProjectServiceAsync.WithRawResponse = projects
    }
}
