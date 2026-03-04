// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.checkpoints

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreatePageAsync
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteResponse
import com.openai.models.finetuning.checkpoints.permissions.PermissionListPageAsync
import com.openai.models.finetuning.checkpoints.permissions.PermissionListParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Manage fine-tuning jobs to tailor a model to your specific training data. */
interface PermissionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PermissionServiceAsync

    /**
     * **NOTE:** Calling this endpoint requires an [admin API key](../admin-api-keys).
     *
     * This enables organization owners to share fine-tuned models with other projects in their
     * organization.
     */
    fun create(
        fineTunedModelCheckpoint: String,
        params: PermissionCreateParams,
    ): CompletableFuture<PermissionCreatePageAsync> =
        create(fineTunedModelCheckpoint, params, RequestOptions.none())

    /** @see create */
    fun create(
        fineTunedModelCheckpoint: String,
        params: PermissionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionCreatePageAsync> =
        create(
            params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
            requestOptions,
        )

    /** @see create */
    fun create(params: PermissionCreateParams): CompletableFuture<PermissionCreatePageAsync> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: PermissionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionCreatePageAsync>

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to view all permissions for a fine-tuned model
     * checkpoint.
     */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(fineTunedModelCheckpoint: String): CompletableFuture<PermissionRetrieveResponse> =
        retrieve(fineTunedModelCheckpoint, PermissionRetrieveParams.none())

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(
        fineTunedModelCheckpoint: String,
        params: PermissionRetrieveParams = PermissionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionRetrieveResponse> =
        retrieve(
            params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
            requestOptions,
        )

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(
        fineTunedModelCheckpoint: String,
        params: PermissionRetrieveParams = PermissionRetrieveParams.none(),
    ): CompletableFuture<PermissionRetrieveResponse> =
        retrieve(fineTunedModelCheckpoint, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(
        params: PermissionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionRetrieveResponse>

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(params: PermissionRetrieveParams): CompletableFuture<PermissionRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(
        fineTunedModelCheckpoint: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PermissionRetrieveResponse> =
        retrieve(fineTunedModelCheckpoint, PermissionRetrieveParams.none(), requestOptions)

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to view all permissions for a fine-tuned model
     * checkpoint.
     */
    fun list(fineTunedModelCheckpoint: String): CompletableFuture<PermissionListPageAsync> =
        list(fineTunedModelCheckpoint, PermissionListParams.none())

    /** @see list */
    fun list(
        fineTunedModelCheckpoint: String,
        params: PermissionListParams = PermissionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionListPageAsync> =
        list(
            params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
            requestOptions,
        )

    /** @see list */
    fun list(
        fineTunedModelCheckpoint: String,
        params: PermissionListParams = PermissionListParams.none(),
    ): CompletableFuture<PermissionListPageAsync> =
        list(fineTunedModelCheckpoint, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: PermissionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionListPageAsync>

    /** @see list */
    fun list(params: PermissionListParams): CompletableFuture<PermissionListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        fineTunedModelCheckpoint: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PermissionListPageAsync> =
        list(fineTunedModelCheckpoint, PermissionListParams.none(), requestOptions)

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to delete a permission for a fine-tuned model
     * checkpoint.
     */
    fun delete(
        permissionId: String,
        params: PermissionDeleteParams,
    ): CompletableFuture<PermissionDeleteResponse> =
        delete(permissionId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        permissionId: String,
        params: PermissionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionDeleteResponse> =
        delete(params.toBuilder().permissionId(permissionId).build(), requestOptions)

    /** @see delete */
    fun delete(params: PermissionDeleteParams): CompletableFuture<PermissionDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: PermissionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionDeleteResponse>

    /**
     * A view of [PermissionServiceAsync] that provides access to raw HTTP responses for each
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
        ): PermissionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionServiceAsync.create].
         */
        fun create(
            fineTunedModelCheckpoint: String,
            params: PermissionCreateParams,
        ): CompletableFuture<HttpResponseFor<PermissionCreatePageAsync>> =
            create(fineTunedModelCheckpoint, params, RequestOptions.none())

        /** @see create */
        fun create(
            fineTunedModelCheckpoint: String,
            params: PermissionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionCreatePageAsync>> =
            create(
                params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
                requestOptions,
            )

        /** @see create */
        fun create(
            params: PermissionCreateParams
        ): CompletableFuture<HttpResponseFor<PermissionCreatePageAsync>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: PermissionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionCreatePageAsync>>

        /**
         * Returns a raw HTTP response for `get
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionServiceAsync.retrieve].
         */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        fun retrieve(
            fineTunedModelCheckpoint: String
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>> =
            retrieve(fineTunedModelCheckpoint, PermissionRetrieveParams.none())

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        fun retrieve(
            fineTunedModelCheckpoint: String,
            params: PermissionRetrieveParams = PermissionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>> =
            retrieve(
                params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
                requestOptions,
            )

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        fun retrieve(
            fineTunedModelCheckpoint: String,
            params: PermissionRetrieveParams = PermissionRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>> =
            retrieve(fineTunedModelCheckpoint, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        fun retrieve(
            params: PermissionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>>

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        fun retrieve(
            params: PermissionRetrieveParams
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        fun retrieve(
            fineTunedModelCheckpoint: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>> =
            retrieve(fineTunedModelCheckpoint, PermissionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionServiceAsync.list].
         */
        fun list(
            fineTunedModelCheckpoint: String
        ): CompletableFuture<HttpResponseFor<PermissionListPageAsync>> =
            list(fineTunedModelCheckpoint, PermissionListParams.none())

        /** @see list */
        fun list(
            fineTunedModelCheckpoint: String,
            params: PermissionListParams = PermissionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionListPageAsync>> =
            list(
                params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
                requestOptions,
            )

        /** @see list */
        fun list(
            fineTunedModelCheckpoint: String,
            params: PermissionListParams = PermissionListParams.none(),
        ): CompletableFuture<HttpResponseFor<PermissionListPageAsync>> =
            list(fineTunedModelCheckpoint, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: PermissionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionListPageAsync>>

        /** @see list */
        fun list(
            params: PermissionListParams
        ): CompletableFuture<HttpResponseFor<PermissionListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            fineTunedModelCheckpoint: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PermissionListPageAsync>> =
            list(fineTunedModelCheckpoint, PermissionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions/{permission_id}`, but
         * is otherwise the same as [PermissionServiceAsync.delete].
         */
        fun delete(
            permissionId: String,
            params: PermissionDeleteParams,
        ): CompletableFuture<HttpResponseFor<PermissionDeleteResponse>> =
            delete(permissionId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            permissionId: String,
            params: PermissionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionDeleteResponse>> =
            delete(params.toBuilder().permissionId(permissionId).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: PermissionDeleteParams
        ): CompletableFuture<HttpResponseFor<PermissionDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: PermissionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionDeleteResponse>>
    }
}
