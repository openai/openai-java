// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.certificates.Certificate
import com.openai.models.admin.organization.certificates.CertificateActivatePageAsync
import com.openai.models.admin.organization.certificates.CertificateActivateParams
import com.openai.models.admin.organization.certificates.CertificateCreateParams
import com.openai.models.admin.organization.certificates.CertificateDeactivatePageAsync
import com.openai.models.admin.organization.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.certificates.CertificateDeleteParams
import com.openai.models.admin.organization.certificates.CertificateDeleteResponse
import com.openai.models.admin.organization.certificates.CertificateListPageAsync
import com.openai.models.admin.organization.certificates.CertificateListParams
import com.openai.models.admin.organization.certificates.CertificateRetrieveParams
import com.openai.models.admin.organization.certificates.CertificateUpdateParams
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

    /**
     * Upload a certificate to the organization. This does **not** automatically activate the
     * certificate.
     *
     * Organizations can upload up to 50 certificates.
     */
    fun create(params: CertificateCreateParams): CompletableFuture<Certificate> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CertificateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Certificate>

    /**
     * Get a certificate that has been uploaded to the organization.
     *
     * You can get a certificate regardless of whether it is active or not.
     */
    fun retrieve(certificateId: String): CompletableFuture<Certificate> =
        retrieve(certificateId, CertificateRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        certificateId: String,
        params: CertificateRetrieveParams = CertificateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Certificate> =
        retrieve(params.toBuilder().certificateId(certificateId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        certificateId: String,
        params: CertificateRetrieveParams = CertificateRetrieveParams.none(),
    ): CompletableFuture<Certificate> = retrieve(certificateId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: CertificateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Certificate>

    /** @see retrieve */
    fun retrieve(params: CertificateRetrieveParams): CompletableFuture<Certificate> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        certificateId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Certificate> =
        retrieve(certificateId, CertificateRetrieveParams.none(), requestOptions)

    /** Modify a certificate. Note that only the name can be modified. */
    fun update(certificateId: String): CompletableFuture<Certificate> =
        update(certificateId, CertificateUpdateParams.none())

    /** @see update */
    fun update(
        certificateId: String,
        params: CertificateUpdateParams = CertificateUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Certificate> =
        update(params.toBuilder().certificateId(certificateId).build(), requestOptions)

    /** @see update */
    fun update(
        certificateId: String,
        params: CertificateUpdateParams = CertificateUpdateParams.none(),
    ): CompletableFuture<Certificate> = update(certificateId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CertificateUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Certificate>

    /** @see update */
    fun update(params: CertificateUpdateParams): CompletableFuture<Certificate> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        certificateId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<Certificate> =
        update(certificateId, CertificateUpdateParams.none(), requestOptions)

    /** List uploaded certificates for this organization. */
    fun list(): CompletableFuture<CertificateListPageAsync> = list(CertificateListParams.none())

    /** @see list */
    fun list(
        params: CertificateListParams = CertificateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateListPageAsync>

    /** @see list */
    fun list(
        params: CertificateListParams = CertificateListParams.none()
    ): CompletableFuture<CertificateListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<CertificateListPageAsync> =
        list(CertificateListParams.none(), requestOptions)

    /**
     * Delete a certificate from the organization.
     *
     * The certificate must be inactive for the organization and all projects.
     */
    fun delete(certificateId: String): CompletableFuture<CertificateDeleteResponse> =
        delete(certificateId, CertificateDeleteParams.none())

    /** @see delete */
    fun delete(
        certificateId: String,
        params: CertificateDeleteParams = CertificateDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateDeleteResponse> =
        delete(params.toBuilder().certificateId(certificateId).build(), requestOptions)

    /** @see delete */
    fun delete(
        certificateId: String,
        params: CertificateDeleteParams = CertificateDeleteParams.none(),
    ): CompletableFuture<CertificateDeleteResponse> =
        delete(certificateId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CertificateDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateDeleteResponse>

    /** @see delete */
    fun delete(params: CertificateDeleteParams): CompletableFuture<CertificateDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        certificateId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CertificateDeleteResponse> =
        delete(certificateId, CertificateDeleteParams.none(), requestOptions)

    /**
     * Activate certificates at the organization level.
     *
     * You can atomically and idempotently activate up to 10 certificates at a time.
     */
    fun activate(
        params: CertificateActivateParams
    ): CompletableFuture<CertificateActivatePageAsync> = activate(params, RequestOptions.none())

    /** @see activate */
    fun activate(
        params: CertificateActivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CertificateActivatePageAsync>

    /**
     * Deactivate certificates at the organization level.
     *
     * You can atomically and idempotently deactivate up to 10 certificates at a time.
     */
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
         * Returns a raw HTTP response for `post /organization/certificates`, but is otherwise the
         * same as [CertificateServiceAsync.create].
         */
        fun create(
            params: CertificateCreateParams
        ): CompletableFuture<HttpResponseFor<Certificate>> = create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CertificateCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Certificate>>

        /**
         * Returns a raw HTTP response for `get /organization/certificates/{certificate_id}`, but is
         * otherwise the same as [CertificateServiceAsync.retrieve].
         */
        fun retrieve(certificateId: String): CompletableFuture<HttpResponseFor<Certificate>> =
            retrieve(certificateId, CertificateRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            certificateId: String,
            params: CertificateRetrieveParams = CertificateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Certificate>> =
            retrieve(params.toBuilder().certificateId(certificateId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            certificateId: String,
            params: CertificateRetrieveParams = CertificateRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Certificate>> =
            retrieve(certificateId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: CertificateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Certificate>>

        /** @see retrieve */
        fun retrieve(
            params: CertificateRetrieveParams
        ): CompletableFuture<HttpResponseFor<Certificate>> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            certificateId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Certificate>> =
            retrieve(certificateId, CertificateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/certificates/{certificate_id}`, but
         * is otherwise the same as [CertificateServiceAsync.update].
         */
        fun update(certificateId: String): CompletableFuture<HttpResponseFor<Certificate>> =
            update(certificateId, CertificateUpdateParams.none())

        /** @see update */
        fun update(
            certificateId: String,
            params: CertificateUpdateParams = CertificateUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Certificate>> =
            update(params.toBuilder().certificateId(certificateId).build(), requestOptions)

        /** @see update */
        fun update(
            certificateId: String,
            params: CertificateUpdateParams = CertificateUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Certificate>> =
            update(certificateId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: CertificateUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Certificate>>

        /** @see update */
        fun update(
            params: CertificateUpdateParams
        ): CompletableFuture<HttpResponseFor<Certificate>> = update(params, RequestOptions.none())

        /** @see update */
        fun update(
            certificateId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Certificate>> =
            update(certificateId, CertificateUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/certificates`, but is otherwise the
         * same as [CertificateServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> =
            list(CertificateListParams.none())

        /** @see list */
        fun list(
            params: CertificateListParams = CertificateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>>

        /** @see list */
        fun list(
            params: CertificateListParams = CertificateListParams.none()
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> =
            list(CertificateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/certificates/{certificate_id}`, but
         * is otherwise the same as [CertificateServiceAsync.delete].
         */
        fun delete(
            certificateId: String
        ): CompletableFuture<HttpResponseFor<CertificateDeleteResponse>> =
            delete(certificateId, CertificateDeleteParams.none())

        /** @see delete */
        fun delete(
            certificateId: String,
            params: CertificateDeleteParams = CertificateDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateDeleteResponse>> =
            delete(params.toBuilder().certificateId(certificateId).build(), requestOptions)

        /** @see delete */
        fun delete(
            certificateId: String,
            params: CertificateDeleteParams = CertificateDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<CertificateDeleteResponse>> =
            delete(certificateId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: CertificateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CertificateDeleteResponse>>

        /** @see delete */
        fun delete(
            params: CertificateDeleteParams
        ): CompletableFuture<HttpResponseFor<CertificateDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            certificateId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CertificateDeleteResponse>> =
            delete(certificateId, CertificateDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/certificates/activate`, but is
         * otherwise the same as [CertificateServiceAsync.activate].
         */
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
         * Returns a raw HTTP response for `post /organization/certificates/deactivate`, but is
         * otherwise the same as [CertificateServiceAsync.deactivate].
         */
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
