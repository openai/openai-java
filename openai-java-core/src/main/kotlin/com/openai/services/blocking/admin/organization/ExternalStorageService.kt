// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.externalstorage.ExternalStorageConfiguration
import com.openai.models.admin.organization.externalstorage.ExternalStorageCreateParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageDeleteParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageDeleted
import com.openai.models.admin.organization.externalstorage.ExternalStorageListPage
import com.openai.models.admin.organization.externalstorage.ExternalStorageListParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageRetrieveParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageValidateParams
import java.util.function.Consumer

interface ExternalStorageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExternalStorageService

    /** Register one customer-managed external storage configuration. */
    fun create(params: ExternalStorageCreateParams): ExternalStorageConfiguration =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ExternalStorageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalStorageConfiguration

    /** Get one customer-managed external storage configuration. */
    fun retrieve(externalStorageId: String): ExternalStorageConfiguration =
        retrieve(externalStorageId, ExternalStorageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        externalStorageId: String,
        params: ExternalStorageRetrieveParams = ExternalStorageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalStorageConfiguration =
        retrieve(params.toBuilder().externalStorageId(externalStorageId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        externalStorageId: String,
        params: ExternalStorageRetrieveParams = ExternalStorageRetrieveParams.none(),
    ): ExternalStorageConfiguration = retrieve(externalStorageId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ExternalStorageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalStorageConfiguration

    /** @see retrieve */
    fun retrieve(params: ExternalStorageRetrieveParams): ExternalStorageConfiguration =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        externalStorageId: String,
        requestOptions: RequestOptions,
    ): ExternalStorageConfiguration =
        retrieve(externalStorageId, ExternalStorageRetrieveParams.none(), requestOptions)

    /** List the organization's customer-managed external storage configurations. */
    fun list(): ExternalStorageListPage = list(ExternalStorageListParams.none())

    /** @see list */
    fun list(
        params: ExternalStorageListParams = ExternalStorageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalStorageListPage

    /** @see list */
    fun list(
        params: ExternalStorageListParams = ExternalStorageListParams.none()
    ): ExternalStorageListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ExternalStorageListPage =
        list(ExternalStorageListParams.none(), requestOptions)

    /** Soft-delete one customer-managed external storage configuration. */
    fun delete(externalStorageId: String): ExternalStorageDeleted =
        delete(externalStorageId, ExternalStorageDeleteParams.none())

    /** @see delete */
    fun delete(
        externalStorageId: String,
        params: ExternalStorageDeleteParams = ExternalStorageDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalStorageDeleted =
        delete(params.toBuilder().externalStorageId(externalStorageId).build(), requestOptions)

    /** @see delete */
    fun delete(
        externalStorageId: String,
        params: ExternalStorageDeleteParams = ExternalStorageDeleteParams.none(),
    ): ExternalStorageDeleted = delete(externalStorageId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ExternalStorageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalStorageDeleted

    /** @see delete */
    fun delete(params: ExternalStorageDeleteParams): ExternalStorageDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(externalStorageId: String, requestOptions: RequestOptions): ExternalStorageDeleted =
        delete(externalStorageId, ExternalStorageDeleteParams.none(), requestOptions)

    /** Validate one customer-managed external storage configuration. */
    fun validate(externalStorageId: String): ExternalStorageConfiguration =
        validate(externalStorageId, ExternalStorageValidateParams.none())

    /** @see validate */
    fun validate(
        externalStorageId: String,
        params: ExternalStorageValidateParams = ExternalStorageValidateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalStorageConfiguration =
        validate(params.toBuilder().externalStorageId(externalStorageId).build(), requestOptions)

    /** @see validate */
    fun validate(
        externalStorageId: String,
        params: ExternalStorageValidateParams = ExternalStorageValidateParams.none(),
    ): ExternalStorageConfiguration = validate(externalStorageId, params, RequestOptions.none())

    /** @see validate */
    fun validate(
        params: ExternalStorageValidateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalStorageConfiguration

    /** @see validate */
    fun validate(params: ExternalStorageValidateParams): ExternalStorageConfiguration =
        validate(params, RequestOptions.none())

    /** @see validate */
    fun validate(
        externalStorageId: String,
        requestOptions: RequestOptions,
    ): ExternalStorageConfiguration =
        validate(externalStorageId, ExternalStorageValidateParams.none(), requestOptions)

    /**
     * A view of [ExternalStorageService] that provides access to raw HTTP responses for each
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
        ): ExternalStorageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/external_storage`, but is otherwise
         * the same as [ExternalStorageService.create].
         */
        @MustBeClosed
        fun create(
            params: ExternalStorageCreateParams
        ): HttpResponseFor<ExternalStorageConfiguration> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ExternalStorageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalStorageConfiguration>

        /**
         * Returns a raw HTTP response for `get
         * /organization/external_storage/{external_storage_id}`, but is otherwise the same as
         * [ExternalStorageService.retrieve].
         */
        @MustBeClosed
        fun retrieve(externalStorageId: String): HttpResponseFor<ExternalStorageConfiguration> =
            retrieve(externalStorageId, ExternalStorageRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            externalStorageId: String,
            params: ExternalStorageRetrieveParams = ExternalStorageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalStorageConfiguration> =
            retrieve(
                params.toBuilder().externalStorageId(externalStorageId).build(),
                requestOptions,
            )

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            externalStorageId: String,
            params: ExternalStorageRetrieveParams = ExternalStorageRetrieveParams.none(),
        ): HttpResponseFor<ExternalStorageConfiguration> =
            retrieve(externalStorageId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ExternalStorageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalStorageConfiguration>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ExternalStorageRetrieveParams
        ): HttpResponseFor<ExternalStorageConfiguration> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            externalStorageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExternalStorageConfiguration> =
            retrieve(externalStorageId, ExternalStorageRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/external_storage`, but is otherwise
         * the same as [ExternalStorageService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ExternalStorageListPage> =
            list(ExternalStorageListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ExternalStorageListParams = ExternalStorageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalStorageListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ExternalStorageListParams = ExternalStorageListParams.none()
        ): HttpResponseFor<ExternalStorageListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ExternalStorageListPage> =
            list(ExternalStorageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/external_storage/{external_storage_id}`, but is otherwise the same as
         * [ExternalStorageService.delete].
         */
        @MustBeClosed
        fun delete(externalStorageId: String): HttpResponseFor<ExternalStorageDeleted> =
            delete(externalStorageId, ExternalStorageDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            externalStorageId: String,
            params: ExternalStorageDeleteParams = ExternalStorageDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalStorageDeleted> =
            delete(params.toBuilder().externalStorageId(externalStorageId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            externalStorageId: String,
            params: ExternalStorageDeleteParams = ExternalStorageDeleteParams.none(),
        ): HttpResponseFor<ExternalStorageDeleted> =
            delete(externalStorageId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ExternalStorageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalStorageDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: ExternalStorageDeleteParams): HttpResponseFor<ExternalStorageDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            externalStorageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExternalStorageDeleted> =
            delete(externalStorageId, ExternalStorageDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/external_storage/{external_storage_id}/validate`, but is otherwise the same
         * as [ExternalStorageService.validate].
         */
        @MustBeClosed
        fun validate(externalStorageId: String): HttpResponseFor<ExternalStorageConfiguration> =
            validate(externalStorageId, ExternalStorageValidateParams.none())

        /** @see validate */
        @MustBeClosed
        fun validate(
            externalStorageId: String,
            params: ExternalStorageValidateParams = ExternalStorageValidateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalStorageConfiguration> =
            validate(
                params.toBuilder().externalStorageId(externalStorageId).build(),
                requestOptions,
            )

        /** @see validate */
        @MustBeClosed
        fun validate(
            externalStorageId: String,
            params: ExternalStorageValidateParams = ExternalStorageValidateParams.none(),
        ): HttpResponseFor<ExternalStorageConfiguration> =
            validate(externalStorageId, params, RequestOptions.none())

        /** @see validate */
        @MustBeClosed
        fun validate(
            params: ExternalStorageValidateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalStorageConfiguration>

        /** @see validate */
        @MustBeClosed
        fun validate(
            params: ExternalStorageValidateParams
        ): HttpResponseFor<ExternalStorageConfiguration> = validate(params, RequestOptions.none())

        /** @see validate */
        @MustBeClosed
        fun validate(
            externalStorageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExternalStorageConfiguration> =
            validate(externalStorageId, ExternalStorageValidateParams.none(), requestOptions)
    }
}
