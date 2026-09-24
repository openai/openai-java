// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.externalstorage.ExternalStorageConfiguration
import com.openai.models.admin.organization.externalstorage.ExternalStorageCreateParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageDeleteParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageDeleted
import com.openai.models.admin.organization.externalstorage.ExternalStorageListPageAsync
import com.openai.models.admin.organization.externalstorage.ExternalStorageListParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageRetrieveParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageValidateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ExternalStorageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExternalStorageServiceAsync

    /** Register one customer-managed external storage configuration. */
    fun create(
        params: ExternalStorageCreateParams
    ): CompletableFuture<ExternalStorageConfiguration> = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ExternalStorageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalStorageConfiguration>

    /** Get one customer-managed external storage configuration. */
    fun retrieve(externalStorageId: String): CompletableFuture<ExternalStorageConfiguration> =
        retrieve(externalStorageId, ExternalStorageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        externalStorageId: String,
        params: ExternalStorageRetrieveParams = ExternalStorageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalStorageConfiguration> =
        retrieve(params.toBuilder().externalStorageId(externalStorageId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        externalStorageId: String,
        params: ExternalStorageRetrieveParams = ExternalStorageRetrieveParams.none(),
    ): CompletableFuture<ExternalStorageConfiguration> =
        retrieve(externalStorageId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ExternalStorageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalStorageConfiguration>

    /** @see retrieve */
    fun retrieve(
        params: ExternalStorageRetrieveParams
    ): CompletableFuture<ExternalStorageConfiguration> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        externalStorageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalStorageConfiguration> =
        retrieve(externalStorageId, ExternalStorageRetrieveParams.none(), requestOptions)

    /** List the organization's customer-managed external storage configurations. */
    fun list(): CompletableFuture<ExternalStorageListPageAsync> =
        list(ExternalStorageListParams.none())

    /** @see list */
    fun list(
        params: ExternalStorageListParams = ExternalStorageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalStorageListPageAsync>

    /** @see list */
    fun list(
        params: ExternalStorageListParams = ExternalStorageListParams.none()
    ): CompletableFuture<ExternalStorageListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ExternalStorageListPageAsync> =
        list(ExternalStorageListParams.none(), requestOptions)

    /**
     * Disconnect a customer-managed external storage configuration. Removing the project's last
     * configuration restores organization-default retention if customer-managed retention was
     * active. Repeating a deletion also completes any interrupted retention update. Cloud storage
     * is unchanged.
     */
    fun delete(externalStorageId: String): CompletableFuture<ExternalStorageDeleted> =
        delete(externalStorageId, ExternalStorageDeleteParams.none())

    /** @see delete */
    fun delete(
        externalStorageId: String,
        params: ExternalStorageDeleteParams = ExternalStorageDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalStorageDeleted> =
        delete(params.toBuilder().externalStorageId(externalStorageId).build(), requestOptions)

    /** @see delete */
    fun delete(
        externalStorageId: String,
        params: ExternalStorageDeleteParams = ExternalStorageDeleteParams.none(),
    ): CompletableFuture<ExternalStorageDeleted> =
        delete(externalStorageId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ExternalStorageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalStorageDeleted>

    /** @see delete */
    fun delete(params: ExternalStorageDeleteParams): CompletableFuture<ExternalStorageDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        externalStorageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalStorageDeleted> =
        delete(externalStorageId, ExternalStorageDeleteParams.none(), requestOptions)

    /** Validate one customer-managed external storage configuration. */
    fun validate(externalStorageId: String): CompletableFuture<ExternalStorageConfiguration> =
        validate(externalStorageId, ExternalStorageValidateParams.none())

    /** @see validate */
    fun validate(
        externalStorageId: String,
        params: ExternalStorageValidateParams = ExternalStorageValidateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalStorageConfiguration> =
        validate(params.toBuilder().externalStorageId(externalStorageId).build(), requestOptions)

    /** @see validate */
    fun validate(
        externalStorageId: String,
        params: ExternalStorageValidateParams = ExternalStorageValidateParams.none(),
    ): CompletableFuture<ExternalStorageConfiguration> =
        validate(externalStorageId, params, RequestOptions.none())

    /** @see validate */
    fun validate(
        params: ExternalStorageValidateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalStorageConfiguration>

    /** @see validate */
    fun validate(
        params: ExternalStorageValidateParams
    ): CompletableFuture<ExternalStorageConfiguration> = validate(params, RequestOptions.none())

    /** @see validate */
    fun validate(
        externalStorageId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalStorageConfiguration> =
        validate(externalStorageId, ExternalStorageValidateParams.none(), requestOptions)

    /**
     * A view of [ExternalStorageServiceAsync] that provides access to raw HTTP responses for each
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
        ): ExternalStorageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/external_storage`, but is otherwise
         * the same as [ExternalStorageServiceAsync.create].
         */
        fun create(
            params: ExternalStorageCreateParams
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ExternalStorageCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>>

        /**
         * Returns a raw HTTP response for `get
         * /organization/external_storage/{external_storage_id}`, but is otherwise the same as
         * [ExternalStorageServiceAsync.retrieve].
         */
        fun retrieve(
            externalStorageId: String
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            retrieve(externalStorageId, ExternalStorageRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            externalStorageId: String,
            params: ExternalStorageRetrieveParams = ExternalStorageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            retrieve(
                params.toBuilder().externalStorageId(externalStorageId).build(),
                requestOptions,
            )

        /** @see retrieve */
        fun retrieve(
            externalStorageId: String,
            params: ExternalStorageRetrieveParams = ExternalStorageRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            retrieve(externalStorageId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ExternalStorageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>>

        /** @see retrieve */
        fun retrieve(
            params: ExternalStorageRetrieveParams
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            externalStorageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            retrieve(externalStorageId, ExternalStorageRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/external_storage`, but is otherwise
         * the same as [ExternalStorageServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ExternalStorageListPageAsync>> =
            list(ExternalStorageListParams.none())

        /** @see list */
        fun list(
            params: ExternalStorageListParams = ExternalStorageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageListPageAsync>>

        /** @see list */
        fun list(
            params: ExternalStorageListParams = ExternalStorageListParams.none()
        ): CompletableFuture<HttpResponseFor<ExternalStorageListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ExternalStorageListPageAsync>> =
            list(ExternalStorageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /organization/external_storage/{external_storage_id}`, but is otherwise the same as
         * [ExternalStorageServiceAsync.delete].
         */
        fun delete(
            externalStorageId: String
        ): CompletableFuture<HttpResponseFor<ExternalStorageDeleted>> =
            delete(externalStorageId, ExternalStorageDeleteParams.none())

        /** @see delete */
        fun delete(
            externalStorageId: String,
            params: ExternalStorageDeleteParams = ExternalStorageDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageDeleted>> =
            delete(params.toBuilder().externalStorageId(externalStorageId).build(), requestOptions)

        /** @see delete */
        fun delete(
            externalStorageId: String,
            params: ExternalStorageDeleteParams = ExternalStorageDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageDeleted>> =
            delete(externalStorageId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ExternalStorageDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageDeleted>>

        /** @see delete */
        fun delete(
            params: ExternalStorageDeleteParams
        ): CompletableFuture<HttpResponseFor<ExternalStorageDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            externalStorageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalStorageDeleted>> =
            delete(externalStorageId, ExternalStorageDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/external_storage/{external_storage_id}/validate`, but is otherwise the same
         * as [ExternalStorageServiceAsync.validate].
         */
        fun validate(
            externalStorageId: String
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            validate(externalStorageId, ExternalStorageValidateParams.none())

        /** @see validate */
        fun validate(
            externalStorageId: String,
            params: ExternalStorageValidateParams = ExternalStorageValidateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            validate(
                params.toBuilder().externalStorageId(externalStorageId).build(),
                requestOptions,
            )

        /** @see validate */
        fun validate(
            externalStorageId: String,
            params: ExternalStorageValidateParams = ExternalStorageValidateParams.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            validate(externalStorageId, params, RequestOptions.none())

        /** @see validate */
        fun validate(
            params: ExternalStorageValidateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>>

        /** @see validate */
        fun validate(
            params: ExternalStorageValidateParams
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            validate(params, RequestOptions.none())

        /** @see validate */
        fun validate(
            externalStorageId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> =
            validate(externalStorageId, ExternalStorageValidateParams.none(), requestOptions)
    }
}
