// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.certificates.CertificateActivatePage
import com.openai.models.admin.organization.projects.certificates.CertificateActivateParams
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivatePage
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.projects.certificates.CertificateListPage
import com.openai.models.admin.organization.projects.certificates.CertificateListParams
import java.util.function.Consumer

interface CertificateService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CertificateService

    /** List certificates for this project. */
    fun list(projectId: String): CertificateListPage = list(projectId, CertificateListParams.none())

    /** @see list */
    fun list(
        projectId: String,
        params: CertificateListParams = CertificateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateListPage = list(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see list */
    fun list(
        projectId: String,
        params: CertificateListParams = CertificateListParams.none(),
    ): CertificateListPage = list(projectId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: CertificateListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateListPage

    /** @see list */
    fun list(params: CertificateListParams): CertificateListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(projectId: String, requestOptions: RequestOptions): CertificateListPage =
        list(projectId, CertificateListParams.none(), requestOptions)

    /**
     * Activate certificates at the project level.
     *
     * You can atomically and idempotently activate up to 10 certificates at a time.
     */
    fun activate(projectId: String, params: CertificateActivateParams): CertificateActivatePage =
        activate(projectId, params, RequestOptions.none())

    /** @see activate */
    fun activate(
        projectId: String,
        params: CertificateActivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateActivatePage =
        activate(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see activate */
    fun activate(params: CertificateActivateParams): CertificateActivatePage =
        activate(params, RequestOptions.none())

    /** @see activate */
    fun activate(
        params: CertificateActivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateActivatePage

    /**
     * Deactivate certificates at the project level. You can atomically and idempotently deactivate
     * up to 10 certificates at a time.
     */
    fun deactivate(
        projectId: String,
        params: CertificateDeactivateParams,
    ): CertificateDeactivatePage = deactivate(projectId, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        projectId: String,
        params: CertificateDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateDeactivatePage =
        deactivate(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(params: CertificateDeactivateParams): CertificateDeactivatePage =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: CertificateDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateDeactivatePage

    /**
     * A view of [CertificateService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CertificateService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/certificates`,
         * but is otherwise the same as [CertificateService.list].
         */
        @MustBeClosed
        fun list(projectId: String): HttpResponseFor<CertificateListPage> =
            list(projectId, CertificateListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: CertificateListParams = CertificateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateListPage> =
            list(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            params: CertificateListParams = CertificateListParams.none(),
        ): HttpResponseFor<CertificateListPage> = list(projectId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CertificateListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: CertificateListParams): HttpResponseFor<CertificateListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CertificateListPage> =
            list(projectId, CertificateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/certificates/activate`, but is otherwise the same as
         * [CertificateService.activate].
         */
        @MustBeClosed
        fun activate(
            projectId: String,
            params: CertificateActivateParams,
        ): HttpResponseFor<CertificateActivatePage> =
            activate(projectId, params, RequestOptions.none())

        /** @see activate */
        @MustBeClosed
        fun activate(
            projectId: String,
            params: CertificateActivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateActivatePage> =
            activate(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see activate */
        @MustBeClosed
        fun activate(params: CertificateActivateParams): HttpResponseFor<CertificateActivatePage> =
            activate(params, RequestOptions.none())

        /** @see activate */
        @MustBeClosed
        fun activate(
            params: CertificateActivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateActivatePage>

        /**
         * Returns a raw HTTP response for `post
         * /organization/projects/{project_id}/certificates/deactivate`, but is otherwise the same
         * as [CertificateService.deactivate].
         */
        @MustBeClosed
        fun deactivate(
            projectId: String,
            params: CertificateDeactivateParams,
        ): HttpResponseFor<CertificateDeactivatePage> =
            deactivate(projectId, params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            projectId: String,
            params: CertificateDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateDeactivatePage> =
            deactivate(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: CertificateDeactivateParams
        ): HttpResponseFor<CertificateDeactivatePage> = deactivate(params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: CertificateDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateDeactivatePage>
    }
}
