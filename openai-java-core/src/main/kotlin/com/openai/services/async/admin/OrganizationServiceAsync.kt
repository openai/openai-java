// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin

import com.openai.core.ClientOptions
import com.openai.services.async.admin.organization.AdminApiKeyServiceAsync
import com.openai.services.async.admin.organization.AuditLogServiceAsync
import com.openai.services.async.admin.organization.CertificateServiceAsync
import com.openai.services.async.admin.organization.GroupServiceAsync
import com.openai.services.async.admin.organization.InviteServiceAsync
import com.openai.services.async.admin.organization.ProjectServiceAsync
import com.openai.services.async.admin.organization.RoleServiceAsync
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
    fun auditLogs(): AuditLogServiceAsync

    fun adminApiKeys(): AdminApiKeyServiceAsync

    fun usage(): UsageServiceAsync

    fun invites(): InviteServiceAsync

    fun users(): UserServiceAsync

    fun groups(): GroupServiceAsync

    fun roles(): RoleServiceAsync

    fun certificates(): CertificateServiceAsync

    fun projects(): ProjectServiceAsync

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
        fun auditLogs(): AuditLogServiceAsync.WithRawResponse

        fun adminApiKeys(): AdminApiKeyServiceAsync.WithRawResponse

        fun usage(): UsageServiceAsync.WithRawResponse

        fun invites(): InviteServiceAsync.WithRawResponse

        fun users(): UserServiceAsync.WithRawResponse

        fun groups(): GroupServiceAsync.WithRawResponse

        fun roles(): RoleServiceAsync.WithRawResponse

        fun certificates(): CertificateServiceAsync.WithRawResponse

        fun projects(): ProjectServiceAsync.WithRawResponse
    }
}
