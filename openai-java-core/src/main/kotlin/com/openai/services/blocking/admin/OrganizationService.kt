// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin

import com.openai.core.ClientOptions
import com.openai.services.blocking.admin.organization.AdminApiKeyService
import com.openai.services.blocking.admin.organization.AuditLogService
import com.openai.services.blocking.admin.organization.CertificateService
import com.openai.services.blocking.admin.organization.GroupService
import com.openai.services.blocking.admin.organization.InviteService
import com.openai.services.blocking.admin.organization.ProjectService
import com.openai.services.blocking.admin.organization.RoleService
import com.openai.services.blocking.admin.organization.UsageService
import com.openai.services.blocking.admin.organization.UserService
import java.util.function.Consumer

interface OrganizationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationService

    /** List user actions and configuration changes within this organization. */
    fun auditLogs(): AuditLogService

    fun adminApiKeys(): AdminApiKeyService

    fun usage(): UsageService

    fun invites(): InviteService

    fun users(): UserService

    fun groups(): GroupService

    fun roles(): RoleService

    fun certificates(): CertificateService

    fun projects(): ProjectService

    /**
     * A view of [OrganizationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationService.WithRawResponse

        /** List user actions and configuration changes within this organization. */
        fun auditLogs(): AuditLogService.WithRawResponse

        fun adminApiKeys(): AdminApiKeyService.WithRawResponse

        fun usage(): UsageService.WithRawResponse

        fun invites(): InviteService.WithRawResponse

        fun users(): UserService.WithRawResponse

        fun groups(): GroupService.WithRawResponse

        fun roles(): RoleService.WithRawResponse

        fun certificates(): CertificateService.WithRawResponse

        fun projects(): ProjectService.WithRawResponse
    }
}
