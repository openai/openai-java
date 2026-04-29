// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin

import com.openai.core.ClientOptions
import com.openai.services.async.admin.organization.AuditLogServiceAsync
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
    }
}
