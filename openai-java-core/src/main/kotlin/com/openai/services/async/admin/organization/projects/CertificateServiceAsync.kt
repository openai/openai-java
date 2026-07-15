// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.certificates.CertificateActivatePageAsync
import com.openai.models.admin.organization.projects.certificates.CertificateActivateParams
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivatePageAsync
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.projects.certificates.CertificateListPageAsync
import com.openai.models.admin.organization.projects.certificates.CertificateListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CertificateServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CertificateServiceAsync

    /** List certificates for this project. */
    fun list(projectId: String): CompletableFuture<CertificateListPageAsync> =
        list(projectId, CertificateListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: CertificateListParams = CertificateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateListPageAsync> =
        list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: CertificateListParams = CertificateListParams.none(),
    ): CompletableFuture<CertificateListPageAsync> = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: CertificateListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateListPageAsync>

    /** @see list */
    fun list(params: CertificateListParams): CompletableFuture<CertificateListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CertificateListPageAsync> =
        list(projectId, CertificateListParams.none(), requestOptions)

    /**
     * Activate certificates at the project level.
     *
     * You can atomically and idempotently activate up to 10 certificates at a time.
     */
    fun activate(
        projectId: String,
        params: CertificateActivateParams,
    ): CompletableFuture<CertificateActivatePageAsync> =
        activate(projectId, params, RequestOptions.none())

    /** @see activate */
    fun activate(
        projectId: String,
        params: CertificateActivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateActivatePageAsync> =
        activate(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see activate */
    fun activate(
        params: CertificateActivateParams
    ): CompletableFuture<CertificateActivatePageAsync> = activate(params, RequestOptions.none())

    /** @see activate */
    fun activate(
        params: CertificateActivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateActivatePageAsync>

    /**
     * Deactivate certificates at the project level. You can atomically and idempotently deactivate
     * up to 10 certificates at a time.
     */
    fun deactivate(
        projectId: String,
        params: CertificateDeactivateParams,
    ): CompletableFuture<CertificateDeactivatePageAsync> =
        deactivate(projectId, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        projectId: String,
        params: CertificateDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateDeactivatePageAsync> =
        deactivate(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        params: CertificateDeactivateParams
    ): CompletableFuture<CertificateDeactivatePageAsync> = deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: CertificateDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateDeactivatePageAsync>

    /**
     * A view of [CertificateServiceAsync] that provides access to raw HTTP responses for each
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
        ): CertificateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/certificates`,
         * but is otherwise the same as [CertificateServiceAsync.list].
         */
        fun list(projectId: String): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> =
            list(projectId, CertificateListParams.none())

        /** @see list */
        fun list(
            projectId: String,
            params: CertificateListParams = CertificateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        fun list(
            projectId: String,
            params: CertificateListParams = CertificateListParams.none(),
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> =
            list(projectId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: CertificateListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>>

        /** @see list */
        fun list(
            params: CertificateListParams
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> =
            list(projectId, CertificateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/certificates/activate`, but is otherwise the same as
         * [CertificateServiceAsync.activate].
         */
        fun activate(
            projectId: String,
            params: CertificateActivateParams,
        ): CompletableFuture<HttpResponseFor<CertificateActivatePageAsync>> =
            activate(projectId, params, RequestOptions.none())

        /** @see activate */
        fun activate(
            projectId: String,
            params: CertificateActivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateActivatePageAsync>> =
            activate(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see activate */
        fun activate(
            params: CertificateActivateParams
        ): CompletableFuture<HttpResponseFor<CertificateActivatePageAsync>> =
            activate(params, RequestOptions.none())

        /** @see activate */
        fun activate(
            params: CertificateActivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateActivatePageAsync>>

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/certificates/deactivate`, but is otherwise the same
         * as [CertificateServiceAsync.deactivate].
         */
        fun deactivate(
            projectId: String,
            params: CertificateDeactivateParams,
        ): CompletableFuture<HttpResponseFor<CertificateDeactivatePageAsync>> =
            deactivate(projectId, params, RequestOptions.none())

        /** @see deactivate */
        fun deactivate(
            projectId: String,
            params: CertificateDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateDeactivatePageAsync>> =
            deactivate(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see deactivate */
        fun deactivate(
            params: CertificateDeactivateParams
        ): CompletableFuture<HttpResponseFor<CertificateDeactivatePageAsync>> =
            deactivate(params, RequestOptions.none())

        /** @see deactivate */
        fun deactivate(
            params: CertificateDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateDeactivatePageAsync>>
    }
}
