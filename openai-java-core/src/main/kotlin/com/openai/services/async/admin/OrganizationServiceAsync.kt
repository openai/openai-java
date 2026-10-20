// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin

import com.openai.core.ClientOptions
import com.openai.services.async.admin.organization.AdminApiKeyServiceAsync
import com.openai.services.async.admin.organization.AuditLogServiceAsync
import com.openai.services.async.admin.organization.CertificateServiceAsync
import com.openai.services.async.admin.organization.DataRetentionServiceAsync
import com.openai.services.async.admin.organization.ExternalStorageServiceAsync
import com.openai.services.async.admin.organization.GroupServiceAsync
import com.openai.services.async.admin.organization.InviteServiceAsync
import com.openai.services.async.admin.organization.ProjectServiceAsync
import com.openai.services.async.admin.organization.RoleServiceAsync
import com.openai.services.async.admin.organization.SpendAlertServiceAsync
import com.openai.services.async.admin.organization.SpendLimitServiceAsync
import com.openai.services.async.admin.organization.UsageServiceAsync
import com.openai.services.async.admin.organization.UserServiceAsync
import java.util.function.Consumer

interface OrganizationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationServiceAsync

    /** List user actions and configuration changes within this organization. */
    fun auditLogs(): AuditLogServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun adminApiKeys(): AdminApiKeyServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun usage(): UsageServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun invites(): InviteServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun users(): UserServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun groups(): GroupServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun roles(): RoleServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun dataRetention(): DataRetentionServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun externalStorage(): ExternalStorageServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun spendLimit(): SpendLimitServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun spendAlerts(): SpendAlertServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun certificates(): CertificateServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun projects(): ProjectServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /**
     * A view of [OrganizationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationServiceAsync.WithRawResponse

        /** List user actions and configuration changes within this organization. */
        fun auditLogs(): AuditLogServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun adminApiKeys(): AdminApiKeyServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun usage(): UsageServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun invites(): InviteServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun users(): UserServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun groups(): GroupServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun roles(): RoleServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun dataRetention(): DataRetentionServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun externalStorage(): ExternalStorageServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun spendLimit(): SpendLimitServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun spendAlerts(): SpendAlertServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun certificates(): CertificateServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun projects(): ProjectServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
