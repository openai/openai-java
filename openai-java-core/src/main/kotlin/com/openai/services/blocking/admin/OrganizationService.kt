// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin

import com.openai.core.ClientOptions
import com.openai.services.blocking.admin.organization.AdminApiKeyService
import com.openai.services.blocking.admin.organization.AuditLogService
import com.openai.services.blocking.admin.organization.CertificateService
import com.openai.services.blocking.admin.organization.DataRetentionService
import com.openai.services.blocking.admin.organization.ExternalKeyService
import com.openai.services.blocking.admin.organization.ExternalStorageService
import com.openai.services.blocking.admin.organization.GroupService
import com.openai.services.blocking.admin.organization.InviteService
import com.openai.services.blocking.admin.organization.ProjectService
import com.openai.services.blocking.admin.organization.RoleService
import com.openai.services.blocking.admin.organization.SpendAlertService
import com.openai.services.blocking.admin.organization.SpendLimitService
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
    fun auditLogs(): AuditLogService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun adminApiKeys(): AdminApiKeyService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun usage(): UsageService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun invites(): InviteService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun users(): UserService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun groups(): GroupService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun roles(): RoleService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun dataRetention(): DataRetentionService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun externalKeys(): ExternalKeyService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun externalStorage(): ExternalStorageService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun spendLimit(): SpendLimitService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun spendAlerts(): SpendAlertService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun certificates(): CertificateService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun projects(): ProjectService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

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
        fun auditLogs(): AuditLogService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun adminApiKeys(): AdminApiKeyService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun usage(): UsageService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun invites(): InviteService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun users(): UserService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun groups(): GroupService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun roles(): RoleService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun dataRetention(): DataRetentionService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun externalKeys(): ExternalKeyService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun externalStorage(): ExternalStorageService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun spendLimit(): SpendLimitService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun spendAlerts(): SpendAlertService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun certificates(): CertificateService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun projects(): ProjectService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
