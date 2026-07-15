// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.auditlogs.AuditLogListPage
import com.openai.models.admin.organization.auditlogs.AuditLogListParams
import java.util.function.Consumer

/** List user actions and configuration changes within this organization. */
interface AuditLogService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AuditLogService

    /** List user actions and configuration changes within this organization. */
    fun list(): AuditLogListPage = list(AuditLogListParams.none())

    /** @see list */
    fun list(
        params: AuditLogListParams = AuditLogListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AuditLogListPage

    /** @see list */
    fun list(params: AuditLogListParams = AuditLogListParams.none()): AuditLogListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): AuditLogListPage =
        list(AuditLogListParams.none(), requestOptions)

    /** A view of [AuditLogService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AuditLogService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/audit_logs`, but is otherwise the same
         * as [AuditLogService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<AuditLogListPage> = list(AuditLogListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: AuditLogListParams = AuditLogListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AuditLogListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: AuditLogListParams = AuditLogListParams.none()
        ): HttpResponseFor<AuditLogListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<AuditLogListPage> =
            list(AuditLogListParams.none(), requestOptions)
    }
}
