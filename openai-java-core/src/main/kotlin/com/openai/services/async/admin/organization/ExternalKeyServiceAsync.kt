// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.externalkeys.ExternalKey
import com.openai.models.admin.organization.externalkeys.ExternalKeyCreateParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyDeleteParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyListPageAsync
import com.openai.models.admin.organization.externalkeys.ExternalKeyListParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyRetrieveParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyValidateParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyValidateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ExternalKeyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExternalKeyServiceAsync

    /** Add an external key config for an organization */
    fun create(params: ExternalKeyCreateParams): CompletableFuture<ExternalKey> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ExternalKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKey>

    /** @see create */
    fun create(
        body: ExternalKeyCreateParams.Body,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKey> =
        create(ExternalKeyCreateParams.builder().body(body).build(), requestOptions)

    /** @see create */
    fun create(body: ExternalKeyCreateParams.Body): CompletableFuture<ExternalKey> =
        create(body, RequestOptions.none())

    /** Retrieve a stored external key registration for the user's organization. */
    fun retrieve(externalKeyId: String): CompletableFuture<ExternalKey> =
        retrieve(externalKeyId, ExternalKeyRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        externalKeyId: String,
        params: ExternalKeyRetrieveParams = ExternalKeyRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKey> =
        retrieve(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        externalKeyId: String,
        params: ExternalKeyRetrieveParams = ExternalKeyRetrieveParams.none(),
    ): CompletableFuture<ExternalKey> = retrieve(externalKeyId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ExternalKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKey>

    /** @see retrieve */
    fun retrieve(params: ExternalKeyRetrieveParams): CompletableFuture<ExternalKey> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        externalKeyId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalKey> =
        retrieve(externalKeyId, ExternalKeyRetrieveParams.none(), requestOptions)

    /** List the external key configs registered on the user's organization */
    fun list(): CompletableFuture<ExternalKeyListPageAsync> = list(ExternalKeyListParams.none())

    /** @see list */
    fun list(
        params: ExternalKeyListParams = ExternalKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKeyListPageAsync>

    /** @see list */
    fun list(
        params: ExternalKeyListParams = ExternalKeyListParams.none()
    ): CompletableFuture<ExternalKeyListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ExternalKeyListPageAsync> =
        list(ExternalKeyListParams.none(), requestOptions)

    /** Delete an external key config for the user's organization */
    fun delete(externalKeyId: String): CompletableFuture<ExternalKey> =
        delete(externalKeyId, ExternalKeyDeleteParams.none())

    /** @see delete */
    fun delete(
        externalKeyId: String,
        params: ExternalKeyDeleteParams = ExternalKeyDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKey> =
        delete(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

    /** @see delete */
    fun delete(
        externalKeyId: String,
        params: ExternalKeyDeleteParams = ExternalKeyDeleteParams.none(),
    ): CompletableFuture<ExternalKey> = delete(externalKeyId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ExternalKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKey>

    /** @see delete */
    fun delete(params: ExternalKeyDeleteParams): CompletableFuture<ExternalKey> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        externalKeyId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalKey> =
        delete(externalKeyId, ExternalKeyDeleteParams.none(), requestOptions)

    /** Validate an external key config for the user's organization */
    fun validate(externalKeyId: String): CompletableFuture<ExternalKeyValidateResponse> =
        validate(externalKeyId, ExternalKeyValidateParams.none())

    /** @see validate */
    fun validate(
        externalKeyId: String,
        params: ExternalKeyValidateParams = ExternalKeyValidateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKeyValidateResponse> =
        validate(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

    /** @see validate */
    fun validate(
        externalKeyId: String,
        params: ExternalKeyValidateParams = ExternalKeyValidateParams.none(),
    ): CompletableFuture<ExternalKeyValidateResponse> =
        validate(externalKeyId, params, RequestOptions.none())

    /** @see validate */
    fun validate(
        params: ExternalKeyValidateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExternalKeyValidateResponse>

    /** @see validate */
    fun validate(
        params: ExternalKeyValidateParams
    ): CompletableFuture<ExternalKeyValidateResponse> = validate(params, RequestOptions.none())

    /** @see validate */
    fun validate(
        externalKeyId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalKeyValidateResponse> =
        validate(externalKeyId, ExternalKeyValidateParams.none(), requestOptions)

    /**
     * A view of [ExternalKeyServiceAsync] that provides access to raw HTTP responses for each
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
        ): ExternalKeyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/external_keys`, but is otherwise the
         * same as [ExternalKeyServiceAsync.create].
         */
        fun create(
            params: ExternalKeyCreateParams
        ): CompletableFuture<HttpResponseFor<ExternalKey>> = create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ExternalKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKey>>

        /** @see create */
        fun create(
            body: ExternalKeyCreateParams.Body,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKey>> =
            create(ExternalKeyCreateParams.builder().body(body).build(), requestOptions)

        /** @see create */
        fun create(
            body: ExternalKeyCreateParams.Body
        ): CompletableFuture<HttpResponseFor<ExternalKey>> = create(body, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /organization/external_keys/{external_key_id}`, but
         * is otherwise the same as [ExternalKeyServiceAsync.retrieve].
         */
        fun retrieve(externalKeyId: String): CompletableFuture<HttpResponseFor<ExternalKey>> =
            retrieve(externalKeyId, ExternalKeyRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            externalKeyId: String,
            params: ExternalKeyRetrieveParams = ExternalKeyRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKey>> =
            retrieve(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            externalKeyId: String,
            params: ExternalKeyRetrieveParams = ExternalKeyRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKey>> =
            retrieve(externalKeyId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ExternalKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKey>>

        /** @see retrieve */
        fun retrieve(
            params: ExternalKeyRetrieveParams
        ): CompletableFuture<HttpResponseFor<ExternalKey>> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            externalKeyId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalKey>> =
            retrieve(externalKeyId, ExternalKeyRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/external_keys`, but is otherwise the
         * same as [ExternalKeyServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ExternalKeyListPageAsync>> =
            list(ExternalKeyListParams.none())

        /** @see list */
        fun list(
            params: ExternalKeyListParams = ExternalKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKeyListPageAsync>>

        /** @see list */
        fun list(
            params: ExternalKeyListParams = ExternalKeyListParams.none()
        ): CompletableFuture<HttpResponseFor<ExternalKeyListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ExternalKeyListPageAsync>> =
            list(ExternalKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/external_keys/{external_key_id}`,
         * but is otherwise the same as [ExternalKeyServiceAsync.delete].
         */
        fun delete(externalKeyId: String): CompletableFuture<HttpResponseFor<ExternalKey>> =
            delete(externalKeyId, ExternalKeyDeleteParams.none())

        /** @see delete */
        fun delete(
            externalKeyId: String,
            params: ExternalKeyDeleteParams = ExternalKeyDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKey>> =
            delete(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

        /** @see delete */
        fun delete(
            externalKeyId: String,
            params: ExternalKeyDeleteParams = ExternalKeyDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKey>> =
            delete(externalKeyId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ExternalKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKey>>

        /** @see delete */
        fun delete(
            params: ExternalKeyDeleteParams
        ): CompletableFuture<HttpResponseFor<ExternalKey>> = delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            externalKeyId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalKey>> =
            delete(externalKeyId, ExternalKeyDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/external_keys/{external_key_id}/validate`, but is otherwise the same as
         * [ExternalKeyServiceAsync.validate].
         */
        fun validate(
            externalKeyId: String
        ): CompletableFuture<HttpResponseFor<ExternalKeyValidateResponse>> =
            validate(externalKeyId, ExternalKeyValidateParams.none())

        /** @see validate */
        fun validate(
            externalKeyId: String,
            params: ExternalKeyValidateParams = ExternalKeyValidateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKeyValidateResponse>> =
            validate(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

        /** @see validate */
        fun validate(
            externalKeyId: String,
            params: ExternalKeyValidateParams = ExternalKeyValidateParams.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKeyValidateResponse>> =
            validate(externalKeyId, params, RequestOptions.none())

        /** @see validate */
        fun validate(
            params: ExternalKeyValidateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExternalKeyValidateResponse>>

        /** @see validate */
        fun validate(
            params: ExternalKeyValidateParams
        ): CompletableFuture<HttpResponseFor<ExternalKeyValidateResponse>> =
            validate(params, RequestOptions.none())

        /** @see validate */
        fun validate(
            externalKeyId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalKeyValidateResponse>> =
            validate(externalKeyId, ExternalKeyValidateParams.none(), requestOptions)
    }
}
