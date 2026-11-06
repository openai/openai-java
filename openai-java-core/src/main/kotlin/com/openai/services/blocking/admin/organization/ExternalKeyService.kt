// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.externalkeys.ExternalKey
import com.openai.models.admin.organization.externalkeys.ExternalKeyCreateParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyDeleteParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyListPage
import com.openai.models.admin.organization.externalkeys.ExternalKeyListParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyRetrieveParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyValidateParams
import com.openai.models.admin.organization.externalkeys.ExternalKeyValidateResponse
import java.util.function.Consumer

interface ExternalKeyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExternalKeyService

    /** Add an external key config for an organization */
    fun create(params: ExternalKeyCreateParams): ExternalKey = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ExternalKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKey

    /** @see create */
    fun create(
        body: ExternalKeyCreateParams.Body,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKey = create(ExternalKeyCreateParams.builder().body(body).build(), requestOptions)

    /** @see create */
    fun create(body: ExternalKeyCreateParams.Body): ExternalKey =
        create(body, RequestOptions.none())

    /** Retrieve a stored external key registration for the user's organization. */
    fun retrieve(externalKeyId: String): ExternalKey =
        retrieve(externalKeyId, ExternalKeyRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        externalKeyId: String,
        params: ExternalKeyRetrieveParams = ExternalKeyRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKey =
        retrieve(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        externalKeyId: String,
        params: ExternalKeyRetrieveParams = ExternalKeyRetrieveParams.none(),
    ): ExternalKey = retrieve(externalKeyId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ExternalKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKey

    /** @see retrieve */
    fun retrieve(params: ExternalKeyRetrieveParams): ExternalKey =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(externalKeyId: String, requestOptions: RequestOptions): ExternalKey =
        retrieve(externalKeyId, ExternalKeyRetrieveParams.none(), requestOptions)

    /** List the external key configs registered on the user's organization */
    fun list(): ExternalKeyListPage = list(ExternalKeyListParams.none())

    /** @see list */
    fun list(
        params: ExternalKeyListParams = ExternalKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKeyListPage

    /** @see list */
    fun list(params: ExternalKeyListParams = ExternalKeyListParams.none()): ExternalKeyListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ExternalKeyListPage =
        list(ExternalKeyListParams.none(), requestOptions)

    /** Delete an external key config for the user's organization */
    fun delete(externalKeyId: String): ExternalKey =
        delete(externalKeyId, ExternalKeyDeleteParams.none())

    /** @see delete */
    fun delete(
        externalKeyId: String,
        params: ExternalKeyDeleteParams = ExternalKeyDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKey = delete(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

    /** @see delete */
    fun delete(
        externalKeyId: String,
        params: ExternalKeyDeleteParams = ExternalKeyDeleteParams.none(),
    ): ExternalKey = delete(externalKeyId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ExternalKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKey

    /** @see delete */
    fun delete(params: ExternalKeyDeleteParams): ExternalKey = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(externalKeyId: String, requestOptions: RequestOptions): ExternalKey =
        delete(externalKeyId, ExternalKeyDeleteParams.none(), requestOptions)

    /** Validate an external key config for the user's organization */
    fun validate(externalKeyId: String): ExternalKeyValidateResponse =
        validate(externalKeyId, ExternalKeyValidateParams.none())

    /** @see validate */
    fun validate(
        externalKeyId: String,
        params: ExternalKeyValidateParams = ExternalKeyValidateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKeyValidateResponse =
        validate(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

    /** @see validate */
    fun validate(
        externalKeyId: String,
        params: ExternalKeyValidateParams = ExternalKeyValidateParams.none(),
    ): ExternalKeyValidateResponse = validate(externalKeyId, params, RequestOptions.none())

    /** @see validate */
    fun validate(
        params: ExternalKeyValidateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExternalKeyValidateResponse

    /** @see validate */
    fun validate(params: ExternalKeyValidateParams): ExternalKeyValidateResponse =
        validate(params, RequestOptions.none())

    /** @see validate */
    fun validate(
        externalKeyId: String,
        requestOptions: RequestOptions,
    ): ExternalKeyValidateResponse =
        validate(externalKeyId, ExternalKeyValidateParams.none(), requestOptions)

    /**
     * A view of [ExternalKeyService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ExternalKeyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /organization/external_keys`, but is otherwise the
         * same as [ExternalKeyService.create].
         */
        @MustBeClosed
        fun create(params: ExternalKeyCreateParams): HttpResponseFor<ExternalKey> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ExternalKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKey>

        /** @see create */
        @MustBeClosed
        fun create(
            body: ExternalKeyCreateParams.Body,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKey> =
            create(ExternalKeyCreateParams.builder().body(body).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(body: ExternalKeyCreateParams.Body): HttpResponseFor<ExternalKey> =
            create(body, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /organization/external_keys/{external_key_id}`, but
         * is otherwise the same as [ExternalKeyService.retrieve].
         */
        @MustBeClosed
        fun retrieve(externalKeyId: String): HttpResponseFor<ExternalKey> =
            retrieve(externalKeyId, ExternalKeyRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            externalKeyId: String,
            params: ExternalKeyRetrieveParams = ExternalKeyRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKey> =
            retrieve(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            externalKeyId: String,
            params: ExternalKeyRetrieveParams = ExternalKeyRetrieveParams.none(),
        ): HttpResponseFor<ExternalKey> = retrieve(externalKeyId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ExternalKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKey>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ExternalKeyRetrieveParams): HttpResponseFor<ExternalKey> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            externalKeyId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExternalKey> =
            retrieve(externalKeyId, ExternalKeyRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /organization/external_keys`, but is otherwise the
         * same as [ExternalKeyService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ExternalKeyListPage> = list(ExternalKeyListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ExternalKeyListParams = ExternalKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKeyListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ExternalKeyListParams = ExternalKeyListParams.none()
        ): HttpResponseFor<ExternalKeyListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ExternalKeyListPage> =
            list(ExternalKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /organization/external_keys/{external_key_id}`,
         * but is otherwise the same as [ExternalKeyService.delete].
         */
        @MustBeClosed
        fun delete(externalKeyId: String): HttpResponseFor<ExternalKey> =
            delete(externalKeyId, ExternalKeyDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            externalKeyId: String,
            params: ExternalKeyDeleteParams = ExternalKeyDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKey> =
            delete(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            externalKeyId: String,
            params: ExternalKeyDeleteParams = ExternalKeyDeleteParams.none(),
        ): HttpResponseFor<ExternalKey> = delete(externalKeyId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ExternalKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKey>

        /** @see delete */
        @MustBeClosed
        fun delete(params: ExternalKeyDeleteParams): HttpResponseFor<ExternalKey> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            externalKeyId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExternalKey> =
            delete(externalKeyId, ExternalKeyDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /organization/external_keys/{external_key_id}/validate`, but is otherwise the same as
         * [ExternalKeyService.validate].
         */
        @MustBeClosed
        fun validate(externalKeyId: String): HttpResponseFor<ExternalKeyValidateResponse> =
            validate(externalKeyId, ExternalKeyValidateParams.none())

        /** @see validate */
        @MustBeClosed
        fun validate(
            externalKeyId: String,
            params: ExternalKeyValidateParams = ExternalKeyValidateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKeyValidateResponse> =
            validate(params.toBuilder().externalKeyId(externalKeyId).build(), requestOptions)

        /** @see validate */
        @MustBeClosed
        fun validate(
            externalKeyId: String,
            params: ExternalKeyValidateParams = ExternalKeyValidateParams.none(),
        ): HttpResponseFor<ExternalKeyValidateResponse> =
            validate(externalKeyId, params, RequestOptions.none())

        /** @see validate */
        @MustBeClosed
        fun validate(
            params: ExternalKeyValidateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExternalKeyValidateResponse>

        /** @see validate */
        @MustBeClosed
        fun validate(
            params: ExternalKeyValidateParams
        ): HttpResponseFor<ExternalKeyValidateResponse> = validate(params, RequestOptions.none())

        /** @see validate */
        @MustBeClosed
        fun validate(
            externalKeyId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExternalKeyValidateResponse> =
            validate(externalKeyId, ExternalKeyValidateParams.none(), requestOptions)
    }
}
