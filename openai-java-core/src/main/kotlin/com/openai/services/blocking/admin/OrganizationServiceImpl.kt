// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin

import com.openai.core.ClientOptions
import com.openai.services.blocking.admin.organization.AdminApiKeyService
import com.openai.services.blocking.admin.organization.AdminApiKeyServiceImpl
import com.openai.services.blocking.admin.organization.AuditLogService
import com.openai.services.blocking.admin.organization.AuditLogServiceImpl
import com.openai.services.blocking.admin.organization.CertificateService
import com.openai.services.blocking.admin.organization.CertificateServiceImpl
import com.openai.services.blocking.admin.organization.GroupService
import com.openai.services.blocking.admin.organization.GroupServiceImpl
import com.openai.services.blocking.admin.organization.InviteService
import com.openai.services.blocking.admin.organization.InviteServiceImpl
import com.openai.services.blocking.admin.organization.ProjectService
import com.openai.services.blocking.admin.organization.ProjectServiceImpl
import com.openai.services.blocking.admin.organization.RoleService
import com.openai.services.blocking.admin.organization.RoleServiceImpl
import com.openai.services.blocking.admin.organization.UsageService
import com.openai.services.blocking.admin.organization.UsageServiceImpl
import com.openai.services.blocking.admin.organization.UserService
import com.openai.services.blocking.admin.organization.UserServiceImpl
import java.util.function.Consumer

class OrganizationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrganizationService {

    private val withRawResponse: OrganizationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val auditLogs: AuditLogService by lazy { AuditLogServiceImpl(clientOptions) }

    private val adminApiKeys: AdminApiKeyService by lazy { AdminApiKeyServiceImpl(clientOptions) }

    private val usage: UsageService by lazy { UsageServiceImpl(clientOptions) }

    private val invites: InviteService by lazy { InviteServiceImpl(clientOptions) }

    private val users: UserService by lazy { UserServiceImpl(clientOptions) }

    private val groups: GroupService by lazy { GroupServiceImpl(clientOptions) }

    private val roles: RoleService by lazy { RoleServiceImpl(clientOptions) }

    private val certificates: CertificateService by lazy { CertificateServiceImpl(clientOptions) }

    private val projects: ProjectService by lazy { ProjectServiceImpl(clientOptions) }

    override fun withRawResponse(): OrganizationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationService =
        OrganizationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** List user actions and configuration changes within this organization. */
    override fun auditLogs(): AuditLogService = auditLogs

    override fun adminApiKeys(): AdminApiKeyService = adminApiKeys

    override fun usage(): UsageService = usage

    override fun invites(): InviteService = invites

    override fun users(): UserService = users

    override fun groups(): GroupService = groups

    override fun roles(): RoleService = roles

    override fun certificates(): CertificateService = certificates

    override fun projects(): ProjectService = projects

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrganizationService.WithRawResponse {

        private val auditLogs: AuditLogService.WithRawResponse by lazy {
            AuditLogServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val adminApiKeys: AdminApiKeyService.WithRawResponse by lazy {
            AdminApiKeyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val usage: UsageService.WithRawResponse by lazy {
            UsageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val invites: InviteService.WithRawResponse by lazy {
            InviteServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val groups: GroupService.WithRawResponse by lazy {
            GroupServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val roles: RoleService.WithRawResponse by lazy {
            RoleServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val certificates: CertificateService.WithRawResponse by lazy {
            CertificateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val projects: ProjectService.WithRawResponse by lazy {
            ProjectServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationService.WithRawResponse =
            OrganizationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** List user actions and configuration changes within this organization. */
        override fun auditLogs(): AuditLogService.WithRawResponse = auditLogs

        override fun adminApiKeys(): AdminApiKeyService.WithRawResponse = adminApiKeys

        override fun usage(): UsageService.WithRawResponse = usage

        override fun invites(): InviteService.WithRawResponse = invites

        override fun users(): UserService.WithRawResponse = users

        override fun groups(): GroupService.WithRawResponse = groups

        override fun roles(): RoleService.WithRawResponse = roles

        override fun certificates(): CertificateService.WithRawResponse = certificates

        override fun projects(): ProjectService.WithRawResponse = projects
    }
}
