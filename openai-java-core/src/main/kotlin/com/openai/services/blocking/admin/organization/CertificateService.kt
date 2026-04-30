// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.certificates.Certificate
import com.openai.models.admin.organization.certificates.CertificateActivatePage
import com.openai.models.admin.organization.certificates.CertificateActivateParams
import com.openai.models.admin.organization.certificates.CertificateCreateParams
import com.openai.models.admin.organization.certificates.CertificateDeactivatePage
import com.openai.models.admin.organization.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.certificates.CertificateDeleteParams
import com.openai.models.admin.organization.certificates.CertificateDeleteResponse
import com.openai.models.admin.organization.certificates.CertificateListPage
import com.openai.models.admin.organization.certificates.CertificateListParams
import com.openai.models.admin.organization.certificates.CertificateRetrieveParams
import com.openai.models.admin.organization.certificates.CertificateUpdateParams
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

    /**
     * Upload a certificate to the organization. This does **not** automatically activate the
     * certificate.
     *
     * Organizations can upload up to 50 certificates.
     */
    fun create(params: CertificateCreateParams): Certificate = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CertificateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Certificate

    /**
     * Get a certificate that has been uploaded to the organization.
     *
     * You can get a certificate regardless of whether it is active or not.
     */
    fun retrieve(certificateId: String): Certificate =
        retrieve(certificateId, CertificateRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        certificateId: String,
        params: CertificateRetrieveParams = CertificateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Certificate =
        retrieve(params.toBuilder().certificateId(certificateId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        certificateId: String,
        params: CertificateRetrieveParams = CertificateRetrieveParams.none(),
    ): Certificate = retrieve(certificateId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: CertificateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Certificate

    /** @see retrieve */
    fun retrieve(params: CertificateRetrieveParams): Certificate =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(certificateId: String, requestOptions: RequestOptions): Certificate =
        retrieve(certificateId, CertificateRetrieveParams.none(), requestOptions)

    /** Modify a certificate. Note that only the name can be modified. */
    fun update(certificateId: String, params: CertificateUpdateParams): Certificate =
        update(certificateId, params, RequestOptions.none())

    /** @see update */
    fun update(
        certificateId: String,
        params: CertificateUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Certificate = update(params.toBuilder().certificateId(certificateId).build(), requestOptions)

    /** @see update */
    fun update(params: CertificateUpdateParams): Certificate = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CertificateUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Certificate

    /** List uploaded certificates for this organization. */
    fun list(): CertificateListPage = list(CertificateListParams.none())

    /** @see list */
    fun list(
        params: CertificateListParams = CertificateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateListPage

    /** @see list */
    fun list(params: CertificateListParams = CertificateListParams.none()): CertificateListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CertificateListPage =
        list(CertificateListParams.none(), requestOptions)

    /**
     * Delete a certificate from the organization.
     *
     * The certificate must be inactive for the organization and all projects.
     */
    fun delete(certificateId: String): CertificateDeleteResponse =
        delete(certificateId, CertificateDeleteParams.none())

    /** @see delete */
    fun delete(
        certificateId: String,
        params: CertificateDeleteParams = CertificateDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateDeleteResponse =
        delete(params.toBuilder().certificateId(certificateId).build(), requestOptions)

    /** @see delete */
    fun delete(
        certificateId: String,
        params: CertificateDeleteParams = CertificateDeleteParams.none(),
    ): CertificateDeleteResponse = delete(certificateId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CertificateDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateDeleteResponse

    /** @see delete */
    fun delete(params: CertificateDeleteParams): CertificateDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(certificateId: String, requestOptions: RequestOptions): CertificateDeleteResponse =
        delete(certificateId, CertificateDeleteParams.none(), requestOptions)

    /**
     * Activate certificates at the organization level.
     *
     * You can atomically and idempotently activate up to 10 certificates at a time.
     */
    fun activate(params: CertificateActivateParams): CertificateActivatePage =
        activate(params, RequestOptions.none())

    /** @see activate */
    fun activate(
        params: CertificateActivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CertificateActivatePage

    /**
     * Deactivate certificates at the organization level.
     *
     * You can atomically and idempotently deactivate up to 10 certificates at a time.
     */
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
         * Returns a raw HTTP response for `post /organization/certificates`, but is otherwise the
         * same as [CertificateService.create].
         */
        @MustBeClosed
        fun create(params: CertificateCreateParams): HttpResponseFor<Certificate> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CertificateCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Certificate>

        /**
         * Returns a raw HTTP response for `get /organization/certificates/{certificate_id}`, but is
         * otherwise the same as [CertificateService.retrieve].
         */
        @MustBeClosed
        fun retrieve(certificateId: String): HttpResponseFor<Certificate> =
            retrieve(certificateId, CertificateRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            certificateId: String,
            params: CertificateRetrieveParams = CertificateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Certificate> =
            retrieve(params.toBuilder().certificateId(certificateId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            certificateId: String,
            params: CertificateRetrieveParams = CertificateRetrieveParams.none(),
        ): HttpResponseFor<Certificate> = retrieve(certificateId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: CertificateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Certificate>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: CertificateRetrieveParams): HttpResponseFor<Certificate> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            certificateId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Certificate> =
            retrieve(certificateId, CertificateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/certificates/{certificate_id}`, but
         * is otherwise the same as [CertificateService.update].
         */
        @MustBeClosed
        fun update(
            certificateId: String,
            params: CertificateUpdateParams,
        ): HttpResponseFor<Certificate> = update(certificateId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            certificateId: String,
            params: CertificateUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Certificate> =
            update(params.toBuilder().certificateId(certificateId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: CertificateUpdateParams): HttpResponseFor<Certificate> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: CertificateUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Certificate>

        /**
         * Returns a raw HTTP response for `get /organization/certificates`, but is otherwise the
         * same as [CertificateService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<CertificateListPage> = list(CertificateListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CertificateListParams = CertificateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: CertificateListParams = CertificateListParams.none()
        ): HttpResponseFor<CertificateListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<CertificateListPage> =
            list(CertificateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/certificates/{certificate_id}`, but
         * is otherwise the same as [CertificateService.delete].
         */
        @MustBeClosed
        fun delete(certificateId: String): HttpResponseFor<CertificateDeleteResponse> =
            delete(certificateId, CertificateDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            certificateId: String,
            params: CertificateDeleteParams = CertificateDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateDeleteResponse> =
            delete(params.toBuilder().certificateId(certificateId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            certificateId: String,
            params: CertificateDeleteParams = CertificateDeleteParams.none(),
        ): HttpResponseFor<CertificateDeleteResponse> =
            delete(certificateId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: CertificateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CertificateDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: CertificateDeleteParams): HttpResponseFor<CertificateDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            certificateId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CertificateDeleteResponse> =
            delete(certificateId, CertificateDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/certificates/activate`, but is
         * otherwise the same as [CertificateService.activate].
         */
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
         * Returns a raw HTTP response for `post /organization/certificates/deactivate`, but is
         * otherwise the same as [CertificateService.deactivate].
         */
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
